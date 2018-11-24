package com.coll.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BlogTable")
public class Blog {

	@Id
	@GeneratedValue
	int blogid;
	String blogname;
	String blogdesc;
	Date createDate;
	String username;
	String status;
	int likes;
	int dislikes;

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getBlogname() {
		return blogname;
	}

	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}

	public String getBlogdesc() {
		return blogdesc;
	}

	public void setBlogdesc(String blogdesc) {
		this.blogdesc = blogdesc;
	}

	public Date getDate() {
		return createDate;
	}

	public void setDate(Date date) {
		this.createDate = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
}
