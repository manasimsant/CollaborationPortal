package com.coll.dao;

import java.util.List;

import com.coll.models.Friend;
import com.coll.models.User;

public interface FriendDAO {

	public List<Friend> showFriendList(String loginname);

	public List<Friend> showPendingFriendRequest(String loginname);

	public List<User> showSuggestedFriend(String loginname);

	public boolean sendFriendRequest(Friend friend);

	public boolean acceptFriendRequest(int friendId);

	public boolean deleteFriendRequest(int friendId);

}