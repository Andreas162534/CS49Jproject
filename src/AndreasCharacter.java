/**
 * This class is concrete and extends the class Character. It implements the strategic of how the chaser of Andreas
 * should move around the game field.
 */
public class AndreasCharacter extends Character {
    /**
     * Instance variables which are used to change the direction in x or y such that the chaser does not get stuck when
     * it hits the boarder.
     */
    private boolean xtoggle = true;
    private boolean ytoggle = true;

    /**
     * This constructor is used to have an initial position of the chaser which is named "AndreasChaser". It is also
     * specified that this is a chaser and not a player.
     * @param position initial position of the AndreasChaser
     */
    public AndreasCharacter(int[] position) {
        this.setName("AndreasChaser");
        this.setPosition(position);
        this.player = false;
    }

    /**
     * This method provides the strategic how the chaser of Andreas is going to move around in the game field.
     * @param dir an optional parameter which is not used in this concrete implementation of the abstract method
     */
    @Override
    public void nextMove(int[]... dir) {
        int xplayer = this.getPosition()[0];
        int yplayer = this.getPosition()[1];

        // x-axes
        if (xtoggle) {
            xplayer = xplayer + 1;
        } else {
            xplayer = xplayer - 1;
        }

        if (xplayer > Game.FIELD_SIZE-1) {
            xtoggle = false;
            xplayer = xplayer - 1;
        }
        if (xplayer < 0) {
            xtoggle = true;
            xplayer = xplayer + 1;
        }

        // y-axes
        if (ytoggle) {
            yplayer = yplayer + 1;
        } else {
            yplayer = yplayer - 1;
        }

        if (yplayer > Game.FIELD_SIZE-1) {
            ytoggle = false;
            yplayer = yplayer - 1;
        }
        if (yplayer < 0) {
            ytoggle = true;
            yplayer = yplayer + 1;
        }

        this.setPosition(new int[]{xplayer, yplayer});
    }

}
