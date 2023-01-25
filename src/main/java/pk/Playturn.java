package pk;
import java.util.Arrays;

public class Playturn {
    Scoring score_manager = new Scoring();
    Strategy strategy_Manager = new Strategy();

    Dice dice = new Dice();

    /*public void turn_initial_strat(Player player) {                  // for testing
        // dice.rollALL(this);
        System.out.println(Arrays.toString(player.array_of_faces));
        while (!(score_manager.threeSkulls(player))) {
            System.out.println("Passed the while loop");
            // dice.tracker(this);
            boolean x = false;                              // change this to liking
            System.out.println(x);
            if (x) {
                System.out.println("Passed the if loop");
                dice.reRollSome(strategy_Manager.initialStrategyNumber(player),player);
                System.out.println(Arrays.toString(player.array_of_faces));
            }
            else{
                break;
            }

        }
        //dice.tracker(this);                                                     //dice.tracker gets the configuration of the dice so it tells the computer in a hashmap if I have 2 gold 3 monkey etc...
        System.out.println("The hash map came out as: " + player.tracking);
        if(!(score_manager.threeSkulls(player))){
            score_manager.handleGold(player);
            score_manager.handleCombos(player);
        }
        System.out.println(player.getScore());

    }*/

    public void shorter_turn_initial_strat(Player player) {                             // this is the method for running one turn
        dice.rollALL(player);                                          // turn starts by rolling all 8 dice
       // System.out.println("Player "+ player.ID + " is playing");
        System.out.println(Arrays.toString(player.array_of_faces));
        while (!(score_manager.threeSkulls(player))) {                 // keep on playing while skulls received method returns false    (this method checks for 3 skulls and returns true if 3 skulls are found)
            dice.tracker(player);                                        //dice.tracker gets the configuration of the dice so it tells the computer in a hashmap if I have 2 gold 3 monkey etc...
            if (strategy_Manager.initialStrategyReroll()) {                         // initial strategy to reroll or not to reroll
                dice.reRollSome(strategy_Manager.initialStrategyNumber(player),player);   // if reroll is allowed how many dice should I reroll
            }
            else{                                                          // if no reroll then break and end turn
                break;
            }
        }
        System.out.println(Arrays.toString(player.array_of_faces));
        dice.tracker(player);
        if(!(score_manager.threeSkulls(player))){                      // if less than three skulls
            score_manager.handleGold(player);                          // Add points of (gold and diamond) to score
            score_manager.handleCombos(player);                        // Add points of combos
        }
        System.out.println(player.getScore());
    }

    public void turn_combo_strat(Player player) {
        dice.rollALL(player);
      //  System.out.println("Player "+ player.ID +" is playing");
        System.out.println(Arrays.toString(player.array_of_faces));
        while (!(score_manager.threeSkulls(player))) {
     //       System.out.println("Passed the while loop");
            dice.tracker(player);
         //   boolean x = strategy_Manager.comboStrategyReroll(player);                              // change this to liking
          //  System.out.println("the bool came back as: " + x);
            if (strategy_Manager.comboStrategyReroll(player)) {
             //   System.out.println("Passed the if loop");
                dice.rerollSomeSmart(strategy_Manager.comboStrategyNumber(player),player);
            //    System.out.println(Arrays.toString(player.array_of_faces));
            }
            else{
                break;
            }

        }
        dice.tracker(player);                                                     //dice.tracker gets the configuration of the dice so it tells the computer in a hashmap if I have 2 gold 3 monkey etc...
        //System.out.println("The hash map came out as: " + player.tracking);
        if(!(score_manager.threeSkulls(player))){
            score_manager.handleGold(player);
            score_manager.handleCombos(player);
        }
      //  System.out.println(player.getScore());

    }
}
