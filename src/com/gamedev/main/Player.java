package com.gamedev.main;

import java.awt.*;

public class Player extends GameObject {

    public static int MAX_WIDTH = 32;
    public static int MAX_HEIGHT = 32;

    public Player(final int x, final int y, final int width, final int height, final ID id) {
        this(x, y, id);
        this.width = width;
        this.height = height;
    }

    public Player(final int x, final int y, final ID id) {
        super(x, y, id);
        this.width = MAX_WIDTH;
        this.height = MAX_HEIGHT;
    }

    public void tick() {
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());

        setX(Game.clamp(getX(), 0, Game.WIDTH));
        setY(Game.clamp(getY(), 0, Game.HEIGHT - 2*getHeight()));
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), 32, 32);
    }
}
