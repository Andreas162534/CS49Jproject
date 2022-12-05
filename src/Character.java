public abstract class Character implements Comparable<Character> {
    private int[] position = new int[2];
    private String name;
    protected boolean player;

    //default constructor?

    public abstract void nextMove(int[] dir);

    public int[] getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    @Override
    public int compareTo(Character o) {
        if (this.player && !o.player) {
            return -50;                     //to make case 2
        } else if (!this.player && !o.player) {

            int distObject = (int) Math.sqrt(o.position[0]^2 + o.position[1]^2);
            int distThis = (int) Math.sqrt(this.position[0]^2 + this.position[1]^2);

            return distThis - distObject ;  //this smaller

        } else {
            return 50;
        }
    }
}
