package com.snakeGame.main.InGameObjects;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.GameStuff.Handler;
import com.snakeGame.main.General.ID;

import java.awt.*;

public class Trail extends GameObject
{

    private float alpha = 1;
    private Handler handler;

    private Color color;

    private float life;

    public Trail(float x, float y, ID id, Color color, Handler handler, float width, float height, float life)
    {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
    }

    @Override
    public void tick()
    {
        if(alpha > life)
        {
            alpha -= (life-0.001);
        }
        else
        {
            handler.removeGameObject(this);
        }
    }

    @Override
    public void render(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x, (int)y, (int)width, (int)height);

        g2D.setComposite(makeTransparent(1));

    }

    @Override
    public Rectangle getBounds()
    {
        return null;
    }

    private AlphaComposite makeTransparent(float alpha)
    {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type,alpha));
    }
}
