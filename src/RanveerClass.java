/**
 * This is the class which implements the interface Move and extends the RanveerCharacter class.
 * It is implemented by Ranveer Singh.
 */
public class RanveerClass extends RanveerCharacter implements Move{
    /**
     * This constructor calls the super class RanveerCharacter.
     * @param position the intial position of Ranveer's chaser
     */
    public RanveerClass(int[] position) {
        super(position);
    }

    /**
     * This method prints the position of Ranveer's chaser to the console. The header is specified by the interface Move.
     */
    @Override
    public void printPosition() {
        System.out.println("Position of Ranveer is (" +  this.getPosition()[0] + ","+ this.getPosition()[1] + ")");
    }
}

