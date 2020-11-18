package one.jgr.game;

public enum EnemyType {
    XWING(5, "\\V/"),
    CRUISER(2, "  \\=/  ", "<==H==>");

    private String[] img;
    private int lifes;
    EnemyType(int lifes, String... imageLines) {
        this.lifes = lifes;
        img = imageLines;
    }

    public String[] getImage() {
        return img;
    }
    public int getLifes() {
        return lifes;
    }
}
