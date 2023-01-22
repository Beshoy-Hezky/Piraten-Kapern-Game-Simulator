package pk;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    protected Faces Dice() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];

    }

    //TEST HERE
    // Faces[] array_of_faces = {Faces.SKULL, Faces.SKULL, Faces.SKULL, Faces.GOLD, Faces.DIAMOND,Faces.MONKEY, Faces.DIAMOND,Faces.MONKEY};

    //public Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};


    protected void rollALL(Player player){
        for(int i = 0; i < 8; i++){
            player.array_of_faces[i] =  player.array_of_dice[i].Dice();
        }
    }

    protected void reRollSome(int again, Player player){
        System.out.println(" the random number came back as "+ again);
        if(again <= 8-player.skulls_received()) {        //to reroll number of rerolls has to consider skulls
            for (int i = 0; i < 8; i++) {
                if ( (again > 0) && !(player.array_of_faces[i].equals(Faces.SKULL))) {    // if (again>0) and (not a skull)
                    player.array_of_faces[i] = player.array_of_dice[i].Dice();
                    again -= 1;                                                     //decrement with each iteration
                }
            }
        }
    }

}
