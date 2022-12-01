import java.util.Random;
import java.src.Game;

public class SophieCharacter extends Character{
    private final int[][] NAVIGATION = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}, /*horizontal or vertical moves*/
                                                    {1,1}, {1,-1}, {-1,-1}, {-1,1}}; /*diagonal moves*/
    public SophieCharacter(int[] position) {
        this.setName("SophieChaser");
        this.setPosition(position);
        this.player = false;
    }

    @Override
    public int[] nextMove() {
        Random random = new Random();
        int rand = random.nextInt(NAVIGATION.length);

        return new int[0];
    }
}
