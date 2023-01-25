package pk;

import java.util.Arrays;
import java.util.HashMap;

public class Player {

    // Though to myself: Have a constructor take in a string which defines a strategy have a big function with both strategies // have a big play game class inside the same package

    protected Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};
   // public Faces[] array_of_faces = new Faces[8];

    //TEST HERE
     public Faces[] array_of_faces = {Faces.SKULL, Faces.SKULL, Faces.SKULL, Faces.PARROT, Faces.DIAMOND,Faces.DIAMOND, Faces.DIAMOND,Faces.DIAMOND};

    private int score;

    private int wins;

    protected HashMap<Faces, Integer> tracking = new HashMap<>();

    Scoring score_manager = new Scoring();
    Strategy strategy = new Strategy();

    Dice dice = new Dice();
    public int getWins(){
        return this.wins;
    }

    public void incrementWins(){
        this.wins += 1;
    }


    public void resetScore() {
        this.score = 0;
    }

    protected void addScore(int addition){
        score += addition;
    }

    public int getScore() {
        return this.score;
    }

    protected int skulls_received(){
        int skullies = 0;
        for(int i = 0; i < this.array_of_dice.length; i++){
            if(this.array_of_faces[i].equals(Faces.SKULL)){
                skullies += 1;
            }
        }
        return skullies;
    }



    public void turn_initial_strat() {
       // Scoring manager = new Scoring();
      //  Strategy strategy = new Strategy();
       // dice.rollALL(this);
        System.out.println(Arrays.toString(this.array_of_faces));
        while (!(score_manager.threeSkulls(this))) {
            System.out.println("Passed the while loop");
            boolean x = false;                              // change this to liking
            System.out.println(x);
            if (x) {
                dice.tracker(this);
                System.out.println("Passed the if loop");
                dice.reRollSome(strategy.intialStrategyNumber(this),this);
                System.out.println(Arrays.toString(this.array_of_faces));
            }
            else{
                break;
            }

        }
        dice.tracker(this);                                                     //dice.tracker gets the configuration of the dice so it tells the computer in a hashmap if I have 2 gold 3 monkey etc...
        System.out.println("The hash map came out as: " + tracking);
        if(!(score_manager.threeSkulls(this))){
            score_manager.handleGold(this);
            score_manager.handleCombos(this);
        }
        System.out.println(this.getScore());

    }

    public void shorter_turn_initial_strat() {                             // this is the method for running one turn
        dice.rollALL(this);                                          // turn starts by rolling all 8 dice
        while (!(score_manager.threeSkulls(this))) {                 // keep on playing while skulls received method returns false    (this method checks for 3 skulls and returns true if 3 skulls are found)
            if (strategy.intialStrategyReroll()) {                         // initial strategy to reroll or not to reroll
                dice.tracker(this);
                dice.reRollSome(strategy.intialStrategyNumber(this),this);   // if reroll is allowed how many dice should I reroll
            }
            else{                                                          // if no reroll then break and end turn
                break;
            }
        }
        dice.tracker(this);                                          //dice.tracker gets the configuration of the dice so it tells the computer in a hashmap if I have 2 gold 3 monkey etc...
        if(!(score_manager.threeSkulls(this))){                      // if less than three skulls
            score_manager.handleGold(this);                          // Add points of (gold and diamond) to score
            score_manager.handleCombos(this);
        }

    }
}
