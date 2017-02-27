package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import models.Message;
import models.User;

/*
 * Command Controller
 */
public class CommandController {	
	
	public void posting(String input, User userSubmitCommand)
	{
		String message = input.substring(input.indexOf(" -> ") + 4);
		userSubmitCommand.setMessage(message);
	}
	
	public void reading(User userSubmitCommand, User userInSession)
	{
		
		Date now = new Date();
		String minutes = "";
		ArrayList <Message> messages;
		Message message;
		
		if(userSubmitCommand != null) {
			System.out.println(userSubmitCommand.getName());
			messages = userSubmitCommand.getMessages();
			//Reading in inverse order
			for(int i = messages.size() - 1; i >= 0; i--) {
				message = messages.get(i);
				minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - message.getDate().getTime()) + " minutes ago";
				System.out.println(message.getMessage() + " (" + minutes + ")");
			}
		}
		
		if(userInSession != null) {
			System.out.println(userInSession.getName());
			messages = userInSession.getMessages();
			//Reading in inverse order
			for(int i = messages.size() - 1; i >= 0; i--) {
				message = messages.get(i);
				minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - message.getDate().getTime()) + " minutes ago";
				System.out.println(message.getMessage() + " (" + minutes + ")");
			}
		}
	}
	
	public void following(User userSubmitCommand, User userFollowing)
	{
		userSubmitCommand.setFollowingUser(userFollowing);
	}
	
	public void wall(ArrayList <Message> allFollowingMessages)
	{
		
		Date now = new Date();
		String minutes = "";
		
		for(Message message : allFollowingMessages) {
			minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - message.getDate().getTime()) + " minutes ago";
			System.out.println(message.getMessage() + " (" + minutes + ")");
		}
	}
}
