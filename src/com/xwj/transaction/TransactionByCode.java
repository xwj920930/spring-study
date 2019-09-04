package com.xwj.transaction;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionByCode {
	private String code;
	private TransactionTemplate template;
	public void setTemplate(TransactionTemplate template) {
		this.template = template;
	}
	public void addCode() {
		template.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				code.toString();
			}
		});
	}
}
