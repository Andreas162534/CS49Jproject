public class AndreasClass extends AndreasChaser implements Move {
    @Override
    public void printPosition(boolean chaser) {
        if(chaser)
            chaser = !chaser;
        return;
    }

    //can methoden von AndreasChaser benutzen, könnte auch import ausreichen?
}
