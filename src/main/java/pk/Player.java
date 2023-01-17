package pk;

import java.util.Arrays;

public class Player {
    private int score;
    private int skulls_received;
    public Scoring manager = new Scoring();

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
    public void reRollSome(int again){
        for(int i = 0; i < 8; i++){
            if(!(this.array_of_faces[i].equals(Faces.SKULL))&& again > 0) {    // if (not skull) and (again>0)
                array_of_faces[i] = this.array_of_dice[i].roll();
                again -= 1;                                                     //decrement with each iteration
            }
        }
    }

    public void resetskulls(){
        this.setSkulls_received(0);
    }

    public void play(){
        //this.rollALL();
        System.out.println(Arrays.toString(this.array_of_faces));
        manager.handleScore(array_of_faces, this);
       // manager.threeSkulls(array_of_faces, this);
        System.out.println(this.getScore());
        System.out.println(manager.threeSkulls(array_of_faces, this));
        this.setSkulls_received(0);
        System.out.println(this.getSkulls_received());
        //this.reRollSome(3);
        //System.out.println(Arrays.toString(this.array_of_faces));
        //manager.handleScore(array_of_faces, this);
        //System.out.println(this.getScore());
    }

}
