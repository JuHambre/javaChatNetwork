package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controllers.CommandController;
import controllers.UserController;
import models.Message;
import models.User;

/*
 * Test
 */
public class AppTest
{

	User user1;
	User user2;
	User user3;
	ArrayList <User> users = new ArrayList <>();
	UserController uc;
	CommandController cc;
	
	//Before each test
	@Before
    public void before()
    {
    	user1 = new User("Juan");
    	user2 = new User("Jose");
    	user3 = new User("Pepe");
    	user1.setMessage("Message1");
    	user2.setMessage("Message2");
    	user3.setMessage("Message3");
    	user1.setMessage("Message4");
    	user3.setMessage("Message5");
    	users.add(user1);
    	users.add(user2);
    	users.add(user3);
    	user1.setFollowingUser(user3);
    	uc = new UserController();
    	cc = new CommandController();
    }
	
	//Registered user
	@Test
    public void testGetUserSubmitCommand1()
    {
        User user = uc.getUserSubmitCommand(users, "Juan");
        assertSame(user1, user);
        assertEquals(users.size(), 3);
    }
    
    //New user
	@Test
    public void testGetUserSubmitCommand2()
    {
        User user = uc.getUserSubmitCommand(users, "Pablo");
        assertNotSame(user1, user);
        assertEquals(users.size(), 4);
    }
    
	@Test
    public void testGetUserByName()
    {
    	User user = uc.getUserByName(users, "Juan");
    	assertSame(user1, user);
    }
    
	@Test
    public void testGetAllFollowingMessages()
    {
    	ArrayList <Message> messages = new ArrayList <>();
    	messages = uc.getAllFollowingMessages(user1.getFollowingUsers());
    	assertEquals(messages.size(),4);
    }
	
	@Test
	public void testPosting()
	{
		cc.posting("Jose -> Message6", user2);
		assertEquals(user2.getMessages().get(1).getMessage(),"Message6");
	}
	
	@Test
	public void testFollowing()
	{
		cc.following(user2, user3);
		assertSame(user2.getFollowingUsers().get(1),user3);
	}
}
