package S191220157;

import S191220157.Line.Position;

public class Goblin implements Linable {

    private final int r;
    private final int g;
    private final int b;
    private final int rank;

    private Position position;

    Goblin(int r, int g, int b, int rank) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rank = rank;
    }

    //getGourdByRank(int rank) 需要line来完成

    public int rank() {
        return rank;
    }

    @Override
    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getValue() {
        return this.rank();
    }

}