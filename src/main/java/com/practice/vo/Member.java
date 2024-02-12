package com.practice.vo;

public class Member {
	
	/* 회원아이디 */
	private int mid;
	/* 이메일 */
	private String email;
	/* 비밀번호 */
	private String password;
	
	/* Setter, Getter Method */
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
