package com.hibernateDemo.aspect;

import java.io.Serializable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.hibernateDemo.domain.ClassRoom;
import com.hibernateDemo.interceptor.MethodCacheInterceptor;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * @author: Sophist Wu
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2016年2月3日 下午2:46:44 
 * @desc: 
 * 
 */
public class EhCacheAspect {	
	private static final Logger log = LoggerFactory.getLogger(EhCacheAspect.class);

	private Cache cache;
	public void doAfter(JoinPoint jp) {	
		System.out.println("log Ending method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long time = System.currentTimeMillis();
		Object[] objects = pjp.getArgs();
		ClassRoom classRoom = (ClassRoom) objects[0];
		Element element = cache.get(classRoom.getId());
		 if (element == null) {
			if (classRoom != null & classRoom.getId() != null) {
					Object retVal = pjp.proceed();
					element = new Element(classRoom.getId(), (Serializable) retVal);
					log.info(classRoom.getClassName()  + "加入到缓存： " + cache.getName());
					cache.put(element);
			}
		 } else {
			 log.info(classRoom.getId() + "使用缓存: " + element.getObjectKey());
			 return element.getObjectValue();
		 }
		time = System.currentTimeMillis() - time;
		System.out.println("process time: " + time + " ms");
		return element.getObjectValue();
	}

	public void doBefore(JoinPoint jp) {
		System.out.println("log Begining method: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public void doThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("method " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName() + " throw exception");
		System.out.println(ex.getMessage());
	}

	public Cache getCache() {
		return cache;
	}

	public void setCache(Cache cache) {
		this.cache = cache;
	}
	
	
}

