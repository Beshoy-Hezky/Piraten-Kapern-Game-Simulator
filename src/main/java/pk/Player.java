package pk;

import java.util.Arrays;

public class Player {
    private int score;
    private int skulls_received;
    public Scoring manager = new Scoring();
    public Strategy strategy = new Strategy();

    public Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};


    //public Faces[] array_of_faces = new Faces[8];

    //TEST HERE
    Faces[] array_of_faces = {Faces.SKULL, Faces.SKULL, Faces.SKULL, Faces.GOLD, Faces.DIAMOND,Faces.MONKEY, Faces.DIAMOND,Faces.MONKEY};

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int addition){
        score += addition;
    }

    public int getScore() {
        return this.score;
    }

    public void setSkulls_received(int num_of_skulls){
        this.skulls_received = num_of_skulls;
    }

    public void increment_skulls(){
        skulls_received += 1;
    }

    public int getSkulls_received(){
        return this.skulls_received;
    }

    public void rollALL(){
        for(int i = 0; i < 8; i++){
            array_of_faces[i] =  this.array_of_dice[i].roll();
        }
    }
    public void reRollSome(boolean approved, int again){
        System.out.println("The boolean came back as " + approved + " the random number came back as "+ again);
        if(approved == true && again <= 8-this.skulls_received) {        //to reroll has to be true and number of rerolls has to consider skulls
            for (int i = 0; i < 8; i++) {
                if ( (again > 0) && !(this.array_of_faces[i].equals(Faces.SKULL))) {    // if (again>0) and (not a skull)
                    array_of_faces[i] = this.array_of_dice[i].roll();
                    again -= 1;                                                     //decrement with each iteration
                }
            }
        }
    }

    public void play(){
        //this.rollALL();
        System.out.println(Arrays.toString(this.array_of_faces));
        //manager.handleScore(array_of_faces, this);
        manager.threeSkulls(array_of_faces, this);
        //System.out.println(this.getScore());
        //System.out.println(manager.threeSkulls(array_of_faces, this));
        //this.setSkulls_received(0);
       // System.out.println(this.getSkulls_received());
        this.reRollSome(strategy.intialStrategyReroll(), strategy.intialStrategyNumber(this));
        System.out.println(Arrays.toString(this.array_of_faces));
        //manager.handleScore(array_of_faces, this);
        //System.out.println(this.getScore());
    }

}
