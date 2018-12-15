package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDAO;
import com.coll.models.Friend;

public class FriendDAOTest {

	@Autowired
	static FriendDAO friendDAO;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		friendDAO = (FriendDAO) context.getBean("friendDAO");
	}

	@Ignore
	@Test
	public void sendFriendRequest() {
		Friend friend = new Friend();
		friend.setFriendloginname("Manasi");
		friend.setLoginname("Manalii");
		assertTrue("Probliem in sending friend request", friendDAO.sendFriendRequest(friend));
		System.out.println("--------Friend Request sent-------");
		System.out.println("FirendID:" + friend.getFriendid());
		System.out.println("FriendLoginname :" + friend.getFriendloginname());
		System.out.println("Loginname :" + friend.getLoginname());
		System.out.println("Status :" + friend.getStatus());

	}

	@Ignore
	@Test
	public void deleteFriendRequest() {
		assertTrue("Problem in deleting friend request", friendDAO.deleteFriendRequest(1));
		System.out.println("---------Friend Request deleted-------");
	}

	@Test
	public void showPendingFriendRequest() {

		List<Friend> pendingfriendRequest = friendDAO.showPendingFriendRequest("Manu");
		assertNotNull("pending friend request", pendingfriendRequest);
		System.out.println("------pending friend requests-------");
		for (Friend friend : pendingfriendRequest) {
			System.out.println(friend.getLoginname() + ":::" + friend.getFriendloginname());
		}
	}
	
	@Ignore
	@Test
	public void showAllFriendRequestsTest()
	{
		 List<Friend> listFriendRequests =friendDAO.showFriendList("Friend");
		 assertNotNull("Problem found null pointer",listFriendRequests);
		System.out.println("-----------All friend requests----------");
		 for(Friend friend:listFriendRequests){
			 System.out.println(friend.getLoginname()+"::::"+friend.getFriendloginname());
		 }	
	}
	@Ignore
	@Test
	public void acceptFriendRequestTest()
	{
		assertTrue("Problem in accepting the friend request..",friendDAO.acceptFriendRequest(4));
		System.out.println("----------Friend request accepted--------");
		
	}

}
