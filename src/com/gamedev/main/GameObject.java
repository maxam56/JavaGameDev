package com.gamedev.main;

public abstract class GameObject implements Updatable {
    protected int x;
    protected int y;

    protected int velocityX;
    protected int velocityY;

    protected int width = 0;
    protected int height = 0;

    protected ID id;

    public GameObject(int x, int y, final ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

        this.velocityX = 0;
        this.velocityY = 0;
    }

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
}
