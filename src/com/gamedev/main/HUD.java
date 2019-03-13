package com.gamedev.main;

import java.awt.*;

public class HUD {
    private int health;

    public HUD() {
        health = 100;
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
    }
}
