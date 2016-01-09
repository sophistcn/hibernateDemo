package com.hibernateDemo.test;

import org.springframework.context.ApplicationContext;

import com.hibernateDemo.service.StudentService;

import junit.framework.TestCase;

public class StudentServiceTest extends TestCase{

	private StudentService getStudentService(ApplicationContext ctx) {
		return ctx.getBean(StudentService.class);
	}
}
