package com.student.ST.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name="MYSTUDENT")
public class Student {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private Long id;
@Column(unique=true)
private String studentname;
@Column(length=500)
private String course;
@Column
private int fee;


public Student() {
	super();
	// TODO Auto-generated constructor stub
}




public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getStudentname() {
	return studentname;
}
public void setStudentname(String studentname) {
	this.studentname = studentname;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}








public Student(Long id, String studentname, String course, int fee) {
	super();
	this.id = id;
	this.studentname = studentname;
	this.course = course;
	this.fee = fee;
}




@Override
public String toString() {
	return "Student [id=" + id + ", studentname=" + studentname + ", course=" + course + ", fee=" + fee + "]";
}





}