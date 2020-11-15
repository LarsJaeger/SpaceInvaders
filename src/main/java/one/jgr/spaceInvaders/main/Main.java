package one.jgr.spaceInvaders.main;

import one.jgr.engine.Display;
import one.jgr.game.Player;
import one.jgr.listeners.KeyEvents;

public class Main {
    public static Display display;
    public void main(String... args) {
        // implement listeners
        new KeyEvents();
        Player p = new Player(10 , 0);
        display = new Display(10, 10);
        display.update();
    }
}
