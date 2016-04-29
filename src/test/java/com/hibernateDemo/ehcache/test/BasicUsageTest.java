package com.hibernateDemo.ehcache.test;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernateDemo.domain.ClassRoom;
import com.hibernateDemo.interceptor.MethodCacheInterceptor;
import com.hibernateDemo.service.ClassRoomService;

import antlr.collections.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.constructs.blocking.BlockingCache;

/**
 * @author: Sophist Wu
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2016年2月3日 下午2:46:44
 * @desc:
 * 
 */
public class BasicUsageTest {
	public ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

	private static final Logger log = LoggerFactory.getLogger(MethodCacheInterceptor.class);

	@Test
	public void testName() throws Exception {
		ClassRoomService classRoomService = ctx.getBean(ClassRoomService.class);
		ClassRoom param = new ClassRoom();
		param.setId(1);
		java.util.List<ClassRoom> list =classRoomService.getClassRoomListByExample(param);
		for (ClassRoom classRoom : list) {
			log.info(classRoom.toString());
		}

		java.util.List<ClassRoom> list2 =classRoomService.getClassRoomListByExample(param);
/*		CacheManager cacheManager = CacheManager.create();
		String names[] = cacheManager.getCacheNames();
		for (String string : names) {
			System.out.println(string);
		}
		*/
		for (ClassRoom classRoom : list2) {
			log.info(classRoom.toString());
		}
	}

	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void afterPropertiesSet() throws Exception {
		log.info(cache + " A cache is required. Use setCache(Cache) to provide one.");
	}

}
