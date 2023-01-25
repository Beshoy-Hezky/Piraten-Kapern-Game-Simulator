package pk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class Game {
    private static final Logger logger = LogManager.getLogger(Game.class);

    public static void playGame(Player player1, Player player2){
        while(player1.getScore() < 6000 && player2.getScore() < 6000){              // loop keeps on running as long as both players are below 6000
            player1.playturn();                                   // calling turn method which controls which strategy to use
            player2.playturn();
            if(player2.getScore() >= 6000 && player1.getScore() < 6000){                // if player 2 reaches 6000 before player 1, then player 1 will have one more turn as per rules
                player1.playturn();
                break;                                                                  // player one plays turn then look breaks
            }
        }

        if(player1.getScore() > player2.getScore()){            // if player 1 > player 2
            player1.incrementWins();
        }
        else if (player2.getScore() > player1.getScore()){          // if player 2 > player 1          // tie is possible (some games end as ties thats why the % doesn't always add up to 100%)
            player2.incrementWins();
        }
        player1.resetScore();
        player2.resetScore();
    }

    public static void debugMode(Player player1, Player player2){         //same as playgame function but with debuggers
        while(player1.getScore() < 6000 && player2.getScore() < 6000){
            player1.playturn();
            player2.playturn();
            logger.debug("{}", Arrays.toString(player1.array_of_faces));
            logger.debug("{}",Arrays.toString(player2.array_of_faces));
            logger.debug("Player ONE score: {}" , player1.getScore());
            logger.debug("Player TWO score: {}" , player2.getScore());
            if(player2.getScore() >= 6000 && player1.getScore() < 6000){
                player1.playturn();
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
        else{                                                       // if a tie
            logger.info("ITS A TIEEE");
        }
        player1.resetScore();
        player2.resetScore();
        logger.info("Player one wins = {}" , player1.getWins());
        logger.info("Player two wins = {}" , player2.getWins());


    }      // game testing with on debugmode
}
