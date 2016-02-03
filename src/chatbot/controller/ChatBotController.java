
package chatbot.controller;

import javax.swing.JOptionPane;

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
	/**
	 * 
	 */
	private ChatBotView appView;
	/**
	 * 
	 */
	private ChatBotModel myAwesomeChatBot;
	/**
	 * 
	 */
	public static String startMessage;
	/**
	 * 
	 */
	private String quitMessage;
	/**
	 * reference to GUI frame.
	 */
	private ChatBotFrame appFrame;

	public ChatBotController() {
		appView = new ChatBotView(this);
		myAwesomeChatBot = new ChatBotModel("derf");

		startMessage = "Welcome to the " + myAwesomeChatBot.getName()
				+ " chatbot. What is your name?";
		quitMessage = "good bye cruel world:)";
		appFrame = new ChatBotFrame(this);// Instantiate the reference.
	}

	/**
	 * this is a constructor.
	 */
	public ChatBotModel getMyAwesomeChatBot() {
		return myAwesomeChatBot;
	}

	public void start() {

		((ChatBotPanel) appFrame.getContentPane())
				.showTextMessage(startMessage);// same as the code line below
												// good for only using it a few
												// times.
		// ChatBotPanel testPanel = (ChatBotPanel)
		// appFrame.getContentPane();//gets me access to the panel.

	}

	/**
	 * 
	 * @param input
	 *            this says to the view what the chatbot is talking about.
	 * @return
	 */
	public String getChatBotDialog(String input) {
		String result = "";
		if (myAwesomeChatBot.quitChecker(input)) {
			quit();
		}
		result = myAwesomeChatBot.processText(input);

		return result;
	}

	// start
	// say hello
	// dialog
	// responed
	// reply
	// quit

	private void quit() {
		appView.ShowChatBotMessage(quitMessage);
		System.exit(0);
	}

}
