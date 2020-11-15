package one.jgr.engine;

import one.jgr.spaceInvaders.main.Main;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Display {
    private static ArrayList<DisplayObject> objects = new ArrayList<>();
    private static int height;
    private static int width;
    public Display(int width, int height) {
        this.width = width;
        this.height = height;

    }
    public void update() {
        for (int i = 0; i < 100; ++i) System.out.println();
        System.out.println("Cycle: " + Main.getGame().getCycle());
        String[][] image = render();
        for (int y = image.length - 1; y >= 0; y--) {
            String print = "";
            for(int x = 0; x < image[0].length; x++) {
                if (image[x][y] != null) {
                    print += image[x][y];
                } else {
                    print += "O";
                }
            }
            System.out.println(print);
        }
    }
    private String[][] render() {
        String[][] out = new String[width][height];
        for(DisplayObject o : DisplayObject.getAll()) {
            if(o.isShown()) {
                for (int imageX = 0; imageX < o.getLengthX(); imageX++) {
                    for (int imageY = 0; imageY < o.getLengthY(); imageY++) {
                        if (o.getLowestX() + imageX >= 0 && o.getLowestY() + imageY >= 0 && o.getLowestX() + imageX < out[0].length && o.getLowestY() + imageY < out.length) {
                            out[o.getLowestX() + imageX][o.getLowestY() + imageY] = o.getImage()[imageX][imageY];
                        }
                    }
                }
            }
        }
        return out;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
