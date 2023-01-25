package pk;

import java.util.Arrays;
import java.util.HashMap;

public class Player {

    protected Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};
   // public Faces[] array_of_faces = new Faces[8];

    //TEST HERE
     public Faces[] array_of_faces = {Faces.SKULL, Faces.SKULL, Faces.SKULL, Faces.PARROT, Faces.DIAMOND,Faces.DIAMOND, Faces.DIAMOND,Faces.DIAMOND};

    private int score;

    private int wins;

    protected HashMap<Faces, Integer> tracking = new HashMap<>();



    Scoring manager = new Scoring();
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

    public void tracker(){
        tracking.put(Faces.GOLD, 0);
        tracking.put(Faces.MONKEY, 0);
        tracking.put(Faces.DIAMOND, 0);
        tracking.put(Faces.SABER, 0);
        tracking.put(Faces.PARROT, 0);
        for ( Faces x : array_of_faces){                                        // just increment to the faces
            switch(x){
                case GOLD:
                    tracking.compute(Faces.GOLD, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case DIAMOND:
                    tracking.compute(Faces.DIAMOND, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case MONKEY:
                    tracking.compute(Faces.MONKEY, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case SABER:
                    tracking.compute(Faces.SABER, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case PARROT:
                    tracking.compute(Faces.PARROT, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
            }

        }
    }

    public void turn_initial_strat() {
       // Scoring manager = new Scoring();
      //  Strategy strategy = new Strategy();
       // dice.rollALL(this);
        System.out.println(Arrays.toString(this.array_of_faces));
        while (!(manager.threeSkulls(this))) {
            System.out.println("Passed the while loop");
            boolean x = false;              // change this to liking
            System.out.println(x);
            if (x) {
                System.out.println("Passed the if loop");
                dice.reRollSome(strategy.intialStrategyNumber(this),this);
                System.out.println(Arrays.toString(this.array_of_faces));
            }
            else{
                break;
            }

        }
        this.tracker();                                                     //remove later
        System.out.println("The hash map came out as: " + tracking);
        if(!(manager.threeSkulls(this))){
            manager.handleGold(this);
            manager.handleCombos(this);
        }
        System.out.println(this.getScore());

    }

    public void shorter_turn_initial_strat() {                                // this is the method for running one turn
        dice.rollALL(this);                                                       // turn starts by rolling all 8 dice
        while (!(manager.threeSkulls(this))) {                          // keep on playing while skulls received method returns false    (this method checks for 3 skulls and returns true if 3 skulls are found)
            if (strategy.intialStrategyReroll()) {                            // initial strategy to reroll or not to reroll
                dice.reRollSome(strategy.intialStrategyNumber(this),this);   // if reroll is allowed how many dice should I reroll
            }
            else{                                                             // if no reroll then break and end turn
                break;
            }
        }
        if(!(manager.threeSkulls(this))){                              // if less than three skulls
            manager.handleGold(this);                  // Add points of (gold and diamond) to score
            manager.handleCombos(this);
        }

    }
}
