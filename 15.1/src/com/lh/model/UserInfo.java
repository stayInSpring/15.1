package com.lh.model;

/**
 * �û���Ϣʵ����
 * @author lh
 */
public class UserInfo {
	private int id;       //�û����
	private String name;  //�û���	
	private String pwd;   //����
	public UserInfo(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
