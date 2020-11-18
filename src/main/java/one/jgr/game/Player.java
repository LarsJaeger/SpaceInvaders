package one.jgr.game;

import one.jgr.engine.DisplayObject;
import one.jgr.spaceInvaders.main.Main;

import java.util.ArrayList;

public class Player {
    private static ArrayList<Player> playersToRemove = new ArrayList<>();

    private static ArrayList<Player> players = new ArrayList<>();
    private String[] image = new String[1];
    private int lifes;
    private int position;
    private DisplayObject displayPlayer;

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public static Player getPlayer(Object o) {
        for (Player x : players) {
            if (x.equals(o)) return x;
        }
        return null;
    }

    public static void cleanup() {
        for (Player p : playersToRemove) {
            p.hide();
            players.remove(p);
            Game.plsDoNotDelete.add(p);
            DisplayObject.objects.remove(p.displayPlayer);
        }
        playersToRemove.clear();
    }

    // constructors
    public Player() {
        players.add(this);
        image[0] = "<A>";
        lifes = 10;
        position = 1;
        displayPlayer = new DisplayObject(image, this);

    }

    public Player(int lifes, int position) {
        players.add(this);
        image[0] = "<A>";
        this.lifes = lifes;
        this.position = position;
        displayPlayer = new DisplayObject(image, this);
        displayPlayer.setCoordinates(this.position, 0);
    }

    // player actions
    public void move(int i) {
        if (position + i > 0 && position + i < Main.getGame().getDisplay().getWidth() - 1) {
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
        new Shot(position, 1, ShotType.STANDARD, Shot.ShotDirection.UP);
    }

    // passive actions
    public void hit(int damage) {
        lifes -= damage;
        if (lifes <= 0) {
            playersToRemove.add(this);
            Main.getGame().stop();
            System.out.println("You lost!");
        }
    }

    // display actions
    public void show() {
        displayPlayer.show();
    }

    public void hide() {
        displayPlayer.hide();
    }

    public String[] getImage() {
        return image;
    }

    public int getLifes() {
        return lifes;
    }
}
