public class Player extends Character {

    public Player(int[] position) {
        this.setName("Player");
        this.setPosition(position);
        this.player = true;
    }


    @Override
    public void nextMove(int[] dir) {
        int futurePosX = getPosition()[0] + dir[0];
        int futurePosY = getPosition()[1] + dir[1];
        if( !(futurePosX<0 || futurePosX>=Game.FIELD_SIZE || futurePosY<0 || futurePosY>=Game.FIELD_SIZE))
            this.setPosition(new int[] {futurePosX, futurePosY});
    }
}
