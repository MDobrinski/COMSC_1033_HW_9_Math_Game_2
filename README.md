# Homework Assignment 9

## Abstract
The Homework 9 programming problem was to modify the math game from homework 6 to include methods and for loops. Since the program that was written for homework 6 already used methods and for loops it was decided to expand the program to have four rounds of math problems for each of the four math operators, addition, subtraction, multiplication, and division. Each round would continue to include increasing difficulty as the problems were answered correctly and a decrease in difficulty if they were answered incorrectly. The difficulty level is reset to 1 when the math operator is changed. The development of the project was tracked using Git-SCM and GitHub was used as the remote repository server. Three classes were written for the project with the plan being to make the code useful for future projects. 

## Summary
Homework assignment 9 was to modify the math game program from homework 6 to use methods and for loops. Since the program written for homework 6 already used methods and for loops it was decided to expand the math game to have four rounds of problems for each of the four math operators, addition, subtraction, multiplication, and division. The player’s progress is tracked and as they answer the problems correctly through the four rounds for each of the math operators the level of difficulty is increased. If the answer to the problem is wrong then the level of difficulty is reduced. The player is awarded 5 points for each correct answer and they lose 5 points for each incorrect answer. The difficulty level is reset to 1 when the type of math problem is changed. The assignment also required the use of the Git-SCM software to track development. The program was first written as a single file and then later in the development the single file was broken into three files.

The nature of the program problem made the use of separate class files reasonable so a Player class was written to contain player information and provide methods to access and use that information. A class was also written to provide methods generating random numbers. This will allow for easy access to this code for use in future programs should the need arise.

The Git-SCM was used to track the project during development and it proved to be a valuable tool helping with tracking the development over various branches and then with the integration of the branches into one complete program. GitHub was also used giving access to the project during the development to interested persons who could make comments and suggestions as well as code corrections.




