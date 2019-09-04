package com.xwj.anno;

public class FService {
	@NeedTest(true)
	public void delete(){
		System.err.println("FService.delete()");
	}
	@NeedTest(false)
	public void add(){
		System.err.println("FService.add()");
	}
}
