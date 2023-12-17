package com.practice;

public class Board {

	/* Properties */
	/* 제목 */
	private String title;
	/* 내용 */
	private String content;
	
	
	/* Setter, Getter Method */
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
