/**
 * Created by ahsia18 on 12/15/15.
 */
public class YahtzeeScorecard
{
    /* instance data given */
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int threeKind;
    private int fourKind;
    private int fiveKind;
    private int chance;
    private int fullHouse;
    private int smStraight;
    private int lgStraight;
    private boolean bonus;
    private YahtzeeSortDice y;

    /* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
    public YahtzeeScorecard()
    {
        this.ones = -1;
        this.twos = -1;
        this.threes = -1;
        this.fours = -1;
        this.fives = -1;
        this.sixes = -1;
        this.threeKind = -1;
        this.fourKind = -1;
        this.fiveKind = -1;
        this.chance = -1;
        this.fullHouse = -1;
        this.smStraight = -1;
        this.lgStraight = -1;
        this.bonus = false;
    }

    /* 1. If the field is already full, return false
       2. Set data value ones equal to number of ones rolled multiplied by one.
       3. Update the bonus (call updateBonus())
       4. Return true   */
    public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
    {
		if(this.ones >= 0) {
            return false;
        } else {
            int numOnes = 0;
            if(die1 == 1){
                numOnes++;
            }
            if(die2 == 1){
                numOnes++;
            }
            if(die3 == 1){
                numOnes++;
            }
            if(die4 == 1){
                numOnes++;
            }
            if(die5 == 1){
                numOnes++;
            }
            this.ones = numOnes * 1;
            updateBonus();
            return true;
        }
    }

    /* 1. If the field is already full, return false
       2. Set data value twos equal to number of twos rolled multiplied by two.
       3. Update the bonus (call updateBonus())
       4. Return true   */
    public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
    {
        if(this.twos >= 0) {
            return false;
        } else {
            int numTwos = 0;
            if(die1 == 2){
                numTwos++;
            }
            if(die2 == 2){
                numTwos++;
            }
            if(die3 == 2){
                numTwos++;
            }
            if(die4 == 2){
                numTwos++;
            }
            if(die5 == 2){
                numTwos++;
            }
            this.twos = numTwos * 2;
            updateBonus();
            return true;
        }
    }

