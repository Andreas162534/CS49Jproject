/**
 * This is the class which implements the interface Move and extends the SophieCharacter class.
 * It is implemented by Sophie Weikovich.
 */
public class SophieClass extends SophieCharacter implements Move{
    /**
     * This constructor calls the super class SophieCharacter.
     * @param position the intial position of Sophie's chaser
     */
    public SophieClass(int[] position) {
        super(position);
    }

    /**
     * This method prints the position of Sophie's chaser to the console. The header is specified by the interface Move.
     */
    @Override
    public void printPosition() {
        System.out.println("Position of Sophie is (" +  this.getPosition()[0] + ","+ this.getPosition()[1] + ")");
    }
}
