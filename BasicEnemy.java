package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.GameStuff.Game;
import com.snakeGame.main.GameStuff.Handler;
import com.snakeGame.main.General.ID;

import java.awt.*;

public class BasicEnemy extends GameObject
{

    Handler handler;

    public BasicEnemy(float x, float y, ID id, Handler handler)
    {
        super(x,y,id);

        this.handler = handler;

        width = 16;
        height = 16;

        velX = 5;
        velY = 5;
    }

    @Override
    public void tick()
    {
        x = Game.clamp(getX() + velX,0,Game.WIDTH);
        y = Game.clamp(getY() + velY, 0 , Game.HEIGHT-48);

        if(x == Game.WIDTH || x == 0) velX*=(-1);
        if(y == Game.HEIGHT-48 || y == 0) velY*=(-1);

        handler.objects.add(new Trail(x,y,ID.Trail,Color.red,handler,width,height,0.05f));

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

}
