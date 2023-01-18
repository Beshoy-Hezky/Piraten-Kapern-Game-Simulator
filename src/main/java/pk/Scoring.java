package pk;

public class Scoring {

    // function to add 100 score for every gold or diamond
    public void handleScore(Faces [] allDice, Player player) {
        for (int i = 0; i < allDice.length; i++) {
            if (allDice[i].equals(Faces.GOLD) || allDice[i].equals(Faces.DIAMOND)) {
                player.addScore(100);
            }
        }
    }

    public boolean threeSkulls(Player player){
            if(player.skulls_received() >= 3){
                return true;
            }
            return false;
    }
}
