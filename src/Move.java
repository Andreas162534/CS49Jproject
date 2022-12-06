/**
 * This interface is needed to hit the requirements. It provides simply one method header to print a message into the
 * console to verify where the chasers of Andreas, Ranveer and Sophie are.
 */
public interface Move {
    /**
     * This method should be implemented by concrete classes of Sophie, Ranveer and Andreas. It is going to print a
     * message with the position of that specific chaser.
     */
    public void printPosition();
}
