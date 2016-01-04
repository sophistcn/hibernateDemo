package com.hibernate.tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author: 吴志平
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2015年12月24日 上午10:48:48
 * @desc:
 * 
 */
public class HibernateUtil {

	// 定义静态的SessionFactory，产生单例，只生成一个SessionFactory
	private static final SessionFactory sessionFactory = buildSessionFactory();

	// 用来初始化SessionFactory
	private static SessionFactory buildSessionFactory() {

		try {

			// Create the SessionFactory from hibernate.cfg.xml

			return new Configuration().configure().buildSessionFactory();

		}

		catch (Throwable ex) {

			// Make sure you log the exception, as it might be swallowed

			System.err.println("Initial SessionFactory creation failed." + ex);

			throw new ExceptionInInitializerError(ex);

		}

	}

	// 得到SessionFactory
	public static SessionFactory getSessionFactory() {

		return sessionFactory;// 返回SessionFactory的对象

	}

}
