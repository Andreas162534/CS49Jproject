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
    public int compareTo(Object o) {
        return 0;
    }
}
