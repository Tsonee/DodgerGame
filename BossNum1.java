package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.GameStuff.Game;
import com.snakeGame.main.GameStuff.Handler;
import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;

import java.awt.*;

public class BossNum1 extends GameObject
{
    Handler handler;

    public BossNum1(float x, float y, ID id,Handler handler)
    {
        super(x,y,id);

        this.handler = handler;

        width = 64;
        height = 64;

        velX = 2;
        velY = 2;

    }
    @Override
    public void tick()
    {
        if(x < 8)
        {
            x+=velX;
        }else
        {
            y = Game.clamp(y+=velY,0,Game.HEIGHT-92);
            if(y == Game.HEIGHT-92) velY*=-1;
            else if(y == 0) velY*=-1;
        }

        if(y%17==0)
        {
            shootBullet();
        }
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }
    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }

    public void shootBullet()
    {
        handler.objects.add(new BossNum1Bullet(x,y,ID.BossNum1Bullet,this));
    }

    public void destroyBullet(GameObject bullet)
    {
        handler.objects.remove(bullet);
    }

    public Handler getHandler()
    {
        return this.handler;
    }
}
