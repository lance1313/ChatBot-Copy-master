package chatbot.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelListener;

import javax.swing.*;

import chatbot.controller.ChatBotController;
import chatbot.model.ChatBotModel;

/**
 * 
 * @version1.2 10/21/14- update GUI
 * @author jlin3312
 *
 */
public class ChatBotPanel extends JPanel
{

	private ChatBotController baseController;// import the controller.
	private ChatBotModel baseModel;
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JButton secondButton;
	private JScrollBar firstBar;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;

	/**
	 * 
	 * @param baseController
	 *            this links this panel to the controller.
	 */
	public ChatBotPanel(ChatBotController baseController, ChatBotModel baseModel)
	{
		this.baseController = baseController;
		this.baseModel = baseModel;
		firstButton = new JButton("Chat");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		
		
		chatArea = new JTextArea(10, 25);
		chatPane = new JScrollPane(chatArea);
		secondButton = new JButton("???");
		
		firstBar = new JScrollBar();
		
		setupPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	public String displayChat()
	{
		String initialMessage = "";
		if (baseModel.getchatCount() < 0)
		{
			initialMessage = baseController.startMessage;
		}

		else
		{
			System.exit(0);
		}

		return initialMessage;

	}

	private void setupPane()
	{
		chatPane = new JScrollPane(chatArea);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -20, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, secondButton, 0, SpringLayout.SOUTH, chatPane);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		chatPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 152, SpringLayout.EAST, firstBar);
		baseLayout.putConstraint(SpringLayout.WEST, secondButton, 0, SpringLayout.EAST, firstBar);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -150, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, secondButton, -147, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, secondButton, -169, SpringLayout.EAST, this);

	}

	/**
	 * this is were you put the GUI to be dysplayed on the panel in the frame.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setSize(500, 500);
		this.setLayout(baseLayout);// make the layout what you coded in the base
									// layout
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
		this.add(secondButton);
		this.add(firstBar);

	}

	private void setupLayout()// dumping ground
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstBar, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstBar, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstBar, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -26, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 80, SpringLayout.EAST, firstBar);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -26, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 4, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, secondButton, 27, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, secondButton, 159, SpringLayout.EAST, firstBar);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 80, SpringLayout.EAST, firstBar);

	}

	private void setupListeners()// this is what buttons do.
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				String result = baseController.getChatBotDialog(currentInput);
				showTextMessage(currentInput);// put current input as text
				showTextMessage(result);// set up result as text
				firstTextField.setText("");// finish with empty text.
			}
		});

		secondButton.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				String result = baseController.getChatBotDialog(currentInput);
				showTextMessage(currentInput);// put current input as text
				showTextMessage(result);// set up result as text
				firstTextField.setText("");// finish with empty text.
				// firstTextField
			}

		});

	}

	/**
	 * 

	 * @param userInput
	 *            What is typed into the first text and the button is clicked alows the text to show in the text area.
	 */
	public void showTextMessage(String userInput)// does not send a string back.
	{
		chatArea.append("\n" + userInput);

	}

}
