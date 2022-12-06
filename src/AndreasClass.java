/**
 * This is the class which implements the interface Move and extends the AndreasCharacter class.
 * It is implemented by Andreas Frauendorfer.
 */
public class AndreasClass extends AndreasCharacter implements Move {
    /**
     * This constructor calls the super class AndreasCharacter.
     * @param position the intial position of Andreas's chaser
     */
    public AndreasClass(int[] position) {
        super(position); //AndreasCharacter constructor
    }

    /**
     * This method prints the position of Andreas's chaser to the console. The header is specified by the interface Move.
     */
    @Override
    public void printPosition() {
        System.out.println("Position of Andreas is (" +  this.getPosition()[0] + ","+ this.getPosition()[1] + ")");
    }
}
