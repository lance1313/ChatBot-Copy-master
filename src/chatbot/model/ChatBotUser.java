package chatbot.model;

import chatbot.model.ChatBotModel;

public class ChatBotUser {
	// four data members.
	// at least 2 different types int String boolean
	private String userName;
	private double height;
	private int age;
	private boolean playsCardGames;
	private boolean weight;

	public ChatBotUser() {
		// if(getchatCount() < 5)
		// {
		//
		// }
		this.userName = "";

		this.age = -999;

		this.height = 100;

		this.playsCardGames = false;

	}

	/**
	 * 
	 * @return new name for the user.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 *
	 * @return new height for user
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * 
	 * @return new age for user
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @return new name for user
	 */
	public boolean isPlaysCardGames() {

		playsCardGames = false;

		return playsCardGames;
	}

	/**
	 * 
	 * @return set default weight.
	 */
	public boolean weight() {
		weight = false;
		return weight;
	}

	/**
	 * 
	 * @param playsCardGames
	 *            the supplied boolean value for this.
	 */
	public void setPlaysCardGames(boolean playsCardGames) {
		this.playsCardGames = playsCardGames;
	}

	public boolean isWeight() {
		return weight;
	}

	/**
	 * 
	 * @param weight
	 *            the users weight
	 */
	public void setWeight(boolean weight) {
		this.weight = weight;
	}

	/**
	 * 
	 * @param userName
	 *            set name for user
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 
	 * @param age
	 *            set age for user.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 
	 * @param height
	 *            set height for user
	 */
	public void setHeight(double height) {
		this.height = height;
	}

}
