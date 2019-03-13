package com.gamedev.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputs extends KeyAdapter {
    private Handler handler;

    public KeyInputs(final Handler handler) {
        this.handler = handler;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject o: handler.getObjectList()) {
            if (o.getID() == (ID.Player)) {
                if (key == KeyEvent.VK_W) {
                    o.setVelocityY(-5);
                } else if (key == KeyEvent.VK_S) {
                    o.setVelocityY(5);
                } else if (key == KeyEvent.VK_A) {
                    o.setVelocityX(-5);
                } else if (key == KeyEvent.VK_D) {
                    o.setVelocityX(5);
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject o: handler.getObjectList()) {
            if (o.getID() == (ID.Player)) {
                if (key == KeyEvent.VK_W) {
                    o.setVelocityY(0);
                } else if (key == KeyEvent.VK_S) {
                    o.setVelocityY(0);
                } else if (key == KeyEvent.VK_A) {
                    o.setVelocityX(0);
                } else if (key == KeyEvent.VK_D) {
                    o.setVelocityX(0);
                }
            }
        }
    }

}
