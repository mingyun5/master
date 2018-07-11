package org.spring.project.model;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class TodoVO{
	private Integer bno;
	
	@NotEmpty(message= "제목 입력")
	private String title;
	private String content;
	private Date target_date;
	private Date create_date;
	private boolean done;

	public Integer getBno() {
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

	public Date getTarget_date() {
		return target_date;
	}

	public void setTarget_date(Date target_date) {
		this.target_date = target_date;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "TodoVO [bno=" + bno + ", title=" + title + ", content=" + content + ", targetDate=" + target_date
				+ ", createDate=" + create_date + ", done=" + done + "]";
	}
	
	

}
