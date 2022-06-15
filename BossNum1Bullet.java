package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.GameStuff.Game;
import com.snakeGame.main.GameStuff.Handler;
import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;

import java.awt.*;

public class BossNum1Bullet extends GameObject
{
    BossNum1 bossNum1;



    public BossNum1Bullet(float x, float y, ID id,BossNum1 bossNum1)
    {
        super(x,y,id);
        this.bossNum1 = bossNum1;

        width =16;
        height=16;

        velX = 4;
    }

    public void tick()
    {
        x += velX;

        if(x >= Game.WIDTH)
        {
            bossNum1.destroyBullet(this);
        }

        makeTrail(bossNum1.getHandler());

    }

    public void makeTrail(Handler handler)
    {
        handler.objects.add(new Trail(x,y,ID.Trail,Color.red,handler,width,height,0.1f));
    }

    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, (int)height, (int)width);
    }

    public Rectangle getBounds()
    {
        return new Rectangle((int)x, (int)y, (int)height, (int)width);
    }



}
