package chatbot.model;

import java.util.ArrayList;

import chatbot.controller.ChatBotController;
import twitter4j.*;

/**
 * version 0.2 ref tto twitter4j
 * @author jlin3312
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
		try {
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! "
					+ "#APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		} 
		catch (TwitterException e) {
			
			e.printStackTrace();
		}
	}

}
