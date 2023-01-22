import pk.Player;
import java.util.Arrays;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PiratenKarpen {
    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        Player first_player = new Player();
        Player second_player = new Player();

        if(System.getProperties().containsKey("TRACE")){                                     // check if you want to run it in trace mode
            for(int i = 0; i < 42; i++) {
                debugMode(first_player, second_player);
            }
        }
        else {
            for (int i = 0; i < 42; i++) {
                playGame(first_player, second_player);
            }
        }
        float playerA_wins = (float)(first_player.getWins()/42.0)*100;      // calculate percentage wins
        float playerB_wins = (float)(second_player.getWins()/42.0)*100;
        System.out.println();
        System.out.printf("Player 1 wins: %.2f%% \n", playerA_wins);         // display percentage wins
        System.out.printf("Player 2 wins: %.2f%% \n", playerB_wins);
        System.out.println("--------------END--------------");
    }

    public static void playGame(Player player1, Player player2){
        while(player1.getScore() < 6000 && player2.getScore() < 6000){              // loop keeps on running as long as both players are below 6000
            player1.shorter_turn_initial_strat();                                   // calling turn method which controls which strategy to use
            player2.shorter_turn_initial_strat();
            if(player2.getScore() >= 6000 && player1.getScore() < 6000){                // if player 2 reaches 6000 before player 1, then player 1 will have one more turn as per rules
                player1.shorter_turn_initial_strat();
                break;                                                                  // player one plays turn then look breaks
            }
        }

        if(player1.getScore() > player2.getScore()){            // if player 1 > player 2
            player1.incrementWins();
        }
        else if (player2.getScore() > player1.getScore()){          // if player 2 > player 1
            player2.incrementWins();
        }                                                           // tie is possible
        player1.setScore(0);
        player2.setScore(0);
    }

    public static void debugMode(Player player1, Player player2){
        while(player1.getScore() < 6000 && player2.getScore() < 6000){
            player1.shorter_turn_initial_strat();
            player2.shorter_turn_initial_strat();
            logger.debug("{}",Arrays.toString(player1.array_of_faces));
            logger.debug("{}",Arrays.toString(player2.array_of_faces));
            logger.debug("Player ONE score: {}" , player1.getScore());
            logger.debug("Player TWO score: {}" , player2.getScore());
            if(player2.getScore() >= 6000 && player1.getScore() < 6000){
                player1.shorter_turn_initial_strat();
                logger.debug("Player ONE score: {}" , player1.getScore());
                break;
            }
            logger.debug("Player ONE score: {}" , player1.getScore());
            logger.debug("Player TWO score: {}" , player2.getScore());
        }

        logger.debug("Player ONE FINAL SCORE: {}" , player1.getScore());
        logger.debug("Player TWO FINAL score: {}" , player2.getScore());

        if(player1.getScore() > player2.getScore()){            // if player 1 > player 2
            logger.info("Player 1 won this game");
            player1.incrementWins();
        }
        else if (player2.getScore() > player1.getScore()){          // if player 2 > player 1
            logger.info("Player 1 won this game");
            player2.incrementWins();
        }
        else{                                                       // if a tie   // some games end as ties thats why the % doesn't always add up to 100%
            logger.info("ITS A TIEEE");
        }
        player1.setScore(0); // change to reset score for more security
        player2.setScore(0);
        logger.info("Player one wins = {}" , player1.getWins());
        logger.info("Player two wins = {}" , player2.getWins());


    }      // game testing with on debugmode


    
}

