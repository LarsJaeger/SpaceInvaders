package one.jgr.game;

import one.jgr.engine.Display;
import one.jgr.engine.DisplayObject;
import one.jgr.engine.DisplayObjectType;
import one.jgr.spaceInvaders.main.Main;

public class Player {
    private int lifes;
    private int position;
    private DisplayObject displayPlayer;
    // constructors
    public Player() {
        lifes = 10;
        position = 1;
        displayPlayer = new DisplayObject(DisplayObjectType.PLAYER);

    }
    public Player(int lifes, int position) {
        this.lifes = lifes;
        this.position = position;
        displayPlayer = new DisplayObject(DisplayObjectType.PLAYER);
        displayPlayer.setCoordinates( 0,this.position);
    }

    // player actions
    public void move(int i) {
        if(position + i > 0 && position + i < Main.getGame().getDisplay().getWidth() - 1) {
            position += i;
            displayPlayer.setX(position);
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
    // passive actions
    public void hit(int damage) {
        lifes -= damage;
    }

    // display actions
    public void show() {
        displayPlayer.show();
    }
    public void hide() {
        displayPlayer.hide();
    }
}
