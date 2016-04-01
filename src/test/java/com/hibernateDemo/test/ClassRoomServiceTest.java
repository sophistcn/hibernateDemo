package com.hibernateDemo.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernateDemo.domain.ClassRoom;
import com.hibernateDemo.domain.Student;
import com.hibernateDemo.service.ClassRoomService;
import com.hibernateDemo.service.StudentService;

import junit.framework.TestCase;

/**
* @author: 吴志平
* @mailTo: sophistwu@outlook.com
* @createDate: 2015年12月30日 上午9:03:50 
* @desc: 
* 
*/
public class ClassRoomServiceTest {
	public ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	private static final Logger log = LoggerFactory.getLogger(ClassRoomServiceTest.class);
	@Test
	public void testInsertOneToMany() throws Exception {
		
		Student student = new Student();
		student.setName("wuzhiping" + new Date());
		
		ClassRoom classRoom = new ClassRoom();
		classRoom.setClassName("306 classRoom" + new Date());
		
		
		Set<Student> set = new HashSet<Student>();
		set.add(student);
		
		classRoom.setStd(set);
		
		//classRoom.setStudents();
		
		try {
			//getStudentService(ctx).save(student);
			
			getClassRoomService().save(classRoom);
			ClassRoom rs = getClassRoomService().getClassRoomByExample(50);
			rs.getStd().size();
			log.info(rs.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetByCriteria() throws Exception {
		getClassRoomService().getClassRoomByCriteria("hehe");
	}

	private ClassRoomService getClassRoomService() {
		return ctx.getBean(ClassRoomService.class);
	}
}
