package chatbot.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelListener;

import javax.swing.*;

import chatbot.controller.*;
import chatbot.model.ChatBotModel;

/**
 * 
 * @version1.4 2/29/16- update GUI
 * @author jlin3312
 *
 */
@SuppressWarnings("serial")
public class ChatBotPanel extends JPanel
{

	private ChatBotController baseController;// import the controller.
	private ChatBotModel baseModel;
	private JButton firstButton;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JScrollBar firstBar;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton button;
	private JTextField firstTextField;
	private JButton analyzeButton;

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
		baseLayout = new SpringLayout();
		tweetButton = new JButton("sendTweet");
		saveButton = new JButton("save");
		loadButton = new JButton("load");
		chatArea = new JTextArea(10, 25);
		chatPane = new JScrollPane(chatArea);
		button = new JButton("???");
		firstBar = new JScrollBar();
		analyzeButton = new JButton("Analyze some sweet tweets");
		firstTextField = new JTextField();
		
		
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
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		chatPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		

	}

	/**
	 * this is were you put the GUI to be dysplayed on the panel in the frame.
	 */
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setSize(500, 500);
		this.setLayout(baseLayout);// make the layout what you coded in the base
		this.add(analyzeButton);						// layout
		this.add(firstButton);
		this.add(chatPane);
		this.add(firstBar);
		this.add(tweetButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(button);
		this.add(firstTextField);
		firstTextField.setColumns(10);

	}

	private void setupLayout()// dumping ground
	{
		baseLayout.putConstraint(SpringLayout.WEST, analyzeButton, 0, SpringLayout.WEST, firstTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, analyzeButton, 6, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 19, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 12, SpringLayout.EAST, firstBar);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, loadButton, -18, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -151, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, button, 9, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, firstButton);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 26, SpringLayout.SOUTH, button);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, 0, SpringLayout.EAST, firstButton);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, 250, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -20, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstBar, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstBar, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstBar, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 4, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 152, SpringLayout.EAST, firstBar);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -150, SpringLayout.EAST, this);
	}

	private void setupListeners()// this is what buttons do.
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String currentInput = firstTextField.getText();
				//String result = baseController.getChatBotDialog(currentInput);
				showTextMessage(currentInput);// put current input as text
				//showTextMessage(result);// set up result as text
				firstTextField.setText("");// finish with empty text.
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("No text to send.");
			}
		});
			
		analyzeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = firstTextField.getText();
				String results = baseController.analyze(user);
				chatArea.setText(results);
				
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
