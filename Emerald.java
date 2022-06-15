package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;

import java.awt.*;
import java.security.UnrecoverableKeyException;

public class Emerald extends GameObject
{

    public Emerald(float x, float y, ID id)
    {
        super(x, y, id);

        this.width = 8;
        this.height = 8;
    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(new Color(0,130,20));
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
}
