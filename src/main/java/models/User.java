package models;

import java.util.ArrayList;

/*
 * User model
 */
public class User {
	
	private String name;
	private ArrayList <Message> messages = new ArrayList <>();
	private ArrayList <User> followingUsers = new ArrayList <>();
	
	public User(String n)
	{
		name = n;
		followingUsers.add(this); //A user follows himself by definition
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList <Message> getMessages()
	{
		return messages;
	}
	
	public ArrayList <User> getFollowingUsers()
	{
		return followingUsers;
	}
	
	public void setMessage(String message)
	{
		messages.add(new Message(message));
	}
	
	public void setFollowingUser(User user)
	{
		followingUsers.add(user);
	}
}
