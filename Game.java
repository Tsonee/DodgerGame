package com.snakeGame.main.GameStuff;

import com.snakeGame.main.InGameObjects.Head;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable
{
    public enum State{MENU,INGAME,PLAYMENU,SHOP};

    private State gameState = State.MENU;

    public static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;

    public static final String gameTitle = "The Upgraded Snake Dodger";

    private Thread thread;
    private boolean isRunning = false;

    private Random r = new Random();

    private Handler handler;

    private HUD hud;

    private LevelManager levelManager;

    private Shop shop;

    private Menu menu;

    public static final float WIDTHBOUNDS = WIDTH - 48;
    public static final float HEIGHTBOUNDS = HEIGHT - 48;

    public Game()
    {
        handler = new Handler();

        hud = new HUD();

        levelManager = new LevelManager(handler,hud,this);

        menu = new Menu(this,handler,hud,levelManager);

        shop = new Shop(this,hud,levelManager.powerups);

        this.addKeyListener(new KeyInput(handler,this,hud));

        this.addMouseListener(menu);

        this.addMouseListener(shop);

        new Window((int)WIDTH,(int)HEIGHT,gameTitle,this);
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
            isRunning = false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning)
        {
            long now = System.nanoTime();
            delta += ((now - lastTime) / ns);
            lastTime = now;
            while(delta > 0)
            {
                tick();
                delta--;
            }
            if(isRunning)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer+=1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick()
    {
        if(gameState == State.INGAME)
        {
            handler.tick();
            hud.tick();
            levelManager.tick();
        }
    }
    
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);


        if(gameState == State.INGAME)
        {
                handler.render(g);

                hud.render(g);

                levelManager.render(g);

        }else if(gameState == State.MENU || gameState == State.PLAYMENU)
        {
            menu.render(g);
        }else if(gameState == State.SHOP)
        {
            hud.render(g);
            shop.render(g);
        }


        g.dispose();
        bs.show();

    }

    public static float clamp(float x, float min,float max)
    {
        if(x <= min) return min;
        else if(x >= max) return max;
        else return x;
    }

    public static int clamp(int x, int min,int max)
    {
        if(x <= min) return min;
        else if(x >= max) return max;
        else return x;
    }

    public static void main(String args[])
    {
        new Game();
    }

    public State getGameState()
    {
        return this.gameState;
    }

    public void setGameState(State state)
    {
        this.gameState = state;
    }

    public void startANewGame()
    {
        Head.speed = 3;
        hud.score = 0;
        hud.setHeartNumber(3);
        hud.level = 0;
        hud.setMaxHearts(4);
        hud.regenNum = 1;
        hud.emeraldNumber = 0;
        hud.emeraldSpawnPercentage = 50;
        levelManager.scoreStep = 0;
        levelManager.setAmountOfBasicEnemies(0);
        levelManager.setAmountOfFastEnemies(0);
        levelManager.setAmountOfBossEnemies(0);
        if(!handler.objects.isEmpty()) handler.objects.clear();
        gameState = State.INGAME;
        levelManager.startTheFirstLevel = true;
    }



}
