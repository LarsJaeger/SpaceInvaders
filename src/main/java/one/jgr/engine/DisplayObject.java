package one.jgr.engine;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DisplayObject {
    private static ArrayList<DisplayObject> objects = new ArrayList<>();
    private DisplayObjectType type;
    private boolean shown = true;
    private int x;
    private int y;
    private int lengthX;
    private int lengthY;
    private int centerX;
    private int centerY;
    private int lowestX;
    private int lowestY;
    private int highestX;
    private int highestY;
    private String[][] image;

    public DisplayObject(DisplayObjectType type) {
        objects.add(this);
        this.type = type;
        String[] imageLines = this.type.getImageLines();
        //generate image map
        image = new String[imageLines[0].length()][imageLines.length];
        for (int j = 0; j < imageLines.length; j++) {
            for (int i = 0; i < imageLines[j].length(); i++) {
                image[i][j] = imageLines[j].substring(i, i + 1);
            }
        }
        lengthX = imageLines[0].length();
        lengthY = imageLines.length;
    }

    private void updateExtremes() {
        centerX = lengthX / 2;
        centerY = lengthY / 2;
        lowestX = x - centerX;
        lowestY = y - centerY;

        // highestX
        if ((lengthX / 2) % 2 == 0) {
            highestX = getCenterX();
        } else {
            highestX = getCenterX() + 1;
        }

        // highestY
        if ((lengthY / 2) % 2 == 0) {
            highestY = centerY;
        } else {
            highestY = centerY + 1;
        }
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        updateExtremes();
    }

    public void setX(int x) {
        this.x = x;
        updateExtremes();
    }

    public void setY(int y) {
        this.y = y;
        updateExtremes();
    }

    public void hide() {
        shown = false;
    }

    public void show() {
        shown = true;
    }

    public void setShown(Boolean shown) {
        this.shown = shown;
    }

    public Boolean isShown() {
        return shown;
    }

    public String[][] getImage() {
        return image;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getLowestX() {
        return lowestX;
    }

    public int getLowestY() {
        return lowestY;
    }

    public int getHighestX() {
        return highestX;
    }

    public int getHighestY() {
        return highestY;
    }

    public int getLengthX() {
        return lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public static ArrayList<DisplayObject> getAll() {
        return objects;
    }

}
