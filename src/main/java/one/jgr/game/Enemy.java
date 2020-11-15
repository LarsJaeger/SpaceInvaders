package one.jgr.game;

import one.jgr.engine.DisplayObject;
import one.jgr.engine.DisplayObjectType;
import one.jgr.spaceInvaders.main.Main;

public class Enemy {
    private int lifes;
    private int posX;
    private int posY;
    private DisplayObject displayPlayer;
    // constructors
    public Enemy(int posX, int posY, EnemyType type) {
        this.posX = posX;
        this.posY = posY;
        displayPlayer = new DisplayObject(DisplayObjectType.ENEMY);
        displayPlayer.setCoordinates(posX, posY);
    }

    // player actions
    public void moveLeft() {
        posX --;
    }
    public void moveRight(){
        posX ++;
    }
    public void moveUp() {
        posY ++;
    }
    public void moveDown() {
        posY --;
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
