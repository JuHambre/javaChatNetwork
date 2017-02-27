package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import models.User;

/*
 * Main controller
 */
public class ChatController 
{
    
	//All registered users
	private static ArrayList <User> usersOnline = new ArrayList <>();
	//The last user who posted a command
	private static User userInSession;
	
	public static void main( String[] args )
    {
        System.out.println("Welcome to Easy-Chat! You can use the following commands:\n"
        		+ "Post something (posting: <user name> -> <message>)\n"
        		+ "Read another user (reading: <user name>)\n"
        		+ "Follow a user (following: <user name> follows <another user>)\n"
        		+ "See your wall (wall: <user name> wall)\n"
        		+ "Exit application (exit: <user name>)");
        menu();
    }
    
	//Controller of commands
    public static void menu()
    {    	
    	System.out.println("What's happening?");
    	Scanner reader = new Scanner(System.in);
    	String input = reader.nextLine();
    	
    	String[] parms = input.split(" ");
    	
    	UserController uc = new UserController();
    	CommandController cc = new CommandController();
    	User userSubmitCommand = uc.getUserSubmitCommand(usersOnline, parms[1]); //Always the user introduce more than one
    	
    	switch(parms[0]) {
    		case "exit:":
    			System.out.println("See you soon!");
    			break;
    		case "posting:":
    			userInSession = userSubmitCommand;
    			cc.posting(input, userSubmitCommand);
    			menu();
    			break;
    		case "reading:":
    			cc.reading(userSubmitCommand, userInSession);
    			menu();
    			break;
    		case "following:":
    			cc.following(userSubmitCommand, uc.getUserByName(usersOnline, parms[3]));
    			menu();
    			break;
    		case "wall:":
    			cc.wall(uc.getAllFollowingMessages(userSubmitCommand.getFollowingUsers()));
    			menu();
    			break;
    		default:
    			System.out.println("Uuups, the command is incorrect, rewrite the command!");
    			menu();
    	}    	    	
    }
}
