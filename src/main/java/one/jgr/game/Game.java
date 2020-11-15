package one.jgr.game;

import one.jgr.engine.Display;
import one.jgr.listeners.KeyEvents;
import one.jgr.spaceInvaders.main.Main;

public class Game {
    private Boolean stopped = false;
    private Display display;
    private Player p1;
    private int cycle = 0;
    private long dt = 100; // time between cycles


    public Game(Display display) {
        this.display = display;
        p1 = new Player(10 , 0);
        for(int i = display.getHeight(); i > 30; i--) {
            if(i % 3 == 0) {
                for (int h = 2; h < display.getWidth() - 2; h++) {
                    if (h % 10 == 0) {
                        if (i % 5 == 0) {
                            new Enemy(h, i, EnemyType.XWING);
                        } else {
                            new Enemy(h, i, EnemyType.CRUISER);
                        }
                    }
                }
            }
        }
    }

    public void start() {
        stopped = false;
        display.update();
        while(!stopped) {
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


    private void run(){
        cycle++;
        Enemy.update();
        Shot.update();
        runInteractions();
        cleanup();
    }
    public void cleanup() {
        Shot.cleanup();
        Enemy.cleanup();
        Player.cleanup();
    }

    private void runInteractions() {
        if(KeyEvents.getLeftWas() && !KeyEvents.getRightWas()) {
            p1.moveLeft();
        } else if(!KeyEvents.getLeftWas() && KeyEvents.getRightWas()) {
            p1.moveRight();
        } else if(KeyEvents.getUpWas()) {
            p1.shoot();
        }
        KeyEvents.resetWasKeys();
    }
}
