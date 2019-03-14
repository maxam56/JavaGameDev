package com.gamedev.main;

import java.awt.*;
import java.util.Random;

public class Spawner {
    public static final int MAX_BASIC_SPAWN = 5;
    public static final int MAX_SMART_SPAWN = 1;

    private final Handler handler;

    private int basicSpawns;
    private int smartSpawns;
    Random r;
    public Spawner(Handler handler) {
        this.handler = handler;
        this.r = new Random();
        this.basicSpawns = 0;
        this.smartSpawns = 0;
    }

    public void spawn() {
        int i = r.nextInt(101);
        if (i > 90) {
            if (i >= 95 && smartSpawns < MAX_SMART_SPAWN) {
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                smartSpawns++;
            } else if(basicSpawns < MAX_BASIC_SPAWN){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                basicSpawns++;
            }

        }
    }
}
