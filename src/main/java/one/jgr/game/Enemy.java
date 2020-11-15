package one.jgr.game;

import one.jgr.engine.DisplayObject;
import one.jgr.spaceInvaders.main.Main;

import java.util.ArrayList;

public class Enemy {


    private static ArrayList<Enemy> enemiesToRemove = new ArrayList<>();

    private static ArrayList<Enemy> enemies= new ArrayList<>();
    private int lifes;
    private EnemyType type;
    private int posX;
    private int posY;
    private DisplayObject displayEnemy;


    public static void update() {
        for(Enemy e : enemies) {
            if(Main.getGame().getCycle() % 4 == 0) {
                e.moveRight();
            } else if(Main.getGame().getCycle() % 4 == 2){
                e.moveLeft();
            }
            if(Main.getGame().getCycle() % 20 == 0) {
                e.moveDown();
            } else if(Main.getGame().getCycle() % 20 == 7) {
                e.moveDown();
            } else if(Main.getGame().getCycle() % 20 == 15) {
                e.moveUp();
            }
        }
    }

    public static void cleanup() {
        for(Enemy e: enemiesToRemove) {
            e.hide();
            enemies.remove(e);
            DisplayObject.objects.remove(e.displayEnemy);
            e.displayEnemy = null;
        }
        enemiesToRemove.clear();
    }

    public static Enemy getEnemy(Object o) {
        for(Enemy x : enemies) {
            if(x.equals(o)) return x;
        }
        return null;
    }


    // constructors
    public Enemy(int posX, int posY, EnemyType type) {
        enemies.add(this);
        this.posX = posX;
        this.posY = posY;
        this.type = type;
        displayEnemy = new DisplayObject(type.getImage(), this);
        displayEnemy.setCoordinates(posX, posY);
    }

    // active actions
    public void moveLeft() {
        posX --;
        updateDisplayEnemy();
    }
    public void moveRight(){
        posX ++;
        updateDisplayEnemy();
    }
    public void moveUp() {
        posY ++;
        updateDisplayEnemy();
    }
    public void moveDown() {
        posY --;
        updateDisplayEnemy();
    }

    public void shoot() {
        //TODO
    }

    public void hit(int damage) {
        lifes -= damage;
        if(lifes <= 0) {
            enemiesToRemove.add(this);
        }
    }

    // display actions
    private void updateDisplayEnemy() {
        displayEnemy.setCoordinates(posX, posY);
    }
    public void show() {
        displayEnemy.show();
    }
    public void hide() {
        displayEnemy.hide();
    }

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
