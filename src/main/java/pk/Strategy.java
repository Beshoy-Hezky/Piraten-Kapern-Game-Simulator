package pk;
import java.util.Random;

public class Strategy {
    public boolean intialStrategyReroll(){
        Random random = new Random();
        int x = random.nextInt(100)+1;
        if(x <= 50){
            return true;
        }
        return false;
    }

    public int intialStrategyNumber(Player player){
        int lowerBound = 2;
        int upperBound = 8 - player.skulls_received();
        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound + 1;
        return randomNumber;
    }
}
