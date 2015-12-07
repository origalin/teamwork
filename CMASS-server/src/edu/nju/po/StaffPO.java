package edu.nju.po;

import java.io.Serializable;

public class StaffPO implements Serializable{
	String staffID;
	String name;
	String sex;
	String idenity;
	String tel;
	String institutation;
	Post post;
	public StaffPO(String staffID, String name, String sex, String idenity,
			String tel,String institutation, Post post) {
		super();
		this.staffID = staffID;
		this.name = name;
		this.sex = sex;
		this.idenity = idenity;
		this.tel = tel;
		this.institutation = institutation;
		this.post = post;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdenity() {
		return idenity;
	}
	public void setIdenity(String idenity) {
		this.idenity = idenity;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getInstitutation() {
		return institutation;
	}
	public void setInstitutation(String institutation) {
		this.institutation = institutation;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
}
