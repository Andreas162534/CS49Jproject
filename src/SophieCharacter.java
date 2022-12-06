import java.util.Random;

/**
 * This class is concrete and extends the class Character. It implements the strategic of how the chaser of Sophie
 * should move around the game field.
 */
public class SophieCharacter extends Character{
    /**
     * Constant variable which has all possible directions of the Sophie's chaser
     */
    private final int[][] NAVIGATION = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1},     /*horizontal or vertical moves*/
                                                    {1,1}, {1,-1}, {-1,-1}, {-1,1}}; /*diagonal moves*/

    /**
     * This constructor is used to have an initial position of the chaser which is named "SophieChaser". It is also
     * specified that this is a chaser and not a player.
     * @param position initial position of the SophieChaser
     */
    public SophieCharacter(int[] position) {
        this.setName("SophieChaser");
        this.setPosition(position);
        this.player = false;
    }

    /**
     * This method provides the strategic how the chaser of Sophie is going to move around in the game field. Here the
     * chaser is randomly moving around in the field.
     * @param dir an optional parameter which is not used in this concrete implementation of the abstract method
     */
    @Override
    public void nextMove(int[]... dir) {
        Random random = new Random();
        int randNav = random.nextInt(NAVIGATION.length);
        int newX = this.getPosition()[0]+NAVIGATION[randNav][0];
        int newY = this.getPosition()[1]+NAVIGATION[randNav][1];
        while (newX<0 || newX>=Game.FIELD_SIZE || newY<0 || newY>=Game.FIELD_SIZE){
            randNav = random.nextInt(NAVIGATION.length);
            newX = this.getPosition()[0]+NAVIGATION[randNav][0];
            newY = this.getPosition()[1]+NAVIGATION[randNav][1];
        }
        this.setPosition(new int[]{newX, newY});
    }
}
