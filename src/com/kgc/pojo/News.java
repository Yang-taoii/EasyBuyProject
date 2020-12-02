package com.kgc.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class News implements Serializable{


	private int id;//ID
	private String title;//标题
	private String content;//内容
	private Date createTime;//创建时间
	private List<News> list;

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	public News() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
