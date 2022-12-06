/**
 * This class provides a construct of Player and Chasers of Andreas, Ranveer and Sophie. Here is besides the getters
 * and setters also the method for the next move of that character, which is an abstract method and has therefore to be
 * implemented by the subclasses, and implements the Comparable interface.
 */
public abstract class Character implements Comparable<Character> {
    /**
     * Instance variables
     */
    private int[] position = new int[2];
    private String name;
    protected boolean player;

    /**
     * Abstract method which is implemented by Player and the Chasers. It has a valargs such that the parameter can be
     * used for the player but does not have to be provided for the chasers.
     * @param dir optional parameter to give the direction of the next move to the player
     */
    public abstract void nextMove(int[]... dir);

    /**
     * Getter for position.
     * @return position
     */
    public int[] getPosition() {
        return position;
    }


    /**
     * Setter for name.
     * @param name of the character
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for positions.
     * @param position
     */
    public void setPosition(int[] position) {
        this.position = position;
    }

    /**
     * The compareTo method of the interface Comparable to be able to compare and sort a datastructure of Characters.
     * @param o the object to be compared.
     * @return a positive number if it is bigger, for smaller it is negative
     */
    @Override
    public int compareTo(Character o) {
        if (this.player && !o.player) {
            return -50;                     // is smaller than the biggest distance (-49)
        }
        else if (!this.player && !o.player) {
            int distObject = (int) Math.sqrt(o.position[0]^2 + o.position[1]^2);
            int distThis = (int) Math.sqrt(this.position[0]^2 + this.position[1]^2);
            return distThis - distObject;   // distance between this and the object
        }
        else {
            return 50;                      // bigger than the biggest distance (49)
        }
    }
}
