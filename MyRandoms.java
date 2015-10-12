
public class MyRandoms {

	/**
	 * Generate a random number between mn (minimum) and mx (maximum) inclusive.
	 * Inputs: int minimum boundary, int maximum boundary
	 * Output: random integer between mn and mx inclusive.
	 */
	private static int randomNumber(int mn, int mx){
		int result=0;

		result = ((mx - mn + 1) * (int)(Math.random()*100000)) / 100000 + mn;
		return result;
	}	// End of randomNumber.

	public static int get1DigRandom (){
		return  randomNumber(0, 9);
	}

	public static int get2DigRandom (){
		return  randomNumber(10, 99);
	}

	public static int get3DigRandom (){
		return  randomNumber(100, 999);
	}

	public static int get4DigRandom (){
		return  randomNumber(1000, 9999);
	}

}
