package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatBotController;

/**
 * This dyspalys what appers to the user and were the input goes.
 * 
 * @author jlin3312
 *
 */
public class ChatBotView {

	// private String chat;

	private ChatBotController baseController;

	// this is the chat checker.

	/**
	 * this sets the imported baseController from the other class to the on
	 * baseController in this class
	 * 
	 * @param baseController
	 */
	public ChatBotView(ChatBotController baseController)// this is a constructor
														// for the controller in
														// the view.
	{
		this.baseController = baseController;// shove the 2 baseControllers
												// together.
	}

	/**
	 * This shows the words that apperes on the screen and returns the result to
	 * determine weather you want it to exit or continue based on input.
	 * 
	 * @param currentInput
	 *            the supplied string
	 * @return hte users typed response
	 */
	public String showChatBot(String currentInput) {
		String result = "";

		int wordLength = currentInput.length();
		result = JOptionPane.showInputDialog(null, baseController
				.getMyAwesomeChatBot().getName() + " says: " + currentInput);

		return result;
	}

	public String ShowChatBotMessage(String currentInput) {
		JOptionPane.showMessageDialog(null, baseController
				.getMyAwesomeChatBot().getName() + " says " + currentInput);
		return currentInput;

	}

}

// + ChatBotController.getMyChatBot().getName(
/*
 * if (currentInput != null) { }
 */
