import java.util.Scanner;
import java.util.*;
public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int score;
		Random r = new Random();
		YahtzeeGame myGame=new YahtzeeGame();
		System.out.println("Welcome to Alex's APCSA Yahtzee Game!");
		score=r.nextInt(650) + 1;
		int numGames = 1;
		int scoreThreeTotal = score;
		int min = score;
		int max = score;

		System.out.println("Would you like to play again?");
		String str = s.nextLine();
		while(str.equals("yes") || str.equals("Yes")||str.equals("y")||str.equals("y")){
			score=r.nextInt(650) + 1;
			numGames++;
			scoreThreeTotal = scoreThreeTotal + score;
			if(score < min){
				min = score;
			}
			if(score > max){
				max = score;
			}
			System.out.println("Would you like to play again?");
			str = s.nextLine();
		}
		System.out.println("You have played " + numGames + " games");
		System.out.println("Average is " + (scoreThreeTotal / numGames));
		System.out.println("The Minimum is " + min);
		System.out.println("The Maximum is " + max);

	}
}
