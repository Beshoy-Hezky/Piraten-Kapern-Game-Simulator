package pk;

import java.util.Arrays;

public class Player {
    private int score;


    public Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};


    public Faces[] array_of_faces = new Faces[8];

    //TEST HERE
   // Faces[] array_of_faces = {Faces.SKULL, Faces.SKULL, Faces.SKULL, Faces.GOLD, Faces.DIAMOND,Faces.MONKEY, Faces.DIAMOND,Faces.MONKEY};

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int addition){
        score += addition;
    }

    public int getScore() {
        return this.score;
    }

    public int skulls_received(){
        int skullies = 0;
        for(int i = 0; i < array_of_dice.length; i++){
            if(this.array_of_faces[i].equals(Faces.SKULL)){
                skullies += 1;
            }
        }
        return skullies;
    }

    public void rollALL(){
        for(int i = 0; i < 8; i++){
            array_of_faces[i] =  this.array_of_dice[i].roll();
        }
    }
    public void reRollSome(int again){
       // System.out.println("The boolean came back as " + approved + " the random number came back as "+ again);
        if(again <= 8-this.skulls_received()) {        //to reroll number of rerolls has to consider skulls
            for (int i = 0; i < 8; i++) {
                if ( (again > 0) && !(this.array_of_faces[i].equals(Faces.SKULL))) {    // if (again>0) and (not a skull)
                    array_of_faces[i] = this.array_of_dice[i].roll();
                    again -= 1;                                                     //decrement with each iteration
                }
            }
        }
    }

    public void turn_initial_strat() {
        Scoring manager = new Scoring();
        Strategy strategy = new Strategy();
        this.rollALL();
        System.out.println(Arrays.toString(this.array_of_faces));
        while (!(manager.threeSkulls(this))) {
            System.out.println("Passed the while loop");
            boolean x = strategy.intialStrategyReroll();
            System.out.println(x);
            if (x) {
                System.out.println("Passed the if loop");
                this.reRollSome(strategy.intialStrategyNumber(this));
                System.out.println(Arrays.toString(this.array_of_faces));
            }
            else{
                break;
            }

        }
        if(!(manager.threeSkulls(this))){
            manager.handleScore(array_of_faces,this);
        }
        System.out.println(this.getScore());
    }

    public void shorter_turn_initial_strat() {
        Scoring manager = new Scoring();
        Strategy strategy = new Strategy();
        this.rollALL();
        while (!(manager.threeSkulls(this))) {
            if (strategy.intialStrategyReroll()) {
                this.reRollSome(strategy.intialStrategyNumber(this));
            }
            else{
                break;
            }
        }
        if(!(manager.threeSkulls(this))){
            manager.handleScore(array_of_faces,this);
        }
    }
}
