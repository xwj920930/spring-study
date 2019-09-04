package com.xwj.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResourcePattern {
	@Test
	public void getResource() throws IOException {
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource resource1=resolver.getResource("classpath:springmvc.xml");
		Resource resource2=resolver.getResource("file:WebContent/WEB-INF/web.xml");
		System.err.println(resource1.getFile().getAbsolutePath());
		System.err.println(resource2.getFile().getAbsolutePath());
	}
	@Test
	public void getResources() throws IOException {
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource[] resource=resolver.getResources("classpath*:*.xml");
		for (Resource resource2 : resource) {
			System.err.println(resource2.getFile().getAbsolutePath());
		}
	}
	/*public static void main(String[] args) throws IOException {
		//new ResourcePattern().getResource();
		new ResourcePattern().getResources();
	}*/
}
