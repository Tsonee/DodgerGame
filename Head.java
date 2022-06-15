package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.GameStuff.*;
import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;

import java.awt.*;
import java.util.Random;

public class Head extends GameObject {

    private Handler handler;
    private HUD hud;

    private LevelManager levelManager;

    private Random r;


    public static float speed = 3;


    public Head(float x, float y, ID id, Handler handler, HUD hud, LevelManager levelManager) {
        super(x, y, id);
        r = new Random();
        this.handler = handler;
        this.hud = hud;
        this.levelManager = levelManager;
        width = 16;
        height = 16;


    }

    @Override
    public void tick()
    {

        x+=velX;
        y+=velY;

        if(x > Game.WIDTH)
        {
            setX(0f);
        }
        else if(x < -16)
        {
            setX(Game.WIDTH-16);
        }

        if(y < -16)
        {
            setY(Game.HEIGHT-20);
        }
        else if(y > Game.HEIGHT-20)
        {
            setY(0f);
        }

        if(hud.getHeartNumber() <= 0)
        {
            for(int i = 0; i < handler.objects.size();i++)
            {
                handler.objects.clear();
            }
        }

        collision();


        handler.objects.add(new Trail(x,y,ID.Trail,Color.white,handler,16,16,0.09f));

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public Rectangle getBounds() {
        return  new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    private void collision()
    {
        for(int i = 0; i < handler.objects.size(); i++)
        {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ID.Coin)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {


                    levelManager.lootSpawner.removeCoin(i);
                    hud.scoreIncrement();
                    levelManager.incrementScoreStep();
                    if(hud.getLevel() == 6)
                    {
                        levelManager.lootSpawner.spawnCoin(r.nextFloat(Game.WIDTH-92)+64,r.nextFloat(Game.HEIGHT-92)+64);
                    }
                    else levelManager.lootSpawner.spawnCoin();
                }
            }

            if(tempObject.getId() == ID.BasicEnemy)
            {
                if (getBounds().intersects(tempObject.getBounds())) {
                    hud.decrementHearts();

                    levelManager.enemyManager.removeBasicEnemy(i);
                    levelManager.enemyManager.spawnBasicEnemy(r);
                }
            }

            if(tempObject.getId() == ID.FastEnemy)
            {
                if (getBounds().intersects(tempObject.getBounds()))
                {
                    hud.decrementHearts();

                    levelManager.enemyManager.removeFastEnemy(i);
                    levelManager.enemyManager.spawnFastEnemy(r);
                }
            }

            if(tempObject.getId() == ID.BossEnemy)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    while(hud.getHeartNumber() > 0)
                    {
                        hud.decrementHearts();
                    }
                }
            }

            if(tempObject.getId() == ID.BossNum1Bullet)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    handler.objects.remove(i);
                    hud.decrementHearts();
                }
            }

            if(tempObject.getId() == ID.Emerald)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    levelManager.lootSpawner.removeEmerald(i);
                    hud.incrementEmeraldNumber();
                }
            }
        }
    }
}
