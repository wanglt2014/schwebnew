package com.et59.cus.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.et59.cus.action.BaseAction;

public class FileAction extends BaseAction {

	public static final int BUFFER_SIZE = 2 * 1024;
	// public File upload;
	public String name;
	public List<String> names;
	public int chunk;
	public int chunks;
	public int id = -1;
	public String result;
	public File fileData;
	public String filetype;
	private String uploadFileName;
	private String uploadContentType;
	public String uploader_pic_tmpname;
	public String uploader_pic_name;

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public File getFileData() {
		return fileData;
	}

	public void setFileData(File fileData) {
		this.fileData = fileData;
	}

	// public File getUpload() {
	// return upload;
	// }
	//
	// public void setUpload(File upload) {
	// this.upload = upload;
	// }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true),
						BUFFER_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
			}
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String uploadForTeacher() throws Exception {
		// boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// System.out.println(isMultipart + "***************");
		String dstPath = getSavePathForTeacher();
		File dstFile = new File(dstPath);

		if (!dstFile.exists()) {
			dstFile.mkdirs();
		}
		dstPath = dstPath + "\\" + this.getName();
		File dst = new File(dstPath);
		copy(this.fileData, dst);
		System.out.println("上传文件路径:" + dstPath + " " + " 临时文件名："
				+ this.getName());
		return SUCCESS;
	}

	public String uploadForOther() throws Exception {
		String dstPath = getSavePathForOther();
		File dstFile = new File(dstPath);

		if (!dstFile.exists()) {
			dstFile.mkdirs();
		}
		dstPath = dstPath + "\\" + this.getName();
		File dst = new File(dstPath);
		copy(this.fileData, dst);
		System.out.println("上传文件:" + uploadFileName + " 临时文件名："
				+ uploadContentType + " " + chunk + " " + chunks + "路径："
				+ dstPath);
		if (chunk == chunks - 1) {// 将文件分成多少分，比如：25M的文件2M一个分成13个。chunk=12，chunks=13
			// 完成一整个文件;
			// System.out.println("上传文件:" + uploadFileName + " 临时文件名："
			// + uploadContentType + " " + chunk + " " + chunks + "路径："
			// + dstPath);
		}

		return SUCCESS;
	}

	public String uploadForArticle() throws Exception {
		String dstPath = getSavePathForArticle();
		File dstFile = new File(dstPath);

		if (!dstFile.exists()) {
			dstFile.mkdirs();
		}
		dstPath = dstPath + "\\" + this.getName();
		File dst = new File(dstPath);
		copy(this.fileData, dst);
		System.out.println("上传文件:" + uploadFileName + " 临时文件名："
				+ uploadContentType + " " + chunk + " " + chunks + "路径："
				+ dstPath);
		if (chunk == chunks - 1) {// 将文件分成多少分，比如：25M的文件2M一个分成13个。chunk=12，chunks=13
			// 完成一整个文件;
			// System.out.println("上传文件:" + uploadFileName + " 临时文件名："
			// + uploadContentType + " " + chunk + " " + chunks + "路径："
			// + dstPath);
		}

		return SUCCESS;
	}

	/**
	 * 获取师资队伍保存路径
	 * 
	 * @return
	 */
	public static String getSavePathForTeacher() {
		return getSavePath() + Constant.PATH_TEACHER;
	}

	/**
	 * 获取其他文件保存路径
	 * 
	 * @return
	 */
	public static String getSavePathForOther() {
		return getSavePath() + Constant.PATH_OTHER;
	}

	/**
	 * 获取文章文件保存路径
	 * 
	 * @return
	 */
	public static String getSavePathForArticle() {
		return getSavePath() + Constant.PATH_ARTICLE;
	}

	private static String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath("") + "\\";
		// return Constant.FILE_SAVE_PATH+"\\";
	}

	// public String submit() {
	// String filePath = ServletActionContext.getServletContext().getRealPath(
	// this.getSavePath());
	// System.out.println("保存文件路径： " + filePath);
	//
	// HttpServletRequest request = ServletActionContext.getRequest();
	//
	// result = "";
	// int count = Integer.parseInt(request.getParameter("uploader_count"));
	// for (int i = 0; i < count; i++) {
	// uploadFileName = request.getParameter("uploader_" + i + "_name");
	// name = request.getParameter("uploader_" + i + "_tmpname");
	// System.out.println(uploadFileName + " " + name);
	// try {
	// //do something with file;
	// result += uploadFileName + "导入完成. <br />";
	// } catch(Exception e) {
	// result += uploadFileName + "导入失败:" + e.getMessage() + ". <br />";
	// e.printStackTrace();
	// }
	// }
	// return SUCCESS;
	// }

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<String> getNames() {
		return names;
	}

	// public File getUpload() {
	// return upload;
	// }
	//
	// public void setUpload(File upload) {
	// this.upload = upload;
	// }

	public int getChunk() {
		return chunk;
	}

	public void setChunk(int chunk) {
		this.chunk = chunk;
	}

	public int getChunks() {
		return chunks;
	}

	public void setChunks(int chunks) {
		this.chunks = chunks;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

}
