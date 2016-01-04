package com.hibernateDemo.service;

import org.springframework.stereotype.Service;

import com.hibernateDemo.domain.ClassRoom;

/**
* @author: 吴志平
* @mailTo: sophistwu@outlook.com
* @createDate: 2016年1月4日 下午5:24:31 
* @desc: 
* 
*/
@Service
public class ClassRoomServiceImpl extends BaseService implements ClassRoomService {
	
	public void save(ClassRoom classRoom) {
		sessionFactory.getCurrentSession().save(classRoom);
	}

}
