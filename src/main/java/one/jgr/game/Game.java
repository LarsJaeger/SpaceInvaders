package one.jgr.game;

import one.jgr.engine.Display;
import one.jgr.listeners.KeyEvents;
import one.jgr.spaceInvaders.main.Main;

public class Game {
    private Display display;
    private Player p1;
    private int cycle = 0;
    private long dt = 100; // time between cycles


    public Game(Display display) {
        this.display = display;
        p1 = new Player(10 , 0);
    }

    public void start() {
        display.update();
        while(true) {
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
            display.update();
        }
    }

    public Display getDisplay() {
        return display;
    }

    public int getCycle() {
        return cycle;
    }


    private void run(){
        cycle++;
        runInteractions();
    }

    private void runInteractions() {
        if(KeyEvents.getLeftWas() && !KeyEvents.getRightWas()) {
            p1.moveLeft();
        } else if(!KeyEvents.getLeftWas() && KeyEvents.getRightWas()) {
            p1.moveRight();
        }
        KeyEvents.resetWasKeys();
    }
}
