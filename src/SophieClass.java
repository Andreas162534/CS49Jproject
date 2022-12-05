public class SophieClass extends SophieCharacter implements Move{
    public SophieClass(int[] position) {
        super(position);
    }

    @Override
    public void printPosition(boolean chaser) {
        System.out.println("Position of Sophie is " +  this.getPosition()[0] + ","+ this.getPosition()[1] );
    }
}
