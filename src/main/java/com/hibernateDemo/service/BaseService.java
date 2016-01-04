package com.hibernateDemo.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author: 吴志平
* @mailTo: sophistwu@outlook.com
* @createDate: 2016年1月4日 下午5:25:17 
* @desc: 
* 
*/
public class BaseService {
	@Autowired
	public SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
