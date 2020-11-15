package one.jgr.game;

public enum EnemyType {
    XWING(1, "\\V/"),
    CRUISER(3, "  \\=/  ", "<==H==>");

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
