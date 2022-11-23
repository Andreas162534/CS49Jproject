public class Player extends Character {

    public Player(int[] position) {
        this.setName("Player");
        this.setPosition(position);
        this.player = true;
    }


    @Override
    public int[] nextMove() {
        return new int[0];
    }
}
