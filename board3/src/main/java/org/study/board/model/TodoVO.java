package org.study.board.model;

import java.sql.Date;

public class TodoVO{
	private int bno;
	private String title;
	private String content;
	private Date targetDate;
	private Date createDate;
	private boolean done;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	@Override
	public String toString() {
		return "TodoVO [bno=" + bno + ", title=" + title + ", content=" + content + ", targetDate=" + targetDate
				+ ", createDate=" + createDate + ", done=" + done + "]";
	}
	
	

}
