import java.sql.SQLOutput;

public class AndreasCharacter extends Character {

    private boolean xtoggle = true;
    private boolean ytoggle = true;

    public AndreasCharacter(int[] position) {
        this.setName("AndreasChaser");
        this.setPosition(position);
        this.player = false;
    }

    //diagonal run!

    @Override
    public int[] nextMove() {  //strategie
        int xplayer = this.getPosition()[0];
        int yplayer = this.getPosition()[1];
        //set toggle

        if (xtoggle) {
            xplayer = xplayer + 1;
        } else {
            xplayer = xplayer - 1;
        }

        if (xplayer > 7) {
            xtoggle = false;
            xplayer = xplayer - 1;
        }
        if (xplayer < 0) {
            xtoggle = true;
            xplayer = xplayer + 1;
        }
        //move

//todo yplayer

        if (xplayer + 1 > 7) {
        } else {
        }


        this.setPosition(new int[]{xplayer, yplayer});
        return this.getPosition();
    }

}
