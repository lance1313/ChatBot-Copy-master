package chatbot.model;

//import java.awt.List;
import java.util.ArrayList;
import java.util.List;

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
			
			baseController.handleErrors(e.getErrorMessage());
		}
	}
	
	public void loadTweets(String twitterHandel) throws TwitterException
	{
		Paging statusPage = new Paging(1,200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandel, statusPage));
			page++;
		}
		for(Status currentStatus : statusList )
		{
			String [] tweetText = currentStatus.getText().split("");
			for(String word : tweetText)
			{
				wordList.add(removePunctuation(word).toLowerCase());
			}
			
			removeCommonEnglishWords(wordList);
			removeEmptyText();
		}
	}
	
	

	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
	
	private void removeEmptyText()
	{
		
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
		
	}
	
	//public void 

}
