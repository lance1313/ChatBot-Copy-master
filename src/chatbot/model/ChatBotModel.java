package chatbot.model;

import java.util.*;

import javax.swing.*;
import chatbot.model.ChatBotUser;
import chatbot.controller.ChatBotController;

/**
 * This is where all of the methods are and sends them to the controller to send to the View.
 * 
 * @author jlin3312
 * @version1.4 11/11 updated proccess text and added notes.
 */
public class ChatBotModel
{

	private String name;
	private int chatCount;
	private ArrayList<String> memeList;
	// Arrays.asList("hi","bye","yes","no"));
	private ArrayList<String> contentList;
	private ChatBotUser myUser;
	private ArrayList<String> userInputList;

	/**
	 * creates an chatbot object with suppleid name and initializes the current number of chats to zero
	 * 
	 * @param name
	 */

	public ChatBotModel(String name)

	{
		this.name = name;
		chatCount = 0;
		memeList = new ArrayList<String>();// use paranthesis to call a
		myUser = new ChatBotUser();
		// constructor.
		contentList = new ArrayList<String>();
		fillTheMemeList();
		userInputList = new ArrayList<String>();

	}

	/**
	 * this returns the name value.
	 * 
	 * @return
	 */
	public String getName()// getter
	{
		return name;
	}

	/**
	 * This gets the amount of chat that is used.
	 * 
	 * @return
	 */
	public int getchatCount()
	{
		return chatCount;
	}

	/**
	 * This sets the name to the string name in chatBotController.
	 * 
	 * @param name
	 *            The new name for the chatBot.
	 */
	public void setName(String name)// setter
	{
		this.name = name;
	}

	/**
	 * these are the mems
	 */
	private void fillTheMemeList()
	{
		memeList.add("Poke");
		memeList.add("hello");
		memeList.add(" my name");
		memeList.add("cool");
		memeList.add("bye");
		memeList.add("sucker");
	}

	/**
	 * what you can fill with.
	 */

	private void fillTheContentList()
	{
		contentList.add("");
		contentList.add("");
		contentList.add("");
		contentList.add("");
	}

	/**
	 * 
	 * @param input
	 *            This is were you pass the checkers to the controller to give to the view.
	 * @return the proccesed text based on checker or other methods/arraylist.
	 */
	public String processText(String input)
	{
		String result = "";
		if (getchatCount() < 5)
		{
			result = introduceUser(input);
		}

		else if (input != null && input.length() > 0)
		{
			result = randomChatConversation(input);
		}
		else
		{
			result = "use words!!!";
			chatCount--;

		}
		chatCount++;
		return result;

	}

	/**
	 * 
	 * @param input
	 *            this is what the user inputs
	 * @return the question to the view.
	 */

	private String introduceUser(String input)
	{
		String userQuestion = "";

		if (getchatCount() == 0)
		{
			myUser.setUserName(input);
			userQuestion = "Cool name " + myUser.getUserName() + " how old are you?";
		}
		else if (getchatCount() == 1)
		{
			int userAge = Integer.parseInt(input);// takes int from string.
			myUser.setAge(userAge);
			userQuestion = "wow you're old !" + " What is your height";
		}
		else if (getchatCount() == 2)
		{
			int userAge = Integer.parseInt(input);
			myUser.setAge(userAge);
			userQuestion = " What is your height";
		}
		else if (getchatCount() == 3)
		{
			double userHeight = Double.parseDouble(input);
			myUser.setHeight(userHeight);
			userQuestion = " Do you play card games?";
		}
		else if (getchatCount() == 4)
		{
			boolean userGames = Boolean.parseBoolean(input);
			myUser.setPlaysCardGames(userGames);
			userQuestion = " I like card games.";

		}

		return userQuestion;
	}

