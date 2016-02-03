package chatbot.controller;

/**
 * 
 * @author jacob lindquist
 * @version 1.1
 *
 */
public class ChatBotRunner {
	/**
	 * 
	 * @param args
	 *            unused This is the main metod to start the program.
	 */
	public static void main(String[] args)// method
	{
		ChatBotController myChatBot = new ChatBotController();// constructor
		myChatBot.start();
	}

}
