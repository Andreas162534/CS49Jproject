public abstract class Character implements Comparable {
    private int[] position = new int[2];
    private String name;
    protected boolean player;

    //default constructor?

    public abstract int[] nextMove();

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

    @Override       // TODO
    public int compareTo(Object object) {
        Character o = (Character) object;
        if (this.player && !o.player) { //las mich doch
            return -50;  //to make case 2
        } else if (!this.player && !o.player) {

            int distObject = (int) Math.sqrt(o.position[0]^2 + o.position[1]^2);
            int distThis = (int) Math.sqrt(this.position[0]^2 + this.position[1]^2);

            return distThis - distObject ;  //this kleiner , dnan negativ

        } else {
            return 50;
        }
    }
}
