package org.webapp.dao;

import java.sql.Date;

public class Todo {
	private int idx;
	private String id;
	private String content;
	private Date targetDate;
	private Date createDate;
	private boolean done;
	private int category;
	private String ctgName;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getCtgName() {
		return ctgName;
	}
	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}
	
	
	@Override
	public String toString() {
		return "Todo [idx=" + idx + ", id=" + id + ", content=" + content + ", targetDate=" + targetDate
				+ ", createDate=" + createDate + ", done=" + done + ", category=" + category + ", ctgName=" + ctgName
				+ "]";
	}
	
	
}
