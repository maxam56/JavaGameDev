package com.gamedev.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputs extends KeyAdapter {
    private Handler handler;
    private boolean[] keyMap;
    public KeyInputs(final Handler handler) {
        this.handler = handler;
        keyMap = new boolean[4];
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (GameObject o: handler.getObjectList()) {
            if (o.getID() == (ID.Player)) {
                if (key == KeyEvent.VK_W) {
                    o.setVelocityY(-5);
                    keyMap[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    keyMap[1] = true;
                    o.setVelocityY(5);
                }
                if (key == KeyEvent.VK_A) {
                    keyMap[2] = true;
                    o.setVelocityX(-5);
                }
                if (key == KeyEvent.VK_D) {
                    keyMap[3] = true;
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
                    keyMap[0] = false;
                    o.setVelocityY(0);
                }
                if (key == KeyEvent.VK_S) {
                    keyMap[1] = false;
                    o.setVelocityY(0);
                }
                if (key == KeyEvent.VK_A) {
                    keyMap[2] = false;
                    o.setVelocityX(0);
                }
                if (key == KeyEvent.VK_D) {
                    keyMap[3] = false;
                    o.setVelocityX(0);
                }

                if (!keyMap[0] && !keyMap[1]) {
                    o.setVelocityY(0);
                }
                if (!keyMap[2] && !keyMap[3]) {
                    o.setVelocityX(0);
                }
            }
        }
    }

}
