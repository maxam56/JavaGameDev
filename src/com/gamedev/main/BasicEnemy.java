package com.gamedev.main;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public static int MAX_HEIGHT = 16;
    public static int MAX_WIDTH = 16;

    public BasicEnemy(final int x, final int y, final int width, final int height, final ID id) {
        this(x, y, id);
        this.width = width;
        this.height = height;
    }
    public BasicEnemy(final int x, final int y, final ID id) {
        super(x, y, id);
        this.width = MAX_WIDTH;
        this.height = MAX_HEIGHT;
        setVelocityX(5);
        setVelocityY(5);
    }
    @Override
    public void tick() {
        if (getX() - getWidth()  <= 0 || getX() + getWidth() >= Game.WIDTH - getWidth()) {
            setVelocityX(-1 * getVelocityX());
        }
        if (getY() - getHeight() <= 0 || getY() + getHeight() >= Game.HEIGHT - 2*getHeight()) {
            setVelocityY(-1 * getVelocityY());
        }
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, getWidth(), getHeight());
    }
}
