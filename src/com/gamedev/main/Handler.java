package com.gamedev.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (GameObject o: objects) {
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

    public void removeObject(GameObject o) {
        this.objects.remove(o);
    }
}
