
    public class RanveerClass extends RanveerCharacter implements Move{
        public RanveerClass(int[] position) {
            super(position);
        }

        @Override
        public void printPosition(boolean chaser) {
            System.out.println("Position of Ranveer is " +  this.getPosition()[0] + ","+ this.getPosition()[1] );

        }
    }

