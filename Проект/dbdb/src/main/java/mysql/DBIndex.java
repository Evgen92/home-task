package mysql;

public enum DBIndex {

    USERID (1),
    LOGIN (2),
    PASSWORD (3),
    ADDRESSEE (4),
    TEXT (5);

    private int index;

    DBIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
