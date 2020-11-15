package one.jgr.listeners;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class KeyEvents extends JFrame implements KeyListener {
    public KeyEvents(){
        this.setLayout(new BorderLayout());
        JTextField field = new JTextField();
        field.addKeyListener(this);
        this.add(field, BorderLayout.CENTER);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static Boolean upIs = false;
    public static Boolean getUpIs() {return upIs;}
    private static Boolean downIs = false;
    public static Boolean getDownIs() {return downIs;}
    private static Boolean leftIs = false;
    public static Boolean getLeftIs() {return leftIs;}
    private static Boolean rightIs = false;
    public static Boolean getRightIs() {return rightIs;}
    private static Boolean upWas = false;
    public static Boolean getUpWas() {return upWas;}
    private static Boolean downWas = false;
    public static Boolean getDownWas() {return downWas;}
    private static Boolean leftWas = false;
    public static Boolean getLeftWas() {return leftWas;}
    private static Boolean rightWas = false;
    public static Boolean getRightWas() {return rightWas;}

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 37:
                //left
                leftIs = true;
                leftWas = true;
                break;
            case 39:
                //right
                rightIs = true;
                rightWas = true;
                break;
            case 38:
                //up
                upIs = true;
                upWas = true;
                break;
            case 40:
                //down
                downIs = true;
                downWas = true;
                break;
            case 27:
                //escape
                System.exit(0);
                //TODO
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 37:
                //left
                leftIs = false;
                break;
            case 39:
                //right
                rightIs = false;
                break;
            case 38:
                //up
                upIs = false;
                break;
            case 40:
                //down
                downIs = false;
                break;
            case 27:
                //escape
                System.exit(0);
                //TODO
                break;
        }
    }
    public static void resetWasKeys() {
        upWas = false;
        downWas = false;
        leftWas = false;
        rightWas = false;
    }
}