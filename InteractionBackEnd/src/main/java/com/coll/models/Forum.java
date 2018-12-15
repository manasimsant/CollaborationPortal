
package com.coll.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name="forumtable")
@SequenceGenerator(name = "forumidseq", sequenceName = "forumidseq")
public class Forum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forumidseq")
	int forumid;
	String forumname;
	String forumdesc;
	String username;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
	Date createforumdate;
	
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public String getForumdesc() {
		return forumdesc;
	}
	public void setForumdesc(String forumdesc) {
		this.forumdesc = forumdesc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateforumdate() {
		return createforumdate;
	}
	public void setCreateforumdate(Date createforumdate) {
		this.createforumdate = createforumdate;
	}
	

}
