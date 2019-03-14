package com.gamedev.main;

import java.awt.*;

public class SmartEnemy extends BasicEnemy {
    private Color color;
    public static int START_VEL = 2;

    public SmartEnemy(final int x, final int y, final ID id, final Handler handler) {
        super(x, y, MAX_WIDTH, MAX_HEIGHT, id, handler, Color.CYAN);

        setVelocityX(START_VEL);
        setVelocityY(START_VEL);
    }

    public SmartEnemy(final int x, final int y, final ID id, final Handler handler, Color color) {
        super(x, y, MAX_WIDTH, MAX_HEIGHT, id, handler, color);

        setVelocityX(5);
        setVelocityY(5);
    }

    public SmartEnemy(final int x, final int y, final int width, final int height, final ID id, final Handler handler) {
        super(x, y, width, height, id, handler, Color.CYAN);

    }

    public SmartEnemy(final int x, final int y, final int width, final int height, final ID id, final Handler handler, Color color) {
        super(x, y, width, height, id, handler, color);

    }

    @Override
    public void tick() {
        Player p = getHandler().getGame().getPlayer();
        int dx;
        int dy;
        int playerX = p.getX() + p.MAX_WIDTH/2;
        int playerY = p.getY() + p.MAX_HEIGHT/2;
        int x = getX() + MAX_WIDTH/2;
        int y = getY() + MAX_HEIGHT/2;
        dx = (playerX - x > 0) ? 1 : -1;
        dy = (playerY - y > 0) ? 1 : -1;

        if (playerX == getX()) {
            dx = 0;
        }
        if (playerY == getY()) {
            dy = 0;
        }

        setX(getX() + dx);
        setY(getY() + dy);

        getHandler().addObject(new Trail(getX(), getY(), getWidth(), getHeight(), ID.Trail, getHandler(), getColor()));
    }
}
