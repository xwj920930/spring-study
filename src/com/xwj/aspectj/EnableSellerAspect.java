package com.xwj.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.core.Ordered;

@Aspect
public class EnableSellerAspect implements Ordered{
	@DeclareParents(value="com.xwj.aspectj.NaiveWaiter",defaultImpl=SmartSeller.class)
	public Seller seller;

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 2;
	}
}
