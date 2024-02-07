package com.practice.vo;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.practice.config.JasyptConfig;

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
		StringEncryptor jasypt = new JasyptConfig().stringEncryptor();
		this.password = jasypt.encrypt(password);
	}
	
}
