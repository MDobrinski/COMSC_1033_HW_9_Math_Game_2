/** @author Michael Dobrinski
 * COMSC 1033 Section 1411
 * Instructor: Dr. Evert
 * 27 September 2015
 */

/** Homework number 6
 *
 * Let us make a math game. The user will be asked a simple math problem in
 * the first round. For example, to add two single digit numbers. If the user
 * gets this correct, they will be given points and asked a more difficult
 * math problem in round 2, such as adding a pair of two digit numbers.
 * They will receive more points and be asked more difficult questions in the
 * following round for every correct answer. Every incorrect answer will be
 * followed by a more simple question. There should be a total of 4 rounds.
 * At the end of 4 rounds, the code should print the final score.
 */

import java.util.Scanner;

public class COMSC_1033_HW_6_Math_Game {

	public static void main(String[] args) {
		int minNum = 0, maxNum = 0, level=1;
		int i = 0, score=0;
		boolean gameOver = false;

		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease enter your first name: ");
		String playerName = input.nextLine();

		System.out.print("\n\n************************************************" +
		"*************************************\n");
		System.out.printf("Welcome %s! The rules for the game are:\n", playerName);
		System.out.printf("The game consists of four rounds of addition problems"+
		" randomly generated. Each time the \nproblem is answered correctly"+
		" you will receive 5 points and the difficulty level\nwill increase. "+
		"If the problem is answered incorrectly you will lose 5 points and "+
		"the\ndifficulty level will be reduced.");

		for(int round=1; round<=4; round++){
			level = (level<1)? 1: level;	// Make sure level does not go below 1.

			switch (level){
				case 1:

			}	// End of switch.



		} // End of for loop.



		input.close();
	} // ************** End of MAIN method ****************************

	/**
	 * Generate a random number between mn (minimum) and mx (maximum) inclusive.
	 * Inputs: int minimum boundary, int maximum boundary
	 * Output: random integer between mn and mx inclusive.
	 */
	public static int randomNumber(int mn, int mx){
		int result=0;

		result = ((mx - mn + 1) * (int)(Math.random()*100000)) / 100000 + mn;
		return result;
	}	// End of randomNumber.

	/**
	 * Method to print header information at the start of each round.
	 * Inputs: int score, int round, int level, string player's name
	 * Output: void
	 */
	public static void printRoundHeader(int s, int r, int lvl, String player){
		System.out.printf("\n\n*************************************************"
			+ "\n******************** Round %d ********************\n\n",r);
		System.out.printf("\n%s your score is %d and you are at a dificulty"
			+ " level of %d.\n\n", player, s, lvl);
	} // End of printRoundHeader.



} // **************** End of COMSC_1033_HW_6_Math_Game class ********
