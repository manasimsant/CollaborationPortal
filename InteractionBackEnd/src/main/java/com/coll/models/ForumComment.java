package com.coll.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "forumcommentidseq", sequenceName = "myforumcommentseq")
public class ForumComment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumcommentidseq")
	int forumcommentid;
	String forumname;
	String forumdesc;
	Date createDate;
	String loginname;
	String status;
	public int getForumcomment_id() {
		return forumcommentid;
	}
	public void setForumcomment_id(int forumcomment_id) {
		this.forumcommentid = forumcomment_id;
	}
	public String getForum_name() {
		return forumname;
	}
	public void setForum_name(String forum_name) {
		this.forumname = forum_name;
	}
	public String getForum_desc() {
		return forumdesc;
	}
	public void setForum_desc(String forum_desc) {
		this.forumdesc = forum_desc;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
