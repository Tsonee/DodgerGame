package com.snakeGame.main.General;

import java.awt.*;

public abstract class GameObject
{
    protected float x,y;
    protected ID id;
    public float velX;
    public float velY;

    protected float width,height;

    public GameObject(float x, float y, ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public void setX(float x)
    {
        this.x = x;
    }
    public float getX()
    {
        return this.x;
    }
    public void setY(float y)
    {
        this.y = y;
    }
    public float getY()
    {
        return this.y;
    }
    public void setId(ID id)
    {
        this.id = id;
    }
    public ID getId()
    {
        return this.id;
    }
    public void setVelX(float velX)
    {
        this.velX = velX;
    }
    public void setVelY(float velY)
    {
        this.velY = velY;
    }
    public float getVelX()
    {
        return this.velX;
    }
    public float getVelY()
    {
        return this.velY;
    }

    public void setWidth(float width)
    {
        this.width = width;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public float getWidth()
    {
        return this.width;
    }

    public float getHeight()
    {
        return this.height;
    }
}
