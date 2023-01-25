package pk;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    protected Faces Dice() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];

    }

    protected void rollALL(Player player){
        for(int i = 0; i < 8; i++){
            player.array_of_faces[i] =  player.array_of_dice[i].Dice();
        }
    }

    protected void reRollSome(int again, Player player){                                // random player strategy to reroll
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
    protected void rerollSomeSmart(int again, Player player){
        System.out.println(" the random number came back as "+ again);
        if(again <= 8- player.skulls_received() - player.tracking.get(Faces.GOLD) - player.tracking.get(Faces.DIAMOND)){
            for (int i = 0; i < 8; i++){
                if ( (again > 0) && !(player.array_of_faces[i].equals(Faces.SKULL)) && !(player.array_of_faces[i].equals(Faces.GOLD))
                        && !(player.array_of_faces[i].equals(Faces.DIAMOND)) ) {    // if (again>0) and (not a skull) and (not a gold) and (not a diamond)
                    player.array_of_faces[i] = player.array_of_dice[i].Dice();
                    again -= 1;                                                     //decrement with each iteration
                }
            }
        }

    }

    protected void tracker(Player player){                                     // function to track faces
        player.tracking.put(Faces.GOLD, 0);
        player.tracking.put(Faces.MONKEY, 0);
        player.tracking.put(Faces.DIAMOND, 0);
        player.tracking.put(Faces.SABER, 0);
        player.tracking.put(Faces.PARROT, 0);
        for ( Faces x : player.array_of_faces){                                        // just increment to the faces
            switch(x){
                case GOLD:
                    player.tracking.compute(Faces.GOLD, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case DIAMOND:
                    player.tracking.compute(Faces.DIAMOND, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case MONKEY:
                    player.tracking.compute(Faces.MONKEY, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case SABER:
                    player.tracking.compute(Faces.SABER, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
                case PARROT:
                    player.tracking.compute(Faces.PARROT, (key, val) -> (val == null) ? 1 : val + 1);
                    break;
            }

        }
    }

}
