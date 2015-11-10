/** @author Michael Dobrinski - michael.git2015@gmail.com
 * COMSC 1033 Section 1411
 * Instructor: Dr. Evert
 * 27 September 2015
 */

/** Homework number 9
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

import java.util.InputMismatchException;
import java.util.Scanner;

public class COMSC_1033_HW_9_Math_Game_2 {
	public static Scanner inputAnswer = new Scanner(System.in);
	public static Scanner inputDivAnswer = new Scanner(System.in);
	public static Player player_1 = new Player(); // Create player object
	public static char mathOperator = '+';


	public static void main(String[] args) {

		player_1.setScore(0);	// Initialize score
		player_1.setRightAnswers(0); // Initialize the number of correct answers
		player_1.setWrongAnswers(0); // Initialize the number of wrong answers

		Scanner input = new Scanner(System.in);
		System.out.print("\nPlease enter your first name: ");
		String playerName = input.nextLine();
		player_1.setName(playerName);

		System.out.print("\n\n************************************************" +
		"*************************************\n");
		System.out.printf("Welcome %s! The rules for the game are:\n",
				player_1.getName());
		System.out.printf("The game consists of four rounds each of addition, " +
		"subtraction, multiplication, \nand division problems randomly generated."+
		" Each time the problem is answered \ncorrectly you will receive 5 points"+
		" and the difficulty level will increase. "+
		"If \nthe problem is answered incorrectly you will lose 5 points and "+
		"the difficulty \nlevel will be reduced. On the division problems you must"
		+ " get the answer within 0.001\n to be considered correct.");

// Start the four rounds of math problems for the operators +, - , X, and /.
		// Addition round
		mathOperator = '+';
		player_1.setLevel(1); // Initialize level to one for the addition rounds
		RoundControl();
		// Subtraction round
		mathOperator = '-';
		player_1.setLevel(1); // Initialize level to one for the subtraction rounds
		RoundControl();
		// Multiplication round
		mathOperator = 'X';
		player_1.setLevel(1); // Initialize level to one for multiplication rounds
		RoundControl();

		// Division round
		mathOperator = '/';
		player_1.setLevel(1); // Initialize level to one for the division rounds
		RoundControl();


// Print out the final results of the game.
		System.out.printf("\n\n***************************************************"
				+ "****************\n************************** Final Results ********"
				+ "******************\n");
		System.out.printf("%s your final score is %d points and you answered %4.1f"
			+ "%% of\nthe questions correctly.", player_1.getName(),
			player_1.getScore(),
			(double)player_1.getRightAnswers() /player_1.getTotalAnswers()*100.0);

		input.close();				// Close our inputs
		inputAnswer.close();
		inputDivAnswer.close();
	} // ******************** End of MAIN method ****************************

	/**
	 * Method to process each round of the math game.
	 */


	public static void RoundControl() {
		int num1;
		int num2;
		for(int round=1; round<=4; round++){
			// Make sure level does not go below 1.
			player_1.setLevel( (player_1.getLevel()<1)? 1: player_1.getLevel());

			switch (player_1.getLevel()){
				case 1:
					num1 =  MyRandoms.get1DigRandom();
					num2 =  MyRandoms.get1DigRandom();
					if (mathOperator == '/'){
						num2 = (num2 == 0)? 2 : num2;
						doubleRoundResult(num1, num2, round);
					}
					else{
					intRoundResult(num1, num2, round);
					}
					break;

				case 2:
					num1 =  MyRandoms.get2DigRandom();
					num2 =  MyRandoms.get2DigRandom();
					if (mathOperator == '/'){
						doubleRoundResult(num1, num2, round);
					}
					else{
					intRoundResult(num1, num2, round);
					}
					break;

				case 3:
					num1 =  MyRandoms.get3DigRandom();
					num2 =  MyRandoms.get3DigRandom();
					if (mathOperator == '/'){
						doubleRoundResult(num1, num2, round);
					}
					else{
					intRoundResult(num1, num2, round);
					}
					break;

				case 4:
					num1 =  MyRandoms.get4DigRandom();
					num2 =  MyRandoms.get4DigRandom();
					if (mathOperator == '/'){
						doubleRoundResult(num1, num2, round);
					}
					else{
					intRoundResult(num1, num2, round);
					}
					break;
				default:

			}	// End of switch.
		} // End of for loop.
	}


