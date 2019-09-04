package com.xwj.resource;

import org.springframework.core.io.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class FileResourceTest {
	private static void write() throws Throwable {
		String path="D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\file1.txt";
		WritableResource resource=new PathResource(path);
		OutputStream os=resource.getOutputStream();
		os.write("this is file1".getBytes());
		os.close();
	}
	private static void readByFileSystem() throws Throwable {
		Resource resource=new FileSystemResource("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\file1.txt");
		InputStream is=resource.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		System.out.println(reader.readLine());
		is.close();
	}
	private static void readByClassPath() throws Throwable {
		Resource resource=new ClassPathResource("springmvc.xml");
		InputStream is=resource.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(is));
		System.out.println(reader.readLine());
		System.out.println(resource.getFile().getAbsolutePath());
		is.close();
	}
	public static void main(String[] args) throws Throwable {
		//write();
		//readByFileSystem();
		//readByClassPath();
	}
}