	private String randomChatConversation(String input)
	{
		String conversation = "";
		int randomPosition = (int) (Math.random() * 6);
		if (randomPosition == 0)
		{
			// this is String checker here
			if (stringChecker(input))
			{
				conversation = "too long.";
			}

			else
			{
				conversation = "too short";

			}
		}

		else if (randomPosition == 1)
		{
			// contentChecker here.
			if (contentChecker(input))
			{
				conversation = "You are cool.";
			}
			else
			{
				conversation = "ZZZZzzz.";
			}
		}

		else if (randomPosition == 2)

		{
			if (memeChecker(input))// if it is true
			{
				conversation = "wow, " + conversation + " is a meme  wahoo!";
			}
			else
			{
				conversation = "Not a meme, try again";
			}
		}
		else if (randomPosition == 3)
		{
			// talk about user here.
		}
		else if (randomPosition == 4)
		{
			// add to our list
			userInputList.add(input);
			conversation = "Thank you for the comment";
		}

		else if (randomPosition == 5)
		{
			if (mashChecker(input))
			{
				conversation = mashingDetected(input);
			}
			else
			{
				conversation = noMashingDetected(input);
			}

		}
		else
		{
			if (UserInputChecker(input))
			{
				conversation = "nice you removed it from the list";
			}
			else
			{
				conversation = "that wasn't in the conversation before.";
			}
			// list Cheker and removal.

		}

		// else
		// {
		// input = "use words!!!!";
		// }
		updateChatCount();
		return conversation;
	}

	/**
	 * checks for keyboard mashing if the user is mashimg and sets to true if the statment equals JKL.
	 * 
	 * @param input
	 *            takes the user input.
	 * @return whether mashing has been detected.
	 */
	private boolean mashChecker(String input)
	{
		boolean isMashing = false;
		if (input.indexOf("jkl;") > -1)
		{
			isMashing = true;
		}

		return isMashing;

	}

	private String mashingDetected(String input)
	{
		String mashed = "";

		mashed = input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);// this addes the input
														// plus what they
														// inputed.
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);
		mashed += input.substring(input.length() / 2);

		return mashed;
	}

	/**
	 * 
	 * @param input
	 *            shows if you have mashed a certain way
	 * @return boolean for if you mashed.
	 */

	private String noMashingDetected(String input)
	{

		String noMashing = "Thanks for not mashing:)";
		if (input.length() > 1)
		{
			noMashing += input.substring(input.length() / 3, input.length() / 2);
		}

		else
		{

		}

		return noMashing;
	}

	/**
	 * 
	 * @param userInput
	 *            what the user inhputs
	 * @return checks your input.
	 */
	private boolean UserInputChecker(String userInput)
	{
		boolean matchesInput = false;

		for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if (userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				matchesInput = true;
				userInputList.remove(loopCount);
				loopCount--;
			}

		}
		return matchesInput;
	}

	private void updateChatCount()
	{
		chatCount++;
	}

	/**
	 * 
	 * @param input
	 *            checks what the user types in.
	 * @return the checker for what is init
	 */
	private boolean contentChecker(String input)
	{

		boolean returnWord = false;

		if (input.contains("Jacob"))
		{
			// returnWord = "hello " + input + "my name is " + name;
		}
		return returnWord;

	}

	/**
	 * 
	 * @param input
	 *            checks if the word is to long.
	 * @return says if it is to long.
	 */


	private boolean stringChecker(String input)
	{

		boolean isToLong = false;
		if (input.length() >= 10)
		{
			isToLong = true;
		}

		return isToLong;

	}

	/**
	 * 
	 * @param input
	 *            sees if the user types a meme.
	 * @return respondes to the user
	 */
	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)// for each loop.
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		for (int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)// for
																				// loop.
		{
			if (input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}

		}

		return isAMeme;

	}

	/**
	 * 
	 * 
	 * @param input
	 *            the users input
	 * @return This checks the input from the view to see if you should quit.
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equals("yes"))
		{
			okToQuit = true;
		}

		return okToQuit;

	}

}
