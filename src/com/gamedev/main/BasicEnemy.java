package com.gamedev.main;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public static int MAX_HEIGHT = 16;
    public static int MAX_WIDTH = 16;
    public static int START_VEL = 3;

    public BasicEnemy(final int x, final int y, final ID id, final Handler handler) {
        super(x, y, MAX_WIDTH, MAX_HEIGHT, id, handler, Color.RED);

        setVelocityX(START_VEL);
        setVelocityY(START_VEL);
    }

    public BasicEnemy(final int x, final int y, final ID id, final Handler handler, Color color) {
        super(x, y, MAX_WIDTH, MAX_HEIGHT, id, handler, color);

        setVelocityX(START_VEL);
        setVelocityY(START_VEL);
    }

    public BasicEnemy(final int x, final int y, final int width, final int height, final ID id, final Handler handler) {
        super(x, y, width, height, id, handler, Color.RED);

    }

    public BasicEnemy(final int x, final int y, final int width, final int height, final ID id, final Handler handler, Color color) {
        super(x, y, width, height, id, handler, color);

    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
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

        getHandler().addObject(new Trail(getX(), getY(), getWidth(), getHeight(), ID.Trail, getHandler(), getColor()));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
