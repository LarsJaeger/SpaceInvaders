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
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped: ");
        if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED){
            //TODO
        }else{
            //TODO
        }
        System.out.println("---");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Code: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){

            // System.exit(0);
        }
    }
}