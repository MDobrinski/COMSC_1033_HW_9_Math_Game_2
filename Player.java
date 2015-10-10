
public class Player {
	private String name;
	private int level=0;
	private int score=0;
	private int numOfPlayers=0;
	private int rightAnswers=0;
	private int wrongAnswers=0;

	public int getRightAnswers() {
		return rightAnswers;
	}

	public void setRightAnswers(int rightAnswers) {
		this.rightAnswers = rightAnswers;
	}

	public void adjustRightAnswers(int changeToRA){
		rightAnswers += changeToRA;
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

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

	public int getNumOfPlayers(){	// Return the number of player's in the game
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


}
