package one.jgr.spaceInvaders.main;

import one.jgr.engine.Display;
import one.jgr.game.Game;
import one.jgr.game.Player;
import one.jgr.listeners.KeyEvents;

public class Main {
    private static Game game;
    public static void main(String... args) {
        // implement listeners
        new KeyEvents();
        game = new Game(new Display(120, 40));
        game.start();


    }
    public static Game getGame() {
        return game;
    }
}