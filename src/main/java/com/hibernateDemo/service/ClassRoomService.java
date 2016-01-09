package com.hibernateDemo.service;

import java.util.List;

import com.hibernateDemo.domain.ClassRoom;

/**
* @author: 吴志平
* @mailTo: sophistwu@outlook.com
* @createDate: 2016年1月4日 下午5:24:10 
* @desc: 
* 
*/
public interface ClassRoomService {
	void save(ClassRoom classRoom);

	List<ClassRoom> getClassRoomListByExample(ClassRoom classRoom);

	ClassRoom getClassRoomByExample(Integer id);
}
