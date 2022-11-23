public class AndreasClass extends AndreasCharacter implements Move {

    public AndreasClass(int[] position) {
        super(position); //AndreasCharacter constructor
    }
    @Override
    public void printPosition(boolean chaser) {   //muss noch positiont ausgeben
        if(chaser)
            chaser = !chaser;   //ruf next move auf und prints in gui
        return;
    }

    //can methoden von AndreasChaser benutzen, könnte auch import ausreichen?
}