    /* 1. If the field is already full, return false
       2. Set data value threes equal to number of threes rolled multiplied by three.
       3. Update the bonus (call updateBonus())
       4. Return true  */
    public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
    {
        if(this.threes >= 0) {
            return false;
        } else {
            int numThrees = 0;
            if(die1 == 3){
                numThrees++;
            }
            if(die2 == 3){
                numThrees++;
            }
            if(die3 == 3){
                numThrees++;
            }
            if(die4 == 3){
                numThrees++;
            }
            if(die5 == 3){
                numThrees++;
            }
            this.threes = numThrees * 3;
            updateBonus();
            return true;
        }
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value fours equal to number of fours rolled multiplied by four.
       3. Update the bonus (call updateBonus())
       4. Returns true   */
    public boolean markFours(int die1, int die2, int die3, int die4, int die5)
    {
        if(this.fours >= 0) {
            return false;
        } else {
            int numFours = 0;
            if(die1 == 4){
                numFours++;
            }
            if(die2 == 4){
                numFours++;
            }
            if(die3 == 4){
                numFours++;
            }
            if(die4 == 4){
                numFours++;
            }
            if(die5 == 4){
                numFours++;
            }
            this.fours = numFours * 3;
            updateBonus();
            return true;
        }
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value fives equal to number of fives rolled multiplied by five.
       3. Update the bonus (call updateBonus())
       4. Returns true   */
    public boolean markFives(int die1, int die2, int die3, int die4, int die5)
    {
        if(this.fives >= 0) {
            return false;
        } else {
            int numFives = 0;
            if(die1 == 5){
                numFives++;
            }
            if(die2 == 5){
                numFives++;
            }
            if(die3 == 5){
                numFives++;
            }
            if(die4 == 5){
                numFives++;
            }
            if(die5 == 5){
                numFives++;
            }
            this.fives = numFives * 5;
            updateBonus();
            return true;
        }
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value sixes equal to number of sixes rolled multiplied by six.
       3. Update the bonus (call updateBonus())
       4. Returns true */
    public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
    {
        if(this.sixes >= 0) {
            return false;
        } else {
            int numSixes = 0;
            if(die1 == 6){
                numSixes++;
            }
            if(die2 == 6){
                numSixes++;
            }
            if(die3 == 6){
                numSixes++;
            }
            if(die4 == 6){
                numSixes++;
            }
            if(die5 == 6){
                numSixes++;
            }
            this.sixes = numSixes * 6;
            updateBonus();
            return true;
        }
    }

    /* 	1. If the field is already full, return false
        2. Check to see if there are actually three of the same value.
           If there are, set the data value threeKind to the value of all five dice.
           If there arenít set the value to 0.
              (Hint: use YahtzeeSortDice class!)
           4. Return true   */
    public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
    {
        if(this.threeKind >= 0) {
            return false;
        } else {
            y = new YahtzeeSortDice(die1, die2, die3, die4, die5);
            int i1 = y.getFirst();
            int i2 = y.getSecond();
            int i3 = y.getThird();
            int i4 = y.getFourth();
            int i5 = y.getFifth();
            int numOne = 0;
            int numTwo = 0;
            int numThree = 0;
            int numFour = 0;
            int numFive = 0;
            int numSix = 0;
            if(i1 == 1) {
                numOne++;
            }
            if(i2 == 1) {
                numOne++;
            }
            if(i3 == 1) {
                numOne++;
            }
            if(i4 == 1) {
                numOne++;
            }
            if(i5 == 1) {
                numOne++;
            }

            if(i1 == 2) {
                numTwo++;
            }
            if(i2 == 2) {
                numTwo++;
            }
            if(i3 == 2) {
                numTwo++;
            }
            if(i4 == 2) {
                numTwo++;
            }
            if(i5 == 2) {
                numTwo++;
            }

            if(i1 == 3) {
                numThree++;
            }
            if(i2 == 3) {
                numThree++;
            }
            if(i3 == 3) {
                numThree++;
            }
            if(i4 == 3) {
                numThree++;
            }
            if(i5 == 3) {
                numThree++;
            }

            if(i1 == 4) {
                numFour++;
            }
            if(i2 == 4) {
                numFour++;
            }
            if(i3 == 4) {
                numFour++;
            }
            if(i4 == 4) {
                numFour++;
            }
            if(i5 == 4) {
                numFour++;
            }

            if(i1 == 5) {
                numFive++;
            }
            if(i2 == 5) {
                numFive++;
            }
            if(i3 == 5) {
                numFive++;
            }
            if(i4 == 5) {
                numFive++;
            }
            if(i5 == 5) {
                numFive++;
            }

            if(i1 == 6) {
                numSix++;
            }
            if(i2 == 6) {
                numSix++;
            }
            if(i3 == 6) {
                numSix++;
            }
            if(i4 == 6) {
                numSix++;
            }
            if(i5 == 6) {
                numSix++;
            }
            if(numOne >= 3 || numTwo >= 3 || numThree >= 3 || numFour >= 3 || numFive >= 3 || numSix >= 3){
                threeKind = i1 + i2 + i3 + i4 + i5;
                return true;
            } else {
                threeKind = 0;
                return true;
            }
        }
    }

    /* 	1. If the field is already full, return false
        2. Check to see if there are actually four of the same value.
           If there are, set the data value fourKind to the value of all five dice.
           If there arenít set the value to 0;
           (Hint: use YahtzeeSortDice class!)
        4. Return true  */
    public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
    {
        if(this.fourKind >= 0) {
            return false;
        } else {
            y = new YahtzeeSortDice(die1, die2, die3, die4, die5);
            int i1 = y.getFirst();
            int i2 = y.getSecond();
            int i3 = y.getThird();
            int i4 = y.getFourth();
            int i5 = y.getFifth();
            int numOne = 0;
            int numTwo = 0;
            int numThree = 0;
            int numFour = 0;
            int numFive = 0;
            int numSix = 0;
            if(i1 == 1) {
                numOne++;
            }
            if(i2 == 1) {
                numOne++;
            }
            if(i3 == 1) {
                numOne++;
            }
            if(i4 == 1) {
                numOne++;
            }
            if(i5 == 1) {
                numOne++;
            }

            if(i1 == 2) {
                numTwo++;
            }
            if(i2 == 2) {
                numTwo++;
            }
            if(i3 == 2) {
                numTwo++;
            }
            if(i4 == 2) {
                numTwo++;
            }
            if(i5 == 2) {
                numTwo++;
            }

            if(i1 == 3) {
                numThree++;
            }
            if(i2 == 3) {
                numThree++;
            }
            if(i3 == 3) {
                numThree++;
            }
            if(i4 == 3) {
                numThree++;
            }
            if(i5 == 3) {
                numThree++;
            }

            if(i1 == 4) {
                numFour++;
            }
            if(i2 == 4) {
                numFour++;
            }
            if(i3 == 4) {
                numFour++;
            }
            if(i4 == 4) {
                numFour++;
            }
            if(i5 == 4) {
                numFour++;
            }

            if(i1 == 5) {
                numFive++;
            }
            if(i2 == 5) {
                numFive++;
            }
            if(i3 == 5) {
                numFive++;
            }
            if(i4 == 5) {
                numFive++;
            }
            if(i5 == 5) {
                numFive++;
            }

            if(i1 == 6) {
                numSix++;
            }
            if(i2 == 6) {
                numSix++;
            }
            if(i3 == 6) {
                numSix++;
            }
            if(i4 == 6) {
                numSix++;
            }
            if(i5 == 6) {
                numSix++;
            }
            if(numOne >= 4 || numTwo >= 4 || numThree >= 4 || numFour >= 4 || numFive >= 4 || numSix >= 4){
                fourKind = i1 + i2 + i3 + i4 + i5;
                return true;
            } else {
                fourKind = 0;
                return true;
            }
        }
    }

    /* 1. If the field is already full, return false
       2. Check to see if there are actually three die with the same value, and two with another value.
          If there are, set the data value fullHouse to 25.
          If there arenít set the value to 0.
          (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
    public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5) {
        if (fullHouse >= 0) {
            return false;
        } else {
            y = new YahtzeeSortDice(die1, die2, die3, die4, die5);
            int i1 = y.first;
            int i2 = y.second;
            int i3 = y.third;
            int i4 = y.fourth;
            int i5 = y.fifth;
            if (i1 == i2 && i2 == i3 && i4 == i5) {
                fullHouse = 25;
                return true;
            } else if (i1 == i2 && i3 == i4 && i4 == i5) {
                fullHouse = 25;
                return true;
            } else {
                fullHouse = 0;
                return true;
            }
        }
    }

    /* 	1. If the field is already full, return false
        2. Check to see if there are actually four consecutive dice numbers.
           If there are, set the data value smStraight to 30.
           If there arenít set the value to 0.
           (Hint: Use YahtzeeSortedDice class)
        4. Return true  */
    public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
    {
		if(smStraight >= 0){
            return false;
        } else {
            y = new YahtzeeSortDice(die1, die2, die3, die4, die5);
            int i1 = y.first;
            int i2 = y.second;
            int i3 = y.third;
            int i4 = y.fourth;
            int i5 = y.fifth;
            if((i1 + 1 == i2) && (i2 + 1 == i3) && (i3 + 1 == i4)){
                smStraight = 30;
                return true;
            } else if ((i2 + 1 == i3) && (i3 + 1 == i4) && (i4 + 1 == i5)){
                smStraight = 30;
                return true;
            } else {
                smStraight = 0;
                return true;
            }
        }
    }

    /* 	1. If the field is already full, return false
        2. Check to see if there are actually five consecutive dice numbers.
           If there are, set the data value lgStraight to 40.
           If there arenít set the value to 0;
           (Hint: use YahtzeeSortDice class!)
        3. Return true  */
    public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
    {
        if(lgStraight >= 0){
            return false;
        } else {
            y = new YahtzeeSortDice(die1, die2, die3, die4, die5);
            int i1 = y.first;
            int i2 = y.second;
            int i3 = y.third;
            int i4 = y.fourth;
            int i5 = y.fifth;
            if((i1 + 1 == i2) && (i2 + 1 == i3) && (i3 + 1 == i4) && (i4 + 1 == i5)){
                lgStraight = 40;
                return true;
            } else {
                lgStraight = 0;
                return true;
            }
        }
    }

    /* 1. If the field is already full, return false
       2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there arenít set the value to 0;
       3. Return true   */
    public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
    {
        if(fiveKind >= 0){
            return false;
        } else {
            y = new YahtzeeSortDice(die1, die2, die3, die4, die5);
            int i1 = y.first;
            int i2 = y.second;
            int i3 = y.third;
            int i4 = y.fourth;
            int i5 = y.fifth;
            if(i1 == i2 && i2 == i3 && i3 == i4 && i4 == i5){
                fiveKind = 50;
                return true;
            } else {
                fiveKind = 50;
                return true;
            }
        }

    }

    /* 1. If the field is already full, return false
       2. Set the data value chance to the value of all five dice.
       3. Return true  */
    public boolean markChance(int die1, int die2, int die3, int die4, int die5)
    {
		if(chance >= 0){
            return false;
        } else {
            chance = die1 + die2 + die3 + die4 + die5;
            return true;
        }
    }

    /* 	1. If the bonus has already been assigned, do nothing
        2. If the upper sectionís total is 63 or greater, set the data value bonus to true */
    private void updateBonus()
    {
		if(bonus != true){
            if(getUpperTotal() >= 63){
                bonus = true;
            }
        }
    }

    /* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
    public int getUpperTotal()
    {
        int i1 = ones;
        int i2 = twos;
        int i3 = threes;
        int i4 = fours;
        int i5 = fives;
        int i6 = sixes;
        if(i1 == -1){
            i1 = 0;
        }
        if(i2 == -1){
            i2 = 0;
        }
        if(i3 == -1){
            i3 = 0;
        }
        if(i4 == -1){
            i4 = 0;
        }
        if(i5 == -1){
            i5 = 0;
        }
        if(i6 == -1){
            i6 = 0;
        }
        int localbonus = 0;
        if(bonus == true){
            localbonus = 35;
        }
        return i1 + i2 + i3 + i4 + i5 + i6 + localbonus;
    }

    /* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
    public int getLowerTotal()
    {
        int i1 = threeKind;
        int i2 = fourKind;
        int i3 = fullHouse;
        int i4 = smStraight;
        int i5 = lgStraight;
        int i6 = fiveKind;
        int i7 = chance;
        if(i1 == -1){
            i1 = 0;
        }
        if(i2 == -1){
            i2 = 0;
        }
        if(i3 == -1){
            i3 = 0;
        }
        if(i4 == -1){
            i4 = 0;
        }
        if(i5 == -1){
            i5 = 0;
        }
        if(i6 == -1){
            i6 = 0;
        }
        if(i7 == -1){
            i7 = 0;
        }
        return i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }

    /* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
    public int getGrandTotal()
    {
        return getLowerTotal() + getUpperTotal();
    }

    /*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
        Sample:
        **********************************
        *  	    Yahtzee Score Card		 *
        *  					`		  	 *
        * 	Ones:				__		 *
        * 	Twos:				__		 *
        * 	Threes:				__		 *
        * 	Fours:				__		 *
        * 	Fives:				25		 *
        * 	Sixes:				__		 *
        *								 *
        *	Upper Bonus:		 0		 *
        * 	Upper Total:   		25		 *
        *								 *
        *	3 of Kind:			__		 *
        * 	4 of Kind:			__		 *
        * 	Full House:			25		 *
        * 	Sm Straight:		__		 *
        * 	Lg  Straight:		__		 *
        * 	Yahtzee:	  		 0		 *
        * 	Chance:				__		 *
        *								 *
        * 	Lower Total:		25		 *
        *								 *
        * 	Grand Total:		50		 *
        **********************************
        already implemented
    */
    public void printScoreCard()
    {
        System.out.println();
        System.out.println("*********************************");
        System.out.println("*      Yahtzee Score Card       *");
        System.out.println("*                               *");
        System.out.print("*  Ones:\t\t");
        if(ones==-1)System.out.print("__");
        else System.out.print(ones);
        System.out.println("\t*");
        System.out.print("*  Twos:\t\t");
        if(twos==-1)System.out.print("__");
        else System.out.print(twos);
        System.out.println("\t*");
        System.out.print("*  Threes:\t\t");
        if(threes==-1)System.out.print("__");
        else System.out.print(threes);
        System.out.println("\t*");
        System.out.print("*  Fours:\t\t");
        if(fours==-1)System.out.print("__");
        else System.out.print(fours);
        System.out.println("\t*");
        System.out.print("*  Fives:\t\t");
        if(fives==-1)System.out.print("__");
        else System.out.print(fives);
        System.out.println("\t*");
        System.out.print("*  Sixes:\t\t");
        if(sixes==-1)System.out.print("__");
        else System.out.print(sixes);
        System.out.println("\t*");
        System.out.println("*\t\t\t\t*");
        System.out.print("*  Upper Bonus:\t\t");
        if(bonus)System.out.print("35");
        else System.out.print("0");
        System.out.println("\t*");
        System.out.print("*  Upper Total:\t\t");
        System.out.print(this.getUpperTotal());
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  3 of Kind:\t\t");
        if(threeKind==-1)System.out.print("__");
        else System.out.print(threeKind);
        System.out.println("\t*");
        System.out.print("*  4 of Kind:\t\t");
        if(fourKind==-1)System.out.print("__");
        else System.out.print(fourKind);
        System.out.println("\t*");
        System.out.print("*  Full House:\t\t");
        if(fullHouse==-1)System.out.print("__");
        else System.out.print(fullHouse);
        System.out.println("\t*");
        System.out.print("*  Sm Straight:\t\t");
        if(smStraight==-1)System.out.print("__");
        else System.out.print(smStraight);
        System.out.println("\t*");
        System.out.print("*  Lg Straight:\t\t");
        if(lgStraight==-1)System.out.print("__");
        else System.out.print(lgStraight);
        System.out.println("\t*");
        System.out.print("*  Yahtzee:\t\t");
        if(fiveKind==-1)System.out.print("__");
        else System.out.print(fiveKind);
        System.out.println("\t*");
        System.out.print("*  Chance:\t\t");
        if(chance==-1)System.out.print("__");
        else System.out.print(chance);
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  Lower Total:\t\t");
        System.out.print(this.getLowerTotal());
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  Grand Total:\t\t");
        System.out.print(this.getGrandTotal());
        System.out.println("\t*");
        System.out.println("**********************************");
        System.out.println();
    }


}