# Homework Assignment Number 9
This homework assignment is to write a program and use the Git-SCM to track program development. The programing problem is to modify the math game program from homework 6 to use methods and for loops. Since the solution used for homework 6 already uses methods and for loops the program was modified to generate four rounds each of addition, subtraction, multiplication, and division problems. The player will receive points for each correct answer and they will lose points for incorrect answers. Each time the player answers correctly the difficulty of the problems will be increased and if they answer incorrectly the difficulty of the problems will be decreased. When the type of math problem is changed the difficulty level is reset to 1 to start the next set problems. The code for the program solution is below in three code sections, one for each of the java files. Following the code sections is some sample output for the program. The programming solution is also available on GitHub at           (https://github.com/MDobrinski/COMSC_1033_HW_9_Math_Game_2/releases/). The release used for the homework assignment is v1.0.0.

The program consists of three classes, COMSC_1033_HW_9_Math_Game_2.java, Player.java, and MyRandoms.java. The file COMSC_1033_HW_9_Math_Game_2 .java contains the main method as well as four other methods. The Player.java file contains the methods needed to create Player objects used in the main program and the MyRandoms.java file contains methods used to generate various random numbers.

## CODE – COMSC_1033_HW_9_Math_Game_2.java
```java
/** @author Michael Dobrinski - michael.git2015@gmail.com
 * COMSC 1033 Section 1411
 * Instructor: Dr. Evert
 * 04 November 2015
 */

/** Homework number 9
 *
 * Let us make a math game. The user will be asked a simple math problem in
 * the first round. For example, to add two single digit numbers. If the user
 * gets this correct, they will be given points and asked a more difficult
 * math problem in round 2, such as adding a pair of two digit numbers.
 * They will receive more points and be asked more difficult questions in the
 * following round for every correct answer. Every incorrect answer will be
 * followed by a more simple question. There should be a total of 4 rounds for
 * each of the four math operators, addition, subtraction, multiplication, and
 * division. At the end of 16 rounds, the code should print the final score.
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

} // **************** End of COMSC_1033_HW_9_Math_Game_2 class ********
```

The COMSC_1033_HW_9_Math_Game_2.java file consists of five methods, main, RoundControl, intRoundResult, doubleRoundResult, and printRoundHeader. The program instantiates the Player object player_1 and the Scanner object inputAnswer outside of the main method giving both objects scope throughout the class. The character variable mathOperator is declared outside of the main class so that it will have scope throughout the class. Inside the main method several of the player_1 attributes are initialized and another Scanner object, input, is created. The main method then prompts the user for their first name using the Scanner object input to get the string using nextLine. After the player name is read the program displays a welcome message and explains the rules of the game. Following this the game starts.

The main body of the program consists of only a few statements as most of the execution is taken care of in various methods. After the rules of the game are displayed the mathOperator is set to ‘+’, the player difficulty level is set to 1, and the RoundControl method is called. A FOR loop makes up the body of the RoundControl method and is used to control the number of rounds for each of the four math operators. Inside the FOR loop is a SWITCH construct that contains four CASEs. The difficulty level, level variable, is used as the control for the SWICH so that based on the level variable, the appropriate CASE is executed. Inside each CASE two random numbers are obtained with CASE 1 getting one digit integers, CASE 2 getting two digit integers and so on. After the random integers for that round are found then the intRoundResult method is called for the addition, subtraction, and multiplication operators. If the math operator is division then the doubleRoundResult method is called. The inputs for both of the intRoundResult and doubleRoundResult methods are the two random integers and the round number.

Inside both the intRoundResult method and the doubleRoundResult method the printRoundHeader method is used to display the status of the game showing the player name, score, and level. After execution returns from the printRoundHeader method the correct answer is calculated and the program enters a DO – WHILE loop. Inside the DO – WHILE loop the math problem is displayed and the player is prompted for the answer. The prompt for the answer is contained in a TRY block followed by a CATCH block to handle any InputMismatchExceptions should the player enter anything other than an integer for their answer. 

If there is an InputMismatchException the CATCH block displays an error message, clears the inputAnswer object stream, and sets the Boolean variable error to true causing the DO – WHILE loop to execute again. If the player enters a valid number for the answer then the variable error is set to false and the program exits the DO – WHILE loop.

Once program execution exits the DO – WHILE loop the player’s answer to the problem is compared to the correct answer, calculated earlier in the method, in an IF – ELSE construct. If the player answer is equal to the correct answer then the player score is adjusted by a positive 5 points, the level is adjusted by a positive 1, the number of right answers is increased by 1, the message “CORRECT” is displayed, and program execution returns to the CASE from which the roundResult method was called. The program breaks out of the SWITCH and the next iteration of the FOR loop is executed as long as the variable round is less than or equal to four. Because the division results in a float type number a direct comparison of the player’s answer and correct answer would not work well so the difference between the answers is calculated and if the difference is less than 0.001 the player’s answer is considered correct.

If the player’s answer does not equal the correct answer then the player’s score is adjusted by a negative 5 points, the level is adjusted by a negative 1, the number of wrong answers is increased by 1, the message “INCORRECT” is displayed, and program execution returns to the CASE from which the roundResult method was called. The program breaks out of the SWITCH – CASE and the next iteration of the FOR loop is executed as long as the variable round is less than or equal to four. Once the variable round exceeds 4 the FOR loop exits and control is returned to the main method where mathOperator is set to the operator for the next type of problem, the difficulty level is set to 1, and the RoundControl method is called. Once all four rounds for each of the math operations is completed then the final results are displayed showing the player score and the percentage of problems that were answered correctly. Then the Scanner objects inputAnswer and input are closed. Below is the code for the other two classes in the project.

## CODE – Player.java
```java
/************************** Player.java ********************************
 * Player class is used to create Player objects.
 * There are two constructors for this class:
 * Player() - creates the object with no values
 * Player(String name) - creates the object and assigns name to the name
 * 												variable.
 * There are five (5) variables for each Player object: name, level, score,
 * rightAnswers, and wrongAnswers.
 * There is one (1) class variable, numOfPlayers, that counts the number of
 * Player objects created in the program.
 *
 */
public class Player {
	private String name;
	private int level=0;
	private int score=0;
	private static int numOfPlayers=0;
	private int rightAnswers=0;
	private int wrongAnswers=0;

	public int getTotalAnswers() { // Return the total number of answers
		return rightAnswers + wrongAnswers;
	}

	public int getRightAnswers() { // Return number of correct answers
		return rightAnswers;
	}
// Set the number of correct answers to value specified by the program
	public void setRightAnswers(int rightAnswers) {
		this.rightAnswers = rightAnswers;
	}
// Increment the number of correct answers by the value given by the program
	public void adjustRightAnswers(int changeToRA){
		rightAnswers += changeToRA;
	}

	public int getWrongAnswers() { // Return the number of wrong answers
		return wrongAnswers;
	}
//Set the number of incorrect answers to value specified by the program
	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}
//Increment the number of incorrect answers by the value given by the program
	public void adjustWrongAnswers(int changeToWA){
		wrongAnswers += changeToWA;
	}

	public String getName() {	// Return the player's name
		return name;
	}

	public void setName(String name) { // Set the name of the player
		this.name = name;
	}

	public int getLevel() { // Return the player's level in the game
		return level;
	}

	public void setLevel(int level) { // Set the player's level
		this.level = level;
	}
// Increment the level by the amount given by the program
	public void adjustLevel(int levelChange){
		level += levelChange;
	}

	public int getScore() {	// Return the player's score
		return score;
	}

	public void setScore(int score) { // Set the player's score
		this.score = score;
	}

	public void adjustScore(int scoreChange){ // Adjust the player's score
		score += scoreChange;
	}

	public static int getNumOfPlayers(){	// Get the number of player instances
		return numOfPlayers;
	}

	// ***************** Constructors ****************************************
	public Player(){ // Create a generic player without a name
		numOfPlayers++;
	}

	public Player(String name) { // Create a named player
	this.name = name;
	numOfPlayers++;
	}
} // *********** End of Player class ******************
```

The Player class is used to create a Player object that contains information about the player during the game. The class contains two constructor methods, one that can be used to instantiate an empty Player object and the other to instantiate a Player object with the name information provided at the time of instantiation. There are getter and setter methods used to manipulate the various Player variables that contain player information such as: name, score, level, number of correct answers, and number of incorrect answers. Writing the class in this manner protects the object information from direct manipulation by the program. There is one static variable called numOfPlayers that is used to keep count of the number of Player objects that are created should that information be needed in future uses of the class. 
## CODE – MyRandoms.java
```java
/***************************** MyRandoms.java****************************
 * The MyRandoms class has 4 methods that can be called to generate random
 * numbers using the Math.random method provided by Java.
 * Each method will generate a random number with the specified number of
 * digits. get1DigRandom gives a single digit random integer number between
 * 0 and 9 inclusive, that is (0<= number <=9).
 * get2DigRandom gives a two digit random integer number between
 * 10 and 99 inclusive, that is (10<= number <=99).
 */
public class MyRandoms {

	/**
	 * Generate a random number between mn (minimum) and mx (maximum) inclusive.
	 * Inputs: int minimum boundary, int maximum boundary
	 * Output: random integer between mn and mx inclusive.
	 */
	public static int randomNumber(int mn, int mx){

		int temp;
		if  (mn>mx){
			temp=mn;
			mn=mx;
			mx=temp;
		}
		return ((mx - mn + 1) * (int)(Math.random()*10000000)) / 10000000 + mn;
	}
// Return a random integer between 0 and 9 inclusive. 0<= random <=9
	public static int get1DigRandom (){
		return  (10 * (int)(Math.random()*100000)) / 100000;
	}
//Return a random integer between 10 and 99 inclusive. 10<= random <=99
	public static int get2DigRandom (){
		return  (90 * (int)(Math.random()*100000)) / 100000 + 10;
	}
//Return a random integer between 100 and 999 inclusive. 100<= random <=999
	public static int get3DigRandom (){
		return  (900 * (int)(Math.random()*100000)) / 100000 + 100;
	}
//Return a random integer between 1000 and 9999 inclusive. 1000<= random <=9999
	public static int get4DigRandom (){
		return  (9000 * (int)(Math.random()*100000)) / 100000 + 1000;
	}
} // ************** End of MyRandoms class ********************
```

The program required the generation of random numbers containing a varying number digits based on the difficulty level of the round in the game so the following formula was used to get the numbers: ((max - min + 1) * (int)(Math.random()*10000000)) / 10000000 + min. The Java Math.random method returns a double value that is greater than or equal to 0.0 and less than 1.0. Using that value the formula above will generate an integer value that is greater than or equal to min and less than or equal to max. The random number generation is contained in a class separate from the main class.

The MyRandoms class is used to provide various random integers to the calling program. There are five methods in the class get1DigRandom, get2DigRandom, get3DigRandom, get4DigRandom, and randomNumber. The 1, 2, 3, or 4 in the getXDigRandom methods indicate the number of digits in the random integer the method returns. As an example, the get3DigRandom method returns a three digit integer between 100 and 999 inclusive. The randomNumber method accepts two integer inputs and returns a random integer between the two inputs inclusive. Each of the methods in the MyRandoms class use the Math.random method that is included in the Java library. It was decided to put the random number methods in a separate class to make it easier to reuse the code in future projects. 

Some sample output from the program is provided in the console section below.

## CONSOLE
```

Please enter your first name: Bob


*************************************************************************************
Welcome Bob! The rules for the game are:
The game consists of four rounds each of addition, subtraction, multiplication, 
and division problems randomly generated. Each time the problem is answered 
correctly you will receive 5 points and the difficulty level will increase. If 
the problem is answered incorrectly you will lose 5 points and the difficulty 
level will be reduced. On the division problems you must get the answer within 0.001
 to be considered correct.

*******************************************************************
*********************** Addition Round 1 **************************

Bob your score is 0 and you are at a difficulty level of 1.
Answer the problem: 4 + 3 = 7
CORRECT

*******************************************************************
*********************** Addition Round 2 **************************

Bob your score is 5 and you are at a difficulty level of 2.
Answer the problem: 87 + 84 = 171
CORRECT

*******************************************************************
*********************** Addition Round 3 **************************

Bob your score is 10 and you are at a difficulty level of 3.
Answer the problem: 791 + 901 = 1692
CORRECT

*******************************************************************
*********************** Addition Round 4 **************************

Bob your score is 15 and you are at a difficulty level of 4.
Answer the problem: 1206 + 3753 = 4959
CORRECT

*******************************************************************
********************** Subtraction Round 1 ************************

Bob your score is 20 and you are at a difficulty level of 1.
Answer the problem: 4 - 2 = 2
CORRECT

*******************************************************************
********************** Subtraction Round 2 ************************

Bob your score is 25 and you are at a difficulty level of 2.
Answer the problem: 13 - 54 = -41
CORRECT

*******************************************************************
********************** Subtraction Round 3 ************************

Bob your score is 30 and you are at a difficulty level of 3.
Answer the problem: 879 - 306 = 573
CORRECT

*******************************************************************
********************** Subtraction Round 4 ************************

Bob your score is 35 and you are at a difficulty level of 4.
Answer the problem: 8617 - 4662 = 3955
CORRECT

*******************************************************************
********************* Multiplication Round 1 **********************

Bob your score is 40 and you are at a difficulty level of 1.
Answer the problem: 0 X 8 = 0
CORRECT

*******************************************************************
********************* Multiplication Round 2 **********************

Bob your score is 45 and you are at a difficulty level of 2.
Answer the problem: 67 X 71 = 4757
CORRECT

*******************************************************************
********************* Multiplication Round 3 **********************

Bob your score is 50 and you are at a difficulty level of 3.
Answer the problem: 173 X 592 = 102416
CORRECT

*******************************************************************
********************* Multiplication Round 4 **********************

Bob your score is 55 and you are at a difficulty level of 4.
Answer the problem: 7210 X 1419 = 10230990
CORRECT

*******************************************************************
*********************** Division Round 1 **************************

Bob your score is 60 and you are at a difficulty level of 1.
Answer the problem: 5 / 9 = 0.5555
CORRECT

*******************************************************************
*********************** Division Round 2 **************************

Bob your score is 65 and you are at a difficulty level of 2.
Answer the problem: 11 / 71 = 0.15493
CORRECT

*******************************************************************
*********************** Division Round 3 **************************

Bob your score is 70 and you are at a difficulty level of 3.
Answer the problem: 926 / 675 = 1.3718
CORRECT

*******************************************************************
*********************** Division Round 4 **************************

Bob your score is 75 and you are at a difficulty level of 4.
Answer the problem: 8020 / 5816 = 1.376
INCORRECT

*******************************************************************
************************** Final Results **************************
Bob your final score is 70 points and you answered 93.8% of
the questions correctly.
```

The Git-SCM software was used to track the source code during the development of the programming project and GitHub was used as the remote repository server for the project. The program was first written with all of the methods for the program contained in a single class. During the writing of the program Git was used to track progress and incremental commits were used so that if it was needed the program could be reverted to an earlier state to correct problems. Once the program was working, a branch off of the master was created to track development while error checking was added to the program. The project contains a total of four branches in Git, they are: master, errorTrap, patch-1, and development. A feature for the program would be developed on a branch off of the master and once it was working that branch would be merged back into the master. During a couple of the merges conflicts arose between the source code in the two branches being merged. Once these conflicts were resolved the merge was completed and development continued. Using GitHub allowed the project to be reviewed by other programmers during the development process and their input was used to correct any errors. 

After the program was working correctly it was decided to move some of the functionality out of the single class and into separate classes with the development of the Player and MyRandoms classes. The writing of these classes was done on the development branch which was merged into the master branch as the use of the classes became functional in the program. 
 
The current release for this programming project at the time this report is being written is v1.0.0 and a link to the project is included at the beginning of the report.

This programming problem has given the opportunity to use a number of program control constructs including the SWITCH – CASE construct, DO – WHILE loop, FOR loop, and IF – ELSE construct. The Math.random method provided in the Java utilities was also used. This project was such that object and method classes could be written and used effectively, allowing for their use in future programs. Numerical input from the user is contained in a TRY block and any InputMismatchExceptions will be handled in the CATCH block. The Git-SCM system was a valuable tool used during the writing of this programming project as well as GitHub for a central repository server.
