package com.coll.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="friend")
@SequenceGenerator(name = "friendidseq", sequenceName = "friendidseq")
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friendidseq")
	int friendid;
	String loginname;
	String friendloginname;
	String status;

	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getFriendloginname() {
		return friendloginname;
	}

	public void setFriendloginname(String friendloginname) {
		this.friendloginname = friendloginname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
