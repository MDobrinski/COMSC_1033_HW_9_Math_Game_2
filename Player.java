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
