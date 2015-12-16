import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	public static final int NUM_SIDES = 6;
	private YahtzeeDie dieOne;
	private YahtzeeDie dieTwo;
	private YahtzeeDie dieThree;
	private YahtzeeDie dieFour;
	private YahtzeeDie dieFive;
	YahtzeeScorecard scoreBoard;
	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		dieOne = new YahtzeeDie(NUM_SIDES);
		dieTwo = new YahtzeeDie(NUM_SIDES);
		dieThree = new YahtzeeDie(NUM_SIDES);
		dieFour = new YahtzeeDie(NUM_SIDES);
		dieFive = new YahtzeeDie(NUM_SIDES);
		scoreBoard = new YahtzeeScorecard();

	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		int numTurns = 0;
		while(numTurns <= 13){
			takeTurn();
			numTurns++;
		}
		scoreBoard.printScoreCard();
		/* your code here */
		return 0;
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		Scanner s = new Scanner(System.in);
		rollDice();
		printDice();
		System.out.println("Are you satisfied with your roll? Or would you like to freeze the Dice?");
		String yN = s.nextLine();
		if(yN.equals("Yes") || yN.equals("yes") || yN.equals("y") || yN.equals("Y")){
			markScore();
		} else {
			chooseFrozen();
			rollDice();
			printDice();
			System.out.println("Are you satisfied with your roll? Or would you like to freeze the Dice?");
			yN = s.nextLine();
			if(yN.equals("Yes") || yN.equals("yes") || yN.equals("y") || yN.equals("Y")){
				markScore();
			} else {
				chooseFrozen();
				rollDice();
				printDice();
				markScore();
			}
		}

	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(dieOne.isFrozen() == false){
			dieOne.rollDie();
			dieOne.unfreezeDie();
		}
		if(dieTwo.isFrozen() == false){
			dieTwo.rollDie();
			dieTwo.unfreezeDie();
		}
		if(dieThree.isFrozen() == false){
			dieThree.rollDie();
			dieThree.unfreezeDie();
		}
		if(dieFour.isFrozen() == false){
			dieFour.rollDie();
			dieFour.unfreezeDie();
		}
		if(dieFive.isFrozen() == false){
			dieFive.rollDie();
			dieFive.unfreezeDie();
		}
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Which die do you want frozen? (Please separate with spaces)");
		String strOne = s.nextLine();
		int strLength = strOne.length();
		int currentIndex = 0;
		while(currentIndex <= strLength -1){
			if(strOne.charAt(currentIndex) == '1' || strOne.charAt(currentIndex) == '2' || strOne.charAt(currentIndex) == '3' || strOne.charAt(currentIndex) == '4' || strOne.charAt(currentIndex) == '5') {
				if (strOne.charAt(currentIndex) == '1') {
					dieOne.freezeDie();
					currentIndex++;
				} else if (strOne.charAt(currentIndex) == '2') {
					dieTwo.freezeDie();
					currentIndex++;
				} else if (strOne.charAt(currentIndex) == '3') {
					dieThree.freezeDie();
					currentIndex++;
				} else if (strOne.charAt(currentIndex) == '4') {
					dieFour.freezeDie();
					currentIndex++;
				} else if (strOne.charAt(currentIndex) == '5') {
					dieFive.freezeDie();
					currentIndex++;
				}
				currentIndex++;
			}
		}
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println("Your roll :");
		System.out.println("Die One : " + dieOne.getValue() + "\t" + "Die Two : " + dieTwo.getValue() + "\t" + "Die Three : " + dieThree.getValue() + "\t" + "Die Four : " + dieFour.getValue() + "\t" + "Die Five : " + dieFive.getValue());
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		Scanner s = new Scanner(System.in);
		scoreBoard.printScoreCard();
		int i = s.nextInt();
		boolean b = (i>= 1) && (i<= 13);
		boolean bTwo = false;
		while(!bTwo || !b) {
			bTwo = true;
			if(i == 1){

				bTwo = scoreBoard.markOnes(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 2){
				bTwo = scoreBoard.markTwos(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 3){
				bTwo = scoreBoard.markThrees(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 4){
				bTwo = scoreBoard.markFours(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 5){
				bTwo = scoreBoard.markFives(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 6){
				bTwo = scoreBoard.markSixes(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 7){
				bTwo = scoreBoard.markThreeOfAKind(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 8){
				bTwo = scoreBoard.markFourOfAKind(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 9){
				bTwo = scoreBoard.markFullHouse(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 10){
				bTwo= scoreBoard.markSmallStraight(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 11){
				bTwo = scoreBoard.markLargeStraight(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			}
			else if(i == 12) {
				bTwo = scoreBoard.markYahtzee(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			} else if(i == 13){
				bTwo = scoreBoard.markChance(dieOne.getValue(), dieTwo.getValue(), dieThree.getValue(), dieFour.getValue(), dieFive.getValue());
				System.out.println(bTwo);
			} else {
				System.out.println("Please enter a valid number");
				System.out.println(b);
				i = s.nextInt();
				b = (i>= 1) && (i<= 13);
			}
			if(bTwo == false){
				System.out.println("Please enter a valid number");
				System.out.println(b);
				i = s.nextInt();
				b = (i>= 1) && (i<= 13);
			}
			System.out.println(bTwo);
			//bTwo = (i>= 1) && (i<= 13) && bTwo;
		}
	}
}