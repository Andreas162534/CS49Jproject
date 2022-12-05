import java.util.Random;

public class RanveerCharacter extends Character{
    public RanveerCharacter(int[] position) {
        this.setName("RanveerCharacter");
        this.setPosition(position);
        this.player = false;
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    @Override
    public void nextMove(int[] dir) { // will move at random between the board with no preset patter // WILDCARD
        int rngX = getRandomNumber(0,8);
        int rngY = getRandomNumber(0,8);
        int X = this.getPosition()[0]+rngX;
        int Y = this.getPosition()[1]+rngY;
        if(X == 4 || Y == 4) //if we are in the center of the board get a new position
            nextMove(new int[]{X, Y});
        this.setPosition(new int[]{X, Y});
    }
}
