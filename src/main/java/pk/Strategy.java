package pk;
import java.util.Random;

public class Strategy {
    Random random = new Random();
    protected boolean initialStrategyReroll(){         // Initial strategy to reroll or not to reroll
        int x = random.nextInt(100)+1;         // "+1" so that zero isn't considered
        if(x <= 50){                                 // 50% chance of rerolling
            return true;
        }
        return false;
    }

    protected int initialStrategyNumber(Player player){              //picking the number of dice to reroll
        int lowerBound = 2;
        int upperBound = 8 - player.skulls_received();
        int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound + 1 ;
        return randomNumber;
    }

    protected boolean comboStrategyReroll(Player player){                // Combo strategy to reroll or not to reroll
        int percentage = 60;                                            // 60% chance of reroll if no combos exists
        int x = random.nextInt(100)+1;



        switch (player.getMax_value()) {
            case 3:
                percentage = 45;          // if a combo of 3 exists 45% chance of reroll
                break;
            case 4:
                percentage = 35;          // if a combo of 4 exists 35% chance of reroll
                break;
            case 5:
                percentage = 10;          // if a combo of 5 exists 10% chance of reroll
                break;
            case 6:
                percentage = 3;           // if a combo of 6 exists 3% chance of reroll
                break;
            case 7:
                percentage = 1;           // if a combo of 7 exists 1% chance of reroll
                break;
            case 8:
                percentage = 0;           // if a combo of 8 exists 0% chance of reroll
                break;
        }
        System.out.println("Chance to reroll came out as: " + percentage + "and x is :" + x);
        if(x <= percentage){              // checks random integer between 1-100
            return true;
        }
        else {
            return false;
        }
    }


}
