package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;

import java.awt.*;
import java.util.Random;

public class Coin extends GameObject
{

    Random r = new Random();

    public Coin(float x, float y, ID id) {
        super(x, y, id);
        width = 8;
        height = 8;


    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect((int)x, (int)y, (int)width, (int)height);
    }

    public Rectangle getBounds() {
        return  new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
}

