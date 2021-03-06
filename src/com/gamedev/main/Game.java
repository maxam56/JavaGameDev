package com.gamedev.main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final String WINDOW_NAME = "My Game";
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private HUD hud;
    private Spawner spawner;

    private final Player player;

    public Game() {
        this.handler = new Handler(this);
        new Window(this, WIDTH, HEIGHT, WINDOW_NAME);
        this.hud = new HUD();
        this.spawner = new Spawner(handler);
        this.addKeyListener(new KeyInputs(handler));

        this.player = new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, handler);
        handler.addObject(player);

        handler.addObject(new BasicEnemy(WIDTH/2-16, HEIGHT/2 - 16, ID.BasicEnemy, handler));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {

        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1e9 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running) {
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        spawner.spawn();
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var < min) {
            return min;
        }
        if (var > max) {
            return max;
        }
        return var;
    }

    public HUD getHud() {
        return this.hud;
    }

    public Player getPlayer() {
        return player;
    }

    public static void main(String args[]) {
        Game game = new Game();
    }
}
