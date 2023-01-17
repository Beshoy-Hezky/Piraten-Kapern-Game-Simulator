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

    public boolean threeSkulls(Faces [] alldice, Player player){
            for(int i = 0; i < alldice.length; i++) {
                if (alldice[i].equals(Faces.SKULL)) {
                    //skulls += 1;
                    player.increment_skulls();
                }
            }
            if(player.getSkulls_received() == 3){
                return true;
            }
            return false;
    }

}
