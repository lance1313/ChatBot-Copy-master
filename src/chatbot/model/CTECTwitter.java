package chatbot.model;

import java.util.ArrayList;
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
	
	public CTECTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
	public void sendTweet(String tweet)
	{
		chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program! "
				+ "#APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
	}

}
