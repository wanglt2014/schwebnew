package com.et59.cus.action;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;

/**
 * UEditor文件上传辅助类
 *
 */
public class UploaderAction extends BaseAction {
	private Logger log = Logger.getLogger(UploaderAction.class);
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	// 输出文件地址
	private String url = "";
	// 上传文件名
	private String fileName = "";
	// 状态
	private String state = "";
	// 文件类型
	private String type = "";
	// 原始文件名
	private String originalName = "";
	// 文件大小
	private long size = 0;

	// private HttpServletRequest request = null;
	private String title = "";
	private String realpath_image = "\\cus\\image\\";
	private File upfile;

	// 保存路径
	private String savePath = "upload";
	// 文件允许格式
	private String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",
			".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
	// 文件大小限制，单位KB
	private int maxSize = 10000;

	private HashMap<String, String> errorInfo = new HashMap<String, String>();

	public void init() {
		HashMap<String, String> tmp = this.errorInfo;
		tmp.put("SUCCESS", "SUCCESS"); // 默认成功
		tmp.put("NOFILE", "未包含文件上传域");
		tmp.put("TYPE", "不允许的文件格式");
		tmp.put("SIZE", "文件大小超出限制");
		tmp.put("ENTYPE", "请求类型ENTYPE错误");
		tmp.put("REQUEST", "上传请求异常");
		tmp.put("IO", "IO异常");
		tmp.put("DIR", "目录创建失败");
		tmp.put("UNKNOWN", "未知错误");

	}

	/**
	 * 执行上传操作
	 */
	public void excuteupLoad() {
		try {
			log.info("upfile:" + upfile);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			init();
			upload(request);
			String callback = request.getParameter("callback");
			log.info("callback:" + callback);
			String result = "{\"name\":\"" + getFileName()
					+ "\", \"originalName\": \"" + getOriginalName()
					+ "\", \"size\": " + getSize() + ", \"state\": \""
					+ getState() + "\", \"type\": \"" + getType()
					+ "\", \"url\": \"" + getUrl() + "\"}";
			log.info("result:" + result);
			result = result.replaceAll("\\\\", "\\\\");
			response.setContentType("text/html");
			if (callback == null) {
				response.getWriter().print(result);
			} else {
				response.getWriter().print(
						"<script>" + callback + "(" + result + ")</script>");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传图片chu
	 * 
	 * @param request
	 * @throws Exception
	 */
	public void upload(HttpServletRequest request) throws Exception {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			this.state = this.errorInfo.get("NOFILE");
			return;
		}
		String savePath = this.getFolder(this.savePath);
		log.info("savePath:" + savePath);
		try {
			if (null != upfile) {
				this.originalName = upfile.getName().substring(
						upfile.getName().lastIndexOf(
								System.getProperty("file.separator")) + 1);
				if (!this.checkFileType(this.originalName)) {
					this.state = this.errorInfo.get("TYPE");
				}
				this.fileName = this.getName(this.originalName);
				this.type = this.getFileExt(this.fileName);
				this.url = savePath + "/" + this.fileName;
				log.info("url:" + url);
				FileInputStream in = new FileInputStream(upfile);
				File file = new File(this.getPhysicalPath(this.url));
				FileOutputStream out = new FileOutputStream(file);
				BufferedOutputStream output = new BufferedOutputStream(out);
				Streams.copy(in, output, true);
				this.state = this.errorInfo.get("SUCCESS");
				this.size = file.length();
				// UE中只会处理单张上传，完成后即退出
			} else {
				String fname = upfile.getName(); // 只处理title，其余表单请自行处理
				FileInputStream in = new FileInputStream(upfile);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				StringBuffer result = new StringBuffer();
				while (reader.ready()) {
					result.append((char) reader.read());
				}
				this.title = new String(result.toString().getBytes(), "utf-8");
				reader.close();

			}
		} catch (Exception e) {
			this.state = this.errorInfo.get("UNKNOWN");
		}
	}

	/**
	 * 接受并保存以base64格式上传的文件
	 * 
	 * @param fieldName
	 */
	public void uploadBase64(String fieldName) {
		String savePath = this.getFolder(this.savePath);
		String base64Data = this.request.getParameter(fieldName);
		this.fileName = this.getName("test.png");
		this.url = savePath + "/" + this.fileName;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File outFile = new File(this.getPhysicalPath(this.url));
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(base64Data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
			this.state = this.errorInfo.get("SUCCESS");
		} catch (Exception e) {
			this.state = this.errorInfo.get("IO");
		}
	}

	/**
	 * 文件类型判断
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 依据原始文件名生成新文件名
	 * 
	 * @return
	 */
	private String getName(String fileName) {
		Random random = new Random();
		return this.fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + this.getFileExt(fileName);
	}

	/**
	 * 根据字符串创建本地目录 并按照日期建立子目录返回
	 * 
	 * @param path
	 * @return
	 */
	private String getFolder(String path) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		path += "/" + formater.format(new Date());
		File dir = new File(this.getPhysicalPath(path));
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				this.state = this.errorInfo.get("DIR");
				return "";
			}
		}
		return path;
	}

	/**
	 * 根据传入的虚拟路径获取物理路径
	 * 
	 * @param path
	 * @return
	 */
	private String getPhysicalPath(String path) {
		String servletPath = this.request.getServletPath();
		String realPath = this.request.getSession().getServletContext()
				.getRealPath(servletPath);
		log.info("realPath：" + realPath);
		return new File(realPath).getParent() + "/" + path;
		// return new File(realpath_image) +"/" +path;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setAllowFiles(String[] allowFiles) {
		this.allowFiles = allowFiles;
	}

	public void setMaxSize(int size) {
		this.maxSize = size;
	}

	public long getSize() {
		return this.size;
	}

	public String getUrl() {
		return this.url;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getState() {
		return this.state;
	}

	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String getOriginalName() {
		return this.originalName;
	}

	public File getUpfile() {
		return upfile;
	}

	public void setUpfile(File upfile) {
		this.upfile = upfile;
	}

}
