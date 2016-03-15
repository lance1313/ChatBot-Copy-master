
package chatbot.controller;

import javax.swing.JOptionPane;

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

	}
	
	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
	
	public void handleErrors(String errorMesage)
	{
		display.displayText(errorMesage);
	}
	
	public String analyze(String userName)
	{
		String userAnalysis = "The twitter user" + userName + "has  ..." + chatTwitter.topResults();
		
		
		
		return userAnalysis;
	}
	
}
