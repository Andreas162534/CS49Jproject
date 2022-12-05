public class AndreasClass extends AndreasCharacter implements Move {

    public AndreasClass(int[] position) {
        super(position); //AndreasCharacter constructor
    }
    @Override
    public void printPosition(boolean chaser) {   //muss noch positiont ausgeben
        System.out.println("Position of Andreas is " +  this.getPosition()[0] + ","+ this.getPosition()[1] );
    }

    //can methoden von AndreasChaser benutzen, könnte auch import ausreichen?
}
