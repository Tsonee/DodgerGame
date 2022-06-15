package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.GameStuff.EnemyManager;
import com.snakeGame.main.GameStuff.Game;
import com.snakeGame.main.GameStuff.Handler;
import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;

import java.awt.*;

public class BossNum2 extends GameObject
{

    private boolean launch1 = true;
    private boolean launch2 = true;

    private Handler handler;

    private EnemyManager enemyManager;


    public BossNum2(float x, float y, ID id, EnemyManager enemyManager,Handler handler)
    {
        super(x,y,id);

        this.handler = handler;

        this.enemyManager = enemyManager;

        width = 32;
        height = 32;

        velX = 0;
        velY = -5;

    }
    @Override
    public void tick()
    {
        y = Game.clamp(y+=velY,0,Game.HEIGHT-62);
        x = Game.clamp(x+=velX,0,Game.WIDTH-32);

        if(x == Game.WIDTH-32 || x == 0)
        {
            velX*=-1;
        }else if(y == Game.HEIGHT-62 || y == 0)
        {
            velY*=-1;
        }

        if(y == 0 && launch1 == true)
        {
            velY = 0;
            velX = 5;
            launch1 = false;
        }else if(x == Game.WIDTH-32 && y == 0 && launch2 == true)
        {

            enemyManager.spawnFastEnemy(0,0);
            enemyManager.spawnFastEnemy(Game.WIDTH-32,0);
            velX = 3;
            velY = 15;
            launch2 = false;
        }

        handler.objects.add(new Trail(x,y,ID.Trail,new Color(0,180,255),handler,width,height,0.09f));
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(new Color(0,180,255));
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

}
