package com.xwj.transaction;

import com.xwj.entity.LoginLog;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(noRollbackFor=PessimisticLockingFailureException.class)
public class TestService{
	private TestDao testDao;
	public TestDao getTestDao() {
		return testDao;
	}
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	public void insertLoginLog(LoginLog loginLog) {
		testDao.insertLoginLog(loginLog);
		if(true)throw new PessimisticLockingFailureException("error");
		//if(true)throw new RuntimeException();
		testDao.updateLoginLog(loginLog);
	}
}
