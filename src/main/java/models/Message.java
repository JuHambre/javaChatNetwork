package models;

import java.util.Date;

/*
 * Message model
 */
public class Message {

	private String message;
	private Date date;
	
	public Message(String m)
	{
		message = m;
		date = new Date();
	}
	
	public Message(Message m, String uN)
	{
		message = uN + " - " + m.message;
		date = m.date;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void setMessage(String m)
	{
		message = m;
	}
	
	public void setDate(Date d)
	{
		date = d;
	}
}
