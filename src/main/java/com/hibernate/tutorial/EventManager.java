package com.hibernate.tutorial;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.tutorial.domain.Event;
import com.hibernate.tutorial.util.HibernateUtil;

/**
 * @author: 吴志平
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2015年12月24日 上午10:50:45
 * @desc:
 * 
 */
public class EventManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventManager mgr = new EventManager();
		// if (args[0].equals("store")) {
		mgr.createAndStoreEvent("My Event4", new Date());// 调用函数插入数据
		// }
		HibernateUtil.getSessionFactory().close();
	}

	private void createAndStoreEvent(String title, Date theDate) {

		// 得到目前运行的session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();// 开始事务
		Event theEvent = new Event();// 创建bean对象
		theEvent.setTitle(title);// 设置标题
		theEvent.setDate(theDate);// 设置日期
		session.save(theEvent);// 保存对象
		session.getTransaction().commit();// 提交事务

	}

}
