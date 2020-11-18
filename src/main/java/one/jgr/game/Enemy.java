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
            if(Main.getGame().getCycle() % 3 == 0) {
                if(e.getEnemyType().equals(EnemyType.CRUISER)) {
                    if(Game.getRandomBoolean() && Game.getRandomBoolean() && Game.getRandomBoolean()) {
                        e.shoot(ShotType.FLAK);
                    }
                } else {
                    if(Game.getRandomBoolean() && Game.getRandomBoolean() && Game.getRandomBoolean() && Game.getRandomBoolean() && Game.getRandomBoolean()) {
                        e.shoot(ShotType.STANDARD);
                    }
                }
            }
            if(Main.getGame().getCycle() % 8 == 0) {
                e.moveRight();
            } else if(Main.getGame().getCycle() % 8 == 2){
                e.moveLeft();
            }
            if(Main.getGame().getCycle() % 10 == 0) {
                e.moveDown();
            }
        }
    }

    public static void cleanup() {
        for(Enemy e: enemiesToRemove) {
            e.hide();
            enemies.remove(e);
            Game.plsDoNotDelete.add(e);
            DisplayObject.objects.remove(e.displayEnemy);
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

    public EnemyType getEnemyType() {
        return type;
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

    public void shoot(ShotType type) {
        new Shot(posX, posY -1, type, Shot.ShotDirection.DOWN);
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
