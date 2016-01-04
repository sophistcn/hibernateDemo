package com.hibernateDemo.service;

import org.springframework.stereotype.Service;

import com.hibernateDemo.domain.Student;

/**
 * @author: 吴志平
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2016年1月4日 下午4:47:06
 * @desc:
 * 
 */
@Service
public class StudentServiceImpl extends BaseService implements StudentService {
	
	public void save(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}

}
