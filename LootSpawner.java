package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.InGameObjects.Coin;
import com.snakeGame.main.General.ID;
import com.snakeGame.main.InGameObjects.Emerald;

import java.util.Random;

public class LootSpawner
{
    Random r = new Random();

    Handler handler;

    private HUD hud;

    LootSpawner(Handler handler,HUD hud)
    {
        this.hud = hud;
        this.handler = handler;
    }

    public void spawnCoin()
    {
        Coin newCoin = new Coin(r.nextFloat(Game.WIDTH - 92),r.nextFloat(Game.HEIGHT -92), ID.Coin);
        handler.objects.add(newCoin);
    }

    public void spawnCoin(float x, float y)
    {
        Coin newCoin = new Coin(x,y,ID.Coin);
        handler.objects.add(newCoin);
    }

    public void spawnEmerald()
    {
        handler.objects.add(new Emerald(r.nextFloat(Game.WIDTH - 92),r.nextFloat(Game.HEIGHT -92), ID.Emerald));
    }

    public void spawnEmerald(float x, float y)
    {
        handler.objects.add(new Emerald(x,y,ID.Emerald));
    }

    public void spawnEmeraldWithChance(Random r)
    {
        int num = r.nextInt(100);

        if(num <= hud.emeraldSpawnPercentage) spawnEmerald();
    }

    public void removeEmerald(int index)
    {
        handler.objects.remove(index);
    }

    public void removeEmeralds()
    {
        for(int i = handler.objects.size(); i >= 0 ;i--)
        {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ID.Emerald)
            {
                removeEmerald(i);
            }
        }
    }

    public void removeCoin(int index)
    {
        handler.objects.remove(index);
    }

    public void incrementEmeraldPercentageBy10()
    {
        this.hud.emeraldSpawnPercentage+=10;
    }

}
