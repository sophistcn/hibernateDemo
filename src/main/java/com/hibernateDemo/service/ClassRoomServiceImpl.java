package com.hibernateDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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

	public List<ClassRoom> getClassRoomListByExample(ClassRoom classRoom) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClassRoom.class);
		return criteria.list();
	}

	public ClassRoom getClassRoomByExample(Integer id) {
		return  (ClassRoom) sessionFactory.getCurrentSession().load(ClassRoom.class, id);
	}

	public List<ClassRoom> getClassRoomByCriteria(String roomName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClassRoom.class);
		criteria.add(Restrictions.eq("className", "hehe"));
		return criteria.list();
	}
	
}
