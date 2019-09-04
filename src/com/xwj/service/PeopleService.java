package com.xwj.service;

import com.xwj.dao.PeopleDao;
import com.xwj.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleService {
	@Autowired
	private PeopleDao peopleDao;
	@Transactional
	public void insert(People people){
		peopleDao.insert(people.getUserName(),people.getPassWord());
	}
}
