package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.Message;
import models.User;

/*
 * User controller
 */
public class UserController {
	
	/*
	 * Get the user that posted the command
	 * If the user does not exist, we create a new user
	 */
	public User getUserSubmitCommand(ArrayList <User> usersOnline, String userName)
	{
		boolean found = false;
		User userSubmitCommand = null;
		
		for(User userOnline : usersOnline) {
			if(userName.equals(userOnline.getName())) {
				found = true;
				userSubmitCommand = userOnline;
			}
		}
		if (found == false) {
			userSubmitCommand = new User(userName);
			usersOnline.add(userSubmitCommand);
		}
		
		return userSubmitCommand;
	}
	
	//Get the user by name
	public User getUserByName(ArrayList <User> usersOnline, String userName)
	{
		User user = null;
		
		for(User userOnline : usersOnline) {
			if(userName.equals(userOnline.getName())) {
				user = userOnline;
			}
		}
		
		return user;
	}
	
	//Get all the messages of the users that follows order by most recently
	public ArrayList<Message> getAllFollowingMessages(ArrayList <User> followUsers)
	{
		ArrayList <Message> allFollowMessages = new ArrayList <>();
		
		for(User followUser : followUsers) {
			for(Message message : followUser.getMessages()) {
				//We create new objects avoiding reference
				Message followMessage = new Message(message, followUser.getName());
				allFollowMessages.add(followMessage);
			}
		}
		
		//Order by most recently
		Collections.sort(allFollowMessages, new Comparator<Message>() {
			public int compare(Message m1, Message m2) {
				return m2.getDate().compareTo(m1.getDate());
			}
		});
		
		return allFollowMessages;
	}
}
