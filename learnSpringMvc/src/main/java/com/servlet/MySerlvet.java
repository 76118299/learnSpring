package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MySerlvet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = MySerlvet.class.getResource("/").getPath();
		String requestURI = req.getRequestURI();

/**
 * springboot 没有wappp 静态文件html 是房子classpath所以这里用文件流将其输出客户端
 */
		File file = new File(path + requestURI);
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] bytes = new byte[1024];
		int line = 0;
		ServletOutputStream outputStream = resp.getOutputStream();

		while ( (line= fileInputStream.read(bytes))>0){
			outputStream.write(bytes,0,line);
		}
		resp.setContentType("text/html");
		outputStream.flush();

	}
}
