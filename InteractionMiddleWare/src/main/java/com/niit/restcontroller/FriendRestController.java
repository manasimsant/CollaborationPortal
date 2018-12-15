package com.niit.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.FriendDAO;
import com.coll.models.Friend;
import com.coll.models.User;

@RestController
public class FriendRestController {

	@Autowired
	FriendDAO friendDAO;

	@PutMapping(value = "/sendfriendrequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend) {
		if (friendDAO.sendFriendRequest(friend)) {
			return new ResponseEntity<String>("Friend request sent", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure to send friend request", HttpStatus.INTERNAL_SERVER_ERROR);
		}   
	}

	@GetMapping(value = "/deletefriendrequest/{friendid}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendid") int friendid) {
		if (friendDAO.deleteFriendRequest(friendid)) {
			return new ResponseEntity<String>("Friend request deleted..!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure to delete friend request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/acceptfriendrequest")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendid") int friendid) {
		if (friendDAO.acceptFriendRequest(friendid)) {
			return new ResponseEntity<String>("Friend request accepted..!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failure to accept friend request", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/showallfriends")
	public ResponseEntity<List<Friend>> showAllFriends(HttpSession session) {

		List<Friend> listAllFriends = friendDAO.showFriendList("Siddya");
		if (listAllFriends.size() > 0) {
			return new ResponseEntity<List<Friend>>(listAllFriends, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Friend>>(listAllFriends, HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = "/showpendingrequests")
	public ResponseEntity<List<Friend>> showPendingFriendRequests(HttpSession session) {
		String loginname = ((User) session.getAttribute(("user"))).getLoginname();
		List<Friend> listPendingRequests = friendDAO.showPendingFriendRequest(loginname);
		if (listPendingRequests.size() > 0) {
			return new ResponseEntity<List<Friend>>(listPendingRequests, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Friend>>(listPendingRequests, HttpStatus.CONFLICT);
		}
	}

	@GetMapping(value = "/showsuggestedfriends")
	public ResponseEntity<List<User>> showSuggestedFriends(HttpSession session) {
		String loginname = ((User) session.getAttribute(("user"))).getLoginname();
		List<User> listsuggestedfriend = friendDAO.showSuggestedFriend(loginname);
		if (listsuggestedfriend.size() > 0) {
			return new ResponseEntity<List<User>>(listsuggestedfriend, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<User>>(listsuggestedfriend, HttpStatus.CONFLICT);
		}
	}

}
