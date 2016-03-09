package chatbot.model;

import java.util.ArrayList;

import chatbot.controller.ChatBotController;
import twitter4j.*;

/**
 * version 0.3 3/7/16
 *  ref tto twitter4j
 * @author jacob
 *
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatbotTwitter;
	private ChatBotController baseController;
	
	
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		chatbotTwitter = TwitterFactory.getSingleton();
		//singleton is a pattern. mvc is a collection of patterns
	}
	
	public void sendTweet(String tweet)
	{
		try 
		{
			chatbotTwitter.updateStatus("Jacob lindquist just tweeted from my Java Chatbot program! "
					+ "#APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		} 
		catch (TwitterException e)
		{
			
			e.printStackTrace();
		}
	}

}
