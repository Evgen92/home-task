public enum DBIndex {

    USERID (1),
    LOGIN (2),
    PASSWORD (3),
    ADDRESSEE (4),
    TEXT (5);

    private Integer index;

    DBIndex(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }
}
