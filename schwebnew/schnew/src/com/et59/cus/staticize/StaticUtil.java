package com.et59.cus.staticize;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * <p>
 * Title: Test.java
 * </p>
 * <p>
 * Description: 静态
 * </p>
 * 
 * @date 2014-5-23 上午11:00:23
 * @version 2.0
 *
 */
public class StaticUtil {
	/**
	 * 将信息转化为静态html
	 * 
	 * @param sUrl
	 *            动态信息访问URL
	 * @param charset
	 *            编码类型
	 * @param sSavePath
	 *            存储为静态文件的目录
	 * @param sHtmlFile
	 *            生成的静态文件名,可以按信息的唯一ID+.html命名
	 * @throws IOException
	 */
	public static void convert2Html(String sUrl, String charset,
			String sSavePath, String sHtmlFile) throws IOException {
		int HttpResult;
		URL url = new URL(sUrl);
		URLConnection urlconn = url.openConnection();
		// 抽象类 URLConnection
		// 是所有类的超类，它代表应用程序和 URL
		// 之间的通信链接，通过在 URL 上调用
		// openConnection 方法创建连接对象
		urlconn.connect(); // 使用 connect 方法建立到远程对象的实际连接
		HttpURLConnection httpconn = (HttpURLConnection) urlconn;
		// 每个
		// HttpURLConnection
		// 实例都可用于生成单个请求，
		// 但是其他实例可以透明地共享连接到
		// HTTP 服务器的基础网络
		HttpResult = httpconn.getResponseCode();
		// getResponseCode可以从 HTTP
		// 响应消息获取状态码
		if (HttpResult != HttpURLConnection.HTTP_OK) {
		} else {
			InputStreamReader isr = new InputStreamReader(
					httpconn.getInputStream(), charset);
			BufferedReader in = new BufferedReader(isr);
			String inputLine;
			if (!sSavePath.endsWith("/")) {
				sSavePath += "/";
			}
			FileOutputStream fout = new FileOutputStream(sSavePath + sHtmlFile);
			while ((inputLine = in.readLine()) != null) {
				// System.out.println(inputLine);
				fout.write((inputLine + "\r\n").getBytes(charset));
			}
			in.close();
			fout.close();
		}
	}

	public static void main(String[] args) throws IOException {
		/*
		 * StaticUtil ru = new StaticUtil(); String filePath =
		 * ru.getClass().getResource(".").getPath().toString(); // 取得项目根目录
		 * System.out.println("ssssss-------------------->:"+filePath);
		 * convert2Html("http://www.59et.com/News_newsdetail?id=4", "UTF-8",
		 * filePath + "/", "sss.html");
		 */
		String sss = "http://www.59et.com/News_newsdetail?id=4";
		String bbb = "/News_newsdetail?id=4";
		System.out.println(sss.substring(0, sss.indexOf(bbb)));
	}
}