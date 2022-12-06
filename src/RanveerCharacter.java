import java.util.Random;

/**
 * This class is concrete and extends the class Character. It implements the strategic of how the chaser of Ranveer
 * should move around the game field.
 */
public class RanveerCharacter extends Character{
    /**
     * This constructor is used to have an initial position of the chaser which is named "RanveerChaser". It is also
     * specified that this is a chaser and not a player.
     * @param position initial position of the RanveerChaser
     */
    public RanveerCharacter(int[] position) {
        this.setName("RanveerCharacter");
        this.setPosition(position);
        this.player = false;
    }

    /**
     * It generates a random number between min and max.
     * @param min the minimum number
     * @param max the maximum number
     * @return the generated random number
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * This method provides the strategic how the chaser of Ranveer is going to move around in the game field.
     * @param dir an optional parameter which is not used in this concrete implementation of the abstract method
     */
    @Override
    public void nextMove(int[]... dir) { // will move at random between the board with no preset patter // WILDCARD
        int rngX = getRandomNumber(0,7);
        int rngY = getRandomNumber(0,7);
        int X = this.getPosition()[0]+rngX;
        int Y = this.getPosition()[1]+rngY;
        if(X == 4 && Y == 4) //if we are in the center of the board get a new position
            nextMove(new int[]{X, Y});
        this.setPosition(new int[]{X, Y});
    }
}
