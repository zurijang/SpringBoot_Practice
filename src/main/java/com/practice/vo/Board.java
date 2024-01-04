package com.practice.vo;

public class Board {

	/* Properties */
	/* 게시글 아이디 */
	private String bid;
	/* 제목 */
	private String title;
	/* 내용 */
	private String content;
	
	
	/* Setter, Getter Method */
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "title=" + title + ", content=" + content;
	}
	
}
