
package chatbot.controller;

import javax.swing.JOptionPane;

import twitter4j.TwitterException;
import chatbot.model.CTECTwitter;
import chatbot.model.ChatBotModel;
import chatbot.view.ChatBotFrame;
import chatbot.view.ChatBotPanel;
import chatbot.view.ChatBotView;

/**
 * Runs ChotBot project. Owns the model and associated views. DON'T CALL POP UP
 * WINDOWS ON CONTROLLERS Get my MAC projects to gitHub.
 * 
 * @author Jacob Lindquist
 * @version 1.3 10/2/14 - Cleaned the quit method.
 */
public class ChatBotController {
	
	//private ChatBotView display;
	private ChatBotModel myAwesomeChatBot;
	public static String startMessage;
	private String quitMessage;
	private CTECTwitter chatTwitter;
	private ChatBotModel simpleBot;
	private ChatBotView display;
	private ChatBotFrame baseFrame;
	private CTECTwitter myTwitter;
	private ChatBotPanel basePanel;
	/**
	 * reference to GUI frame.
	 */
	private ChatBotFrame appFrame;

	public ChatBotController() 
	{
		myTwitter = new CTECTwitter();
		display = new ChatBotView(this);
		String user =display.collectUserText("What is your name?");
		baseFrame = new ChatBotFrame(this);
		

	}
	
	public void start()
	{
		
	}
	
	public void chat()
	{
		
	}
	
	public void shutDown()
	{
		display.displayText("Goodbye");
		System.exit(0);
	}
	
	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
	
	public void handleErrors(String errorMesage)
	{
		display.displayText(errorMesage);
	}
	
	public String analyze(String twitterTopic)
	{
		
		
		
		String userAnalysis = "what topic do you want to search? " ;
//		userAnalysis = "what distance do you want to search? " ;
//		userAnalysis = "were is your Geographical location?  ";
		
//		try
//		{
//			myTwitter.loadTweets(userName);
//		}
//		
//		catch(TwitterException error)
//		{
//			handleErrors(error.getErrorMessage());
//		}
		//userAnalysis += myTwitter.topResults();
		
		return userAnalysis + "The twitter topic " + twitterTopic + " has  ... " + myTwitter.sampleInvestigation(twitterTopic);
	}
	
}
