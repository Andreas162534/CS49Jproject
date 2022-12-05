import java.util.Random;

public class SophieCharacter extends Character{
    private final int[][] NAVIGATION = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}, /*horizontal or vertical moves*/
                                                    {1,1}, {1,-1}, {-1,-1}, {-1,1}}; /*diagonal moves*/
    public SophieCharacter(int[] position) {
        this.setName("SophieChaser");
        this.setPosition(position);
        this.player = false;
    }

    @Override
    public void nextMove(int[] dir) {
        Random random = new Random();
        int randNav = random.nextInt(NAVIGATION.length);
        int newX = this.getPosition()[0]+NAVIGATION[randNav][0];
        int newY = this.getPosition()[1]+NAVIGATION[randNav][1];
        while (newX<0 || newX>=Game.FIELD_SIZE || newY<0 || newY>=Game.FIELD_SIZE){
            randNav = random.nextInt(NAVIGATION.length);
            newX = this.getPosition()[0]+NAVIGATION[randNav][0];
            newY = this.getPosition()[1]+NAVIGATION[randNav][1];
        }
        this.setPosition(new int[]{newX, newY});
    }
}
