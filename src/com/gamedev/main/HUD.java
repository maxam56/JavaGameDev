package com.gamedev.main;

import java.awt.*;

public class HUD {
    public static final int MAX_HEALTH = 200;
    private int health;
    private int score;
    private int level;

    public HUD() {
        health = MAX_HEALTH;
        score = 0;
        level = 1;
    }

    public void tick(){
        health = Game.clamp(health, 0, MAX_HEALTH);
    }
    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(14, 14, MAX_HEALTH+2, 34);
        g.setColor(Color.BLACK);
        g.fillRect(15, 15, MAX_HEALTH, 32);

        if (health > MAX_HEALTH*3/4) {
            g.setColor(Color.GREEN);
        } else if (health > MAX_HEALTH/2) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.RED);
        }

        g.fillRect(15, 15, health, 32);

        g.setColor(Color.WHITE);

        g.drawString("Score: " + score, 15, 60);
        g.drawString("Level: " + level, 15, 75);
    }

    public void incrememntHealth(int v) {
        this.health += v;
    }

    public void decrementHealth(int v) {
        this.health -= v;
    }
}
