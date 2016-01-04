package com.hibernate.tutorial.domain;

import java.util.Date;

/**
 * @author: 吴志平
 * @mailTo: sophistwu@outlook.com
 * @createDate: 2015年12月24日 上午10:38:36
 * @desc:
 * 
 */
public class Event {
	private Long id;// id
	private String title;// 标题
	private Date date;// 日期

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
