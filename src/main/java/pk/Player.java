package pk;

import java.util.Arrays;

public class Player {

    public Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};
    public Faces[] array_of_faces = new Faces[8];

    //TEST HERE
    // Faces[] array_of_faces = {Faces.SKULL, Faces.SKULL, Faces.SKULL, Faces.GOLD, Faces.DIAMOND,Faces.MONKEY, Faces.DIAMOND,Faces.MONKEY};

    private int score;

    private int wins;

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

    public void turn_initial_strat() {
        Scoring manager = new Scoring();
        Strategy strategy = new Strategy();
        dice.rollALL(this);
        System.out.println(Arrays.toString(this.array_of_faces));
        while (!(manager.threeSkulls(this))) {
            System.out.println("Passed the while loop");
            boolean x = strategy.intialStrategyReroll();
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
        if(!(manager.threeSkulls(this))){
            manager.handleScore(this.array_of_faces,this);
        }
        System.out.println(this.getScore());
    }               //One turn for testing stuff

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
            manager.handleScore(this.array_of_faces,this);                  // Add points of (gold and diamond) to score
        }
    }
}
