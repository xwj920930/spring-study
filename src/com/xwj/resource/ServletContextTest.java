package com.xwj.resource;

import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@WebServlet(urlPatterns="/servletContext")
public class ServletContextTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context=req.getServletContext();
		Resource resource=new ServletContextResource(context, "resource\\file1.txt");
		InputStream is=resource.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		System.out.println(reader.readLine());
		System.out.println(resource.getFile().getAbsolutePath());
		is.close();
	}
}
