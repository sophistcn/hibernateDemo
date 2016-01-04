package com.hibernateDemo.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
* @author: 吴志平
* @mailTo: sophistwu@outlook.com
* @createDate: 2016年1月4日 下午5:12:12 
* @desc: 
* 
*/
@Entity
public class ClassRoom {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String className;
	private Set<Student> students;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@OneToMany(mappedBy="classRoom")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
