package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.ForumDAO;
import com.coll.models.Blog;
import com.coll.models.Forum;

@RestController
public class ForumTestController {

	@Autowired
	ForumDAO forumDAO;

	@PostMapping(value = "/addforum")
	public ResponseEntity<Forum> addForum(@RequestBody Forum forum, HttpStatus session) {
		Forum f = new Forum();
		f.setUsername("manasisant@gmail.com");
		f.setForumname("Vanilla java Forum");
		if (forumDAO.addForum(f)) {
			return new ResponseEntity<Forum>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Forum>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping(value = "/deleteforum")
	public ResponseEntity<Forum> deleteForum(@RequestBody Forum forumid, HttpStatus session) {
		forumid.getForumid();
		if (forumDAO.deleteForum(forumid)) {
			return new ResponseEntity<Forum>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Forum>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping(value = "/updateforum")
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum, HttpStatus session) {
		forum.getForumid();
		forum.setForumname("Discussion Forum");
		if (forumDAO.updateForum(forum)) {
			return new ResponseEntity<Forum>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Forum>(HttpStatus.CONFLICT);
		}
	}

	public ResponseEntity<List<Forum>> listForum(@RequestBody Forum forum, HttpStatus session) {
		List<Forum> listForum = forumDAO.listForum();

		if (listForum.size() > 0) {
			return new ResponseEntity<List<Forum>>(listForum, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Forum>>(listForum, HttpStatus.CONFLICT);
		}
	}
}
