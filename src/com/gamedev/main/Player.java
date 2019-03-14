package com.gamedev.main;

import java.awt.*;

public class Player extends GameObject {

    public static int MAX_WIDTH = 32;
    public static int MAX_HEIGHT = 32;

    public Player(final int x, final int y, final ID id, final Handler handler) {
        super(x, y, MAX_WIDTH, MAX_HEIGHT, id, handler, Color.WHITE);

    }

    public Player(final int x, final int y, final ID id, final Handler handler, Color color) {
        super(x, y, MAX_WIDTH, MAX_HEIGHT, id, handler, color);

    }

    public Player(final int x, final int y, final int width, final int height, final ID id, final Handler handler) {
        super(x, y, width, height, id, handler, Color.WHITE);

    }

    public Player(final int x, final int y, final int width, final int height, final ID id, final Handler handler, Color color) {
        super(x, y, width, height, id, handler, color);

    }

    public void tick() {
        setX(getX() + getVelocityX());
        setY(getY() + getVelocityY());

        setX(Game.clamp(getX(), 0, Game.WIDTH));
        setY(Game.clamp(getY(), 0, Game.HEIGHT - 2*getHeight()));

        getHandler().addObject(new Trail(getX(), getY(), getWidth(), getHeight(), ID.Trail, getHandler(), Color.WHITE));

        collision();
    }

    private void collision() {
        for (GameObject o: getHandler().getObjectList()) {
            if (o instanceof BasicEnemy) {
                if(getBounds().intersects(o.getBounds())) {
                    getHandler().getGame().getHud().decrementHealth(2);
                }
            }
        }
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public void render(Graphics g) {

        g.setColor(getColor());
        g.fillRect(Game.clamp(getX(), 0, Game.WIDTH - getWidth()), Game.clamp(getY(), 0, Game.HEIGHT - getHeight()), 32, 32);
    }
}
