package com.palletech.model;

public class Bean {

private int sid;
private String name;
private int age;
private long mobile ;

private String address;
private String email;
private String course;


public Bean(long mobile) {
	super();
	this.mobile = mobile;
	
}







public Bean(String name, int age, long mobile, String address, String email, String course) {
	super();
	this.name = name;
	this.age = age;
	this.mobile = mobile;
	this.address = address;
	this.email = email;
	this.course = course;
}







public Bean(int sid, String name, int age, long mobile, String address, String email, String course) {
	super();
	this.sid = sid;
	this.name = name;
	this.age = age;
	this.mobile = mobile;
	this.address = address;
	this.email = email;
	this.course = course;
}







public Bean(long mobile, String email) {
	super();
	this.mobile = mobile;
	this.email = email;
}



public Bean() {
	super();
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public long getMobile() {
	return mobile;
}

public void setMobile(long mobile) {
	this.mobile = mobile;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}







public int getSid() {
	return sid;
}







public void setSid(int sid) {
	this.sid = sid;
}










	
}
