package one.jgr.game;

import one.jgr.engine.Display;
import one.jgr.engine.DisplayObject;
import one.jgr.listeners.KeyEvents;
import one.jgr.spaceInvaders.main.Main;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static ArrayList<Object> plsDoNotDelete = new ArrayList<>();
    private static Random random = new Random();
    private Boolean stopped = false;
    private Display display;
    private Player p1;
    private int cycle = 0;
    private long dt = 100; // time between cycles


    public Game(Display display) {
        this.display = display;
        p1 = new Player(10, 10);
    }

    public void start() {
        stopped = false;
        display.update();
        while (!stopped) {
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
            display.update();
        }
    }

    public void stop() {
        stopped = true;
    }

    public Display getDisplay() {
        return display;
    }

    public int getCycle() {
        return cycle;
    }

    public Player getP1() {
        return p1;
    }


    private void run() {
        cycle++;
        Enemy.update();
        checkForEnd();
        Shot.update();
        runInteractions();
        cleanup();
        spawnEnemies();
    }

    public void cleanup() {
        Shot.cleanup();
        Enemy.cleanup();
        Player.cleanup();
    }

    private void checkForEnd() {
        for (DisplayObject o : DisplayObject.getAll()) {
            if (o.getObject() instanceof Enemy) {
                if (o.getLowestY() == 0) {
                    p1.hit(5);
                }
            }
        }
    }

    private void runInteractions() {
        if (KeyEvents.getLeftWas() && !KeyEvents.getRightWas()) {
            p1.moveLeft();
        } else if (!KeyEvents.getLeftWas() && KeyEvents.getRightWas()) {
            p1.moveRight();
        } else if (KeyEvents.getUpWas()) {
            p1.shoot();
        }
        KeyEvents.resetWasKeys();
    }

    public void spawnEnemies() {
        if(cycle % 50 == 0 || cycle == 0) {
            for(int x = 5; x < display.getWidth() - 5; x++) {
                if(x % 25 == 6) {
                    new Enemy(x, display.getHeight(), EnemyType.XWING);
                }
            }
        }
        if(cycle % 70 == 0 || cycle == 15) {
            for(int x = 5; x < display.getWidth() - 5; x++) {
                if(x % 17 == 6) {
                    new Enemy(x, display.getHeight(), EnemyType.CRUISER);
                }
            }
        }
    }
    public static Boolean getRandomBoolean() {
        return random.nextBoolean();
    }

}
