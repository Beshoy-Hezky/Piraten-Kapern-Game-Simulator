import pk.Dice;
import pk.Player;

import java.util.Arrays;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        Dice myDice = new Dice();
        Player first_player = new Player();
        Player second_player = new Player();
        for(int i = 0; i < 42; i++) {
            playGame_shorter(first_player, second_player);
        }

        float playerA_wins = (float)(first_player.getWins()/42.0)*100;
        float playerB_wins = (float)(second_player.getWins()/42.0)*100;
        System.out.println();
        System.out.printf("Player 1 wins: %.2f%% \n", playerA_wins);
        System.out.printf("Player 2 wins: %.2f%% \n", playerB_wins);
        //System.out.println(myDice.roll());
        System.out.println("--------------END--------------");
    }

    public static void playGame(Player player1, Player player2){
        while(player1.getScore() < 6000 && player2.getScore() < 6000){
            player1.shorter_turn_initial_strat();
            player2.shorter_turn_initial_strat();
            System.out.println(Arrays.toString(player1.array_of_faces));   // delete later
            System.out.println(Arrays.toString(player2.array_of_faces));
            System.out.println("Player ONE score: " + player1.getScore());
            System.out.println("Player TWO score: " + player2.getScore());
            if(player2.getScore() >= 6000 && player1.getScore() < 6000){
                player1.shorter_turn_initial_strat();
                System.out.println("Player ONE score: " + player1.getScore());
                break;
            }
            System.out.println("Player ONE score: " + player1.getScore());
            System.out.println("Player TWO score: " + player2.getScore());
        }

        System.out.println("Player ONE FINAL SCORE: " + player1.getScore());
        System.out.println("Player TWO FINAL score: " + player2.getScore());

        if(player1.getScore() > player2.getScore()){            // if player 1 > player 2
            player1.incrementWins();
        }
        else if (player2.getScore() > player1.getScore()){          // if player 2 > player 1
            player2.incrementWins();
        }
        else{                                                       // if a tie
            System.out.println("ITS A TIEEE");
        }
        player1.setScore(0);
        player2.setScore(0);
        System.out.println("Player one wins = " + player1.getWins());
        System.out.println("Player two wins = " + player2.getWins());


    }      // game testing with print files

    public static void playGame_shorter(Player player1, Player player2){
        while(player1.getScore() < 6000 && player2.getScore() < 6000){
            player1.shorter_turn_initial_strat();
            player2.shorter_turn_initial_strat();
            if(player2.getScore() >= 6000 && player1.getScore() < 6000){
                player1.shorter_turn_initial_strat();
                break;
            }
        }

        if(player1.getScore() > player2.getScore()){            // if player 1 > player 2
            player1.incrementWins();
        }
        else if (player2.getScore() > player1.getScore()){          // if player 2 > player 1
            player2.incrementWins();
        }
        else{                                                       // if a tie
            System.out.println("ITS A TIEEE");
        }
        player1.setScore(0);
        player2.setScore(0);
    }
    
}
