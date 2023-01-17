package pk;

public class Player {
    private int score;
    private int skulls_received;
    public Scoring manager = new Scoring();

    public Dice[] array_of_dice = {new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice(),new Dice()};

    public Faces[] array_of_faces = new Faces[8];

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int addition){
        score += addition;
    }

    public int getScore() {
        return score;
    }

    public void setSkulls_received(int num_of_skulls){
        this.skulls_received = num_of_skulls;
    }

    public void increment_skulls(){
        skulls_received += 1;
    }

    public int getSkulls_received(){
        return getSkulls_received();
    }

    public void rollALL(){
        for(int i = 0; i < 8; i++){
            array_of_faces[i] =  this.array_of_dice[i].roll();
        }

        // put inside play function
        manager.handleScore(array_of_faces, this);

        manager.threeSkulls(array_of_faces);
    }

}
