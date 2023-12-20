package u4pp;

/**
 * JAVADOC HERE
 */

import java.util.Scanner;

public class RockPaperScissors {

	/* ANY CODE YOU NEED HERE */
	static String userChoice = "";
	static String computerChoice = "";
	static double computerCH;
	static double playerCH;
	static int wins = 0;
	static int losses = 0;
	static int ties = 0;
	static String playButton = "Y";

	public static String getRandomChoice() {
		String[] array = new String[]{"r", "p", "s"};
		int randomIndex = (int) (Math.random() * array.length);

		return array[randomIndex];
	}

	/**
	 * JAVADOC HERE
	 * <p>
	 * play takes in input for the user choice
	 * or will randomly choose if "any" is the input
	 * and chooses at random, r, p, or s with Math.random for the computer choice
	 * the user input and random choice is used in results method
	 * then prints the number of wins, losses, and ties
	 * play will loop as long as playbutton = y or Y (determined from input from the user)
	 * if the user chooses n or N then the method will print "Thank You for Playing" and end
	 * other
	 */
	public static void play(Scanner sc) {
		while (sc.hasNext()) {
			String userInput = sc.nextLine();
			// to lower
			String userInputLowerCase = userInput.toLowerCase();
			// if r p  s then userChoice
			if ("r".equals(userInputLowerCase) || "p".equals(userInputLowerCase) || "s".equals(userInputLowerCase)) {
				userChoice = userInputLowerCase;
				computerChoice = getRandomChoice();
			}
			// if a or any then getRandomChoice
			if ("a".equals(userInputLowerCase)||"any".equals(userInputLowerCase)) {
				userChoice = getRandomChoice();
				computerChoice = getRandomChoice();
			}
			// if y compare
			if ("y".equals(userInputLowerCase)) {
				results(userChoice, computerChoice);
			}
			// if n then over
			if ("n".equals(userInputLowerCase)) {
				System.out.println("Thank You for Playing");
				break;
			}
		}
		System.out.println(wins);
		System.out.println(losses);
		System.out.println(ties);
		System.out.println("wins count:" + wins);
		System.out.println("losses count:" + losses);
		System.out.println("ties count:" + ties);

	}


	/**
	 * JAVADOC HERE
	 * the results method compares the user input and random choice to determine where the user
	 * wins, loses, or ties
	 * based on the result the method will print a certain phrase, add 1 to a certain variable,
	 * and return a certain value
	 */
	public static int results(String playerChoice, String computerChoice) {
		/* YOUR CODE HERE */
		playerChoice = playerChoice.toLowerCase();
		computerChoice = computerChoice.toLowerCase();
//        System.out.println("Computer chose " + computerChoice);
		if (playerChoice.equals(computerChoice)) {
			ties++;
			System.out.println("it's a tie");
			return 0;
		} else if ((playerChoice.equals("r") && computerChoice.equals("s") ||
				(playerChoice.equals("p") && computerChoice.equals("r")) ||
				(playerChoice.equals("s") && computerChoice.equals("p")))) {
			wins++;
			System.out.println("you win");
			return 1;
		} else {
			losses++;
			System.out.println("you lose");
			return -1;
		}
	}



	/* any helper methods you might need */

}