package com.guigu.pojo;

import java.io.Serializable;

public class Users implements Serializable{
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", score=" + score + ", birthday="
				+ birthday + "]";
	}
	private static final long serialVersionUID = -3691436197603897672L;
	private int uid;
	private String uname;
	private String upass;
	private double score;
	private String birthday;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
