package com.xwj.ioc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("annboss")
@Scope("prototype")
public class AnnoBoss {
	/*@Autowired
	@Qualifier("carref")
	private Car car;
	public AnnoBoss() {
		System.err.println("construct");
	}*/
	@PostConstruct
	private void PostConstruct(){
		System.err.println("PostConstruct");
	}
	@PreDestroy
	private void PreDestroy(){
		System.err.println("PreDestroy");
	}
	private void init(){
		System.err.println("init");
	}
	private void destroy(){
		System.err.println("destroy");
	}
}
