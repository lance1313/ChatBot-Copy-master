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
	
	

	@SuppressWarnings("unchecked")
	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords= importWordsToArray();
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		
		//removeTwitterUsernamesFromList(wordList);
		return wordList;
	}
	
	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordList.size(); spot++)
		{
			if(wordList.get(spot).equals(""))
			{
				wordList.remove(spot);
				//when remove in list must go back r you'll skip an answer.
				spot--;
			}
		}
	}
	
	// runs hen a string is taken in
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		String scrubbedString = "";
		//goes through the word and removes puntuatiuon
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				//adds char to end of word list.
				scrubbedString += currentString.charAt(i);
			}
		}
		
		return scrubbedString;
		
	}
	
	//public void 

}
