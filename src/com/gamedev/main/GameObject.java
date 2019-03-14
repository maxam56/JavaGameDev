package com.gamedev.main;

import java.awt.*;

public abstract class GameObject implements Updatable {
    private int x;
    private int y;

    private int velocityX;
    private int velocityY;

    private int width = 0;
    private int height = 0;

    private ID id;

    private final Color color;

    private Handler handler;

    public GameObject(int x, int y, int width, int height, final ID id, final Handler handler, final Color color) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.width = width;
        this.height = height;

        this.velocityX = 0;
        this.velocityY = 0;

        this.color = color;

        this.handler = handler;
    }

    public abstract Rectangle getBounds();

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setID(final ID id) {
        this.id = id;
    }

    public ID getID() {
        return this.id;
    }

    public int getVelocityX() {
        return this.velocityX;
    }

    public int getVelocityY() {
        return this.velocityY;
    }

    public void setVelocityX(int v) {
        this.velocityX = v;
    }

    public void setVelocityY(int v) {
        this.velocityY = v;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public Color getColor() {
        return color;
    }
}
