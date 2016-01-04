package com.hibernateDemo.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.junit.Test;
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
public class CrudTest extends TestCase{
	@Test
	public void testName() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		Student student = new Student();
		student.setName("wuzhiping" + new Date());
		
		ClassRoom classRoom = new ClassRoom();
		classRoom.setClassName("306 classRoom" + new Date());
		
		
		Set<Student> set = new HashSet<Student>();
		set.add(student);
		classRoom.setStudents(set);
		
		//classRoom.setStudents();
		
		try {
			//getStudentService(ctx).save(student);
			
			ctx.getBean(ClassRoomService.class).save(classRoom);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private StudentService getStudentService(ApplicationContext ctx) {
		return ctx.getBean(StudentService.class);
	}
}
