package one.jgr.game;

import one.jgr.engine.Display;
import one.jgr.engine.DisplayObject;
import one.jgr.engine.DisplayObjectType;
import one.jgr.spaceInvaders.main.Main;

public class Player {
    private int lifes;
    private int position;
    private DisplayObject player;
    // constructors
    public Player() {
        lifes = 10;
        position = 0;
        player = new DisplayObject(DisplayObjectType.PLAYER);

    }
    public Player(int lifes, int position) {
        this.lifes = lifes;
        this.position = position;
        player = new DisplayObject(DisplayObjectType.PLAYER);
        player.setCoordinates( 0,this.position);
    }

    // player actions
    public void move(int i) {
        if(position + i > 0 && position + i < Main.display.getWidth()) {
            position += i;
            player.setX(position);
        }
    }

    public void moveLeft() {
        move(-1);
    }
    public void moveLeft(int i) {
        move(-1 * i);
    }

    public void moveRight() {
        move(1);
    }
    public void moveRight(int i) {
        move(i);
    }
    public void shoot() {
        //TODO
    }

    // display actions
    public void showPlayer() {

    }
    public void hidePlayer() {

    }
}
