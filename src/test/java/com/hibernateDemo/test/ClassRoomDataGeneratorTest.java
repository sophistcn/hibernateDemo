package com.hibernateDemo.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernateDemo.domain.ClassRoom;
import com.hibernateDemo.domain.Student;
import com.hibernateDemo.interceptor.MethodCacheInterceptor;
import com.hibernateDemo.service.ClassRoomService;

/**
 * @author: Sophist Wu
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2016年2月3日 下午2:46:44 
 * @desc: 
 * 
 */
public class ClassRoomDataGeneratorTest {
	public ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

	private static final Logger log = LoggerFactory.getLogger(MethodCacheInterceptor.class);
	@Test
	public void testName() throws Exception {

		ClassRoomService classRoomService = ctx.getBean(ClassRoomService.class);
		
		ClassRoom classRoom = new ClassRoom();
		classRoom.setClassName("a01" + new Date());
		
		Set<Student> std = new HashSet<Student>();
		Student student = new Student();
		student.setName("wzp"+ new Date());
		
		classRoom.setStd(std);
		
		classRoomService.save(classRoom);
	}
}

