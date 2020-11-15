package one.jgr.game;

import one.jgr.engine.Display;
import one.jgr.engine.DisplayObject;
import one.jgr.spaceInvaders.main.Main;

import java.util.ArrayList;

public class Shot {
    public enum ShotDirection {
        UP,
        DOWN;
    }

    private static ArrayList<Shot> shotsToRemove = new ArrayList<>();

    private static ArrayList<Shot> shots= new ArrayList<>();
    private ShotType type;
    private ShotDirection dir;
    private int posX;
    private int posY;
    private DisplayObject displayShot;

    public static void update() {
        if(!shots.isEmpty()) {
            for (Shot s : shots) {
                s.doCycle();
            }
        }
    }

    public static void cleanup() {
        for(Shot s: shotsToRemove) {
            s.hide();
            shots.remove(s);
            DisplayObject.objects.remove(s.displayShot);
            s.displayShot = null;
        }
        shotsToRemove.clear();
    }


    // constructors
    public Shot(int posX, int posY, ShotType type, ShotDirection dir) {
        shots.add(this);
        this.posX = posX;
        this.posY = posY;
        this.type = type;
        this.dir = dir;
        displayShot = new DisplayObject(type.getImage(), this);
        displayShot.setCoordinates(posX, posY);
    }

    public void doCycle() {
        if(posY > Main.getGame().getDisplay().getHeight()) {
            shotsToRemove.add(this);
            return;
        }
        switch(dir) {
            case UP:
                posY ++;
                updateDisplayShot();
                break;
            case DOWN:
                posY --;
                updateDisplayShot();
                break;
        }
        // check for collisions
        for(DisplayObject o: DisplayObject.getAll()) {
            if(!(o.getObject() instanceof Shot)) {
                if (o.getLowestX() <= posX && o.getHighestX() >= posX && o.getLowestY() <= posY && o.getHighestY() >= posY) {
                    if (o.getObject() instanceof Player) {
                        ((Player) o.getObject()).hit(type.getDamage());
                    } else if (o.getObject() instanceof Enemy) {
                        ((Enemy) o.getObject()).hit(type.getDamage());
                    } //TODO: obstacles
                    shotsToRemove.add(this);
                }
            }
        }
    }

    // display actions
    private void updateDisplayShot() {
        displayShot.setCoordinates(posX, posY);
    }
    public void show() {
        displayShot.show();
    }
    public void hide() {
        displayShot.hide();
    }

    public static ArrayList<Shot> getShots() {
        return shots;
    }
}
