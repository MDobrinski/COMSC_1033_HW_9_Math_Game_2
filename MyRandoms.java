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
