package com.gamedev.main;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha;

    public Trail(int x, int y, int width, int height, ID id, Handler handler, Color color) {
        super(x, y, width, height, id, handler, color);

        alpha = 1;
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public void tick() {
        alpha -= 0.1;
        if(alpha <= 0) {
            if (getHandler().getObjectList().contains(this)) {
                getHandler().removeObject(this);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.setComposite(makeTransparent(alpha));

        g2d.setColor(getColor());
        g2d.fillRect(getX(), getY(), getWidth(), getHeight());

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }
}
