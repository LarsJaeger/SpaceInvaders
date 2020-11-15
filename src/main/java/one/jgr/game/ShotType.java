package one.jgr.game;

public enum ShotType {
    STANDARD(1, "*"),
    FLAK(5, "I");

    private String[] img;
    private int damage;
    ShotType(int damage, String... imageLines) {
        this.damage = damage;
        img = imageLines;
    }

    public String[] getImage() {
        return img;
    }
    public int getDamage() {
        return damage;
    }
}