/**
 * Method to calculate the result of the round of addition.
 * Inputs: the two numbers for the problem, the player name, and round number
 * Output: The method does not return a value but modifies the global Player
 * object - score and level.
 */

	private static void intRoundResult(int num1, int num2,	int round) {
		int playerAnswer=0;
		int correctAnswer=0;
		boolean error = false;
		printRoundHeader(round);
		switch(mathOperator){ // Get the correct answer based on the math operator
		case '+':
			correctAnswer = num1 + num2;
			break;
		case '-':
			correctAnswer = num1 - num2;
			break;
		case 'X':
			correctAnswer = num1 * num2;
			break;
		}

		do {
			System.out.printf("Answer the problem: %d %c %d = ",
					num1, mathOperator, num2);

		try {
			playerAnswer = inputAnswer.nextInt();
			error = false;
		} catch (InputMismatchException ex){
			error = true;
			System.out.print("\nERROR on input: Try again with integer numbers"
				+ " only.\n");
			inputAnswer.nextLine(); // Flush the input buffer.
		}

	} while (error);
	if (playerAnswer == correctAnswer){
			player_1.adjustScore(5);
			player_1.adjustLevel(1);
			player_1.adjustRightAnswers(1);
			System.out.print("CORRECT");
		}
		else{
			player_1.adjustScore(-5);
			player_1.adjustLevel(-1);
			player_1.adjustWrongAnswers(1);
			System.out.print("INCORRECT");
		}
	} // End of intRoundResult

	/**
	 * Method to calculate the result of the round of division. The answer must
	 * be correct to within 0.001 to be considered correct.
	 * Inputs: the two numbers for the problem, the player name, and round number
	 * Output: The method does not return a value but modifies the global Player
	 * object - score and level.
	 */

		private static void doubleRoundResult(int num1, int num2,	int round) {
			double playerAnswer=0.0;
			double correctAnswer;
			boolean error = false;
			printRoundHeader(round);
			correctAnswer = (double)num1 / (double)num2;

			do {
				System.out.printf("Answer the problem: %d / %d = ", num1, num2);

			try {
				playerAnswer = inputDivAnswer.nextDouble();
				error = false;
			} catch (InputMismatchException ex){
				error = true;
				System.out.print("\nERROR on input: Try again with decimal numbers"
					+ " only.\n");
				inputAnswer.nextLine(); // Flush the input buffer.
			}

		} while (error);
		if (Math.abs(playerAnswer - correctAnswer)<=0.001){
				player_1.adjustScore(5);
				player_1.adjustLevel(1);
				player_1.adjustRightAnswers(1);
				System.out.print("CORRECT");
			}
			else{
				player_1.adjustScore(-5);
				player_1.adjustLevel(-1);
				player_1.adjustWrongAnswers(1);
				System.out.print("INCORRECT");
			}
		} // End of doubleRoundResult





	/**
	 * Method to print header information at the start of each round.
	 * Inputs: int score, int round, int level, string player's name
	 * Output: void
	 */
	public static void printRoundHeader(int r){
		System.out.printf("\n\n***************************************************"
			+ "****************\n");
		switch(mathOperator){ // Get the correct answer based on the math operator
		case '+':
			System.out.printf("*********************** Addition Round %d ********"
					+ "******************\n",r);
			break;
		case '-':
			System.out.printf("********************** Subtraction Round %d ******"
					+ "******************\n",r);
			break;
		case 'X':
			System.out.printf("********************* Multiplication Round %d ****"
					+ "******************\n",r);
			break;
		case '/':
			System.out.printf("*********************** Division Round %d ********"
					+ "******************\n",r);
			break;
		}


		System.out.printf("\n%s your score is %d and you are at a difficulty"
			+ " level of %d.\n", player_1.getName(), player_1.getScore(),
			player_1.getLevel());
	} // End of printRoundHeader.

} // **************** End of COMSC_1033_HW_6_Math_Game class ********
