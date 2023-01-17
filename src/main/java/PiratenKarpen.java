import pk.Dice;
import pk.Player;

import java.util.Arrays;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        Player first_player = new Player();
        first_player.play();
        //System.out.println(myDice.roll());
        System.out.println("That's all folks!");
    }
    
}
