package com.hibernateDemo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Lazy;

/**
* @author: 吴志平
* @mailTo: sophistwu@outlook.com
* @createDate: 2016年1月4日 下午5:12:12 
* @desc: 
* 
*/
@Entity
public class ClassRoom implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	@Column
	private String className;
	@OneToMany(mappedBy="classRoom",cascade=CascadeType.ALL)
	private Set<Student> std;
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
	@Lazy(value=false)
	public Set<Student> getStd() {
		return std;
	}
	public void setStd(Set<Student> std) {
		this.std = std;
	}
	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", className=" + className + ", std=" + std + "]";
	}
	
}
