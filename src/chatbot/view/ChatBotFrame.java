package chatbot.view;

import javax.swing.JFrame;
import chatbot.controller.ChatBotController;

//
/**
 * GUI frame class for a chat bot. Shows the basic framework code for JFrame
 * extensio
 * 
 * @author jlin3312 only holds panels.
 * @version1.1
 */
public class ChatBotFrame extends JFrame {
	private ChatBotPanel basePanel;

	/**
	 * Creates a chatBot frame with reference to the controller
	 * 
	 * @param baseController
	 *            the reference to cantroller.
	 */
	public ChatBotFrame(ChatBotController baseController) {
		basePanel = new ChatBotPanel(baseController, null);
		setupFrame();
	}

	/**
	 * this builds the frame on the computer.
	 */
	private void setupFrame() {

		this.setContentPane(basePanel);// this means i can do all the parent
										// class can do to .
		this.setSize(500, 500);
		this.setResizable(true);
		setVisible(true);

	}

}
