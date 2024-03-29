package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler
{
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();


    public void tick()
    {
        for(int i = 0; i < objects.size();i++)
        {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }

    }

    public void render(Graphics g)
    {
            for (int i = 0; i < objects.size(); i++) {
                GameObject tempObject = objects.get(i);
                tempObject.render(g);
            }
    }

    public void addObject(GameObject object)
    {
        this.objects.add(object);
    }

    public void removeGameObject(GameObject object)
    {
        this.objects.remove(object);
    }
}
