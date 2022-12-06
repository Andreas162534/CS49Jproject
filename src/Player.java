/**
 * This class extends the class Character and is designed by the whole group. This player plays against the three
 * chasers.
 */
public class Player extends Character {
    /**
     * This constructor takes the given initial position and names the Character as Player. Also it is marked that this
     * is a player and not a chaser.
     * @param position the initial position
     */
    public Player(int[] position) {
        this.setName("Player");
        this.setPosition(position);
        this.player = true;
    }

    /**
     * This method updates the position of the player.
     * @param dir the direction of the next move of the player
     */
    @Override
    public void nextMove(int[]... dir) {
        int futurePosX = getPosition()[0] + dir[0][0];
        int futurePosY = getPosition()[1] + dir[0][1];
        this.setPosition(new int[] {futurePosX, futurePosY});
    }
}
