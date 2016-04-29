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
	/**
	 * 
	 * @param classRoom
	 * @return
	 * @author Sophist Wu
	 * @mailTo: sophistwu@outlook.com
	 * @createDate: 2016年4月24日 上午9:23:24
	 * @desc 
	 */
	List<ClassRoom> getClassRoomListByExample(ClassRoom classRoom);

	ClassRoom getClassRoomByExample(Integer id);
	
	List<ClassRoom> getClassRoomByCriteria(String roomName);
}
