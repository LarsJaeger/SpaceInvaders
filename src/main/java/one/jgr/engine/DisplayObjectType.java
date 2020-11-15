package one.jgr.engine;

import java.util.ArrayList;

public enum DisplayObjectType {
    PLAYER("<A>"),
    ENEMY("\\V/"),
    OBSTACLE("  OOO  ", "OOOOO", "OO   OO"),
    SHOT("|");

    private String[] img;

    DisplayObjectType(String... imageLines) {
        img = imageLines;
    }

    public String[] getImageLines() {
        return img;
    }
}
