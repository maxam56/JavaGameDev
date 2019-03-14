package com.gamedev.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    private LinkedList<GameObject> objects = new LinkedList<>();
    private Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public void tick() {
        LinkedList<GameObject> copy = (LinkedList<GameObject>)getObjectList().clone();
        for (GameObject o: copy) {
            o.tick();
        }
    }

    public void render(Graphics g) {
        for (GameObject o: objects) {
            o.render(g);
        }
    }

    public void addObject(GameObject o) {
        this.objects.add(o);
    }

    public LinkedList<GameObject> getObjectList() {
        return this.objects;
    }

    public Game getGame() {
        return this.game;
    }

    public void removeObject(GameObject o) {
        this.objects.remove(o);
    }
}
