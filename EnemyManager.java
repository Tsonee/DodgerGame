package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;
import com.snakeGame.main.InGameObjects.BasicEnemy;
import com.snakeGame.main.InGameObjects.BossNum1;
import com.snakeGame.main.InGameObjects.BossNum2;
import com.snakeGame.main.InGameObjects.FastEnemy;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

public class EnemyManager
{
    private Handler handler;

    private LevelManager levelManager;

    private Random r;

    public EnemyManager(Handler handler, LevelManager levelManager)
    {
        this.handler = handler;
        this.levelManager = levelManager;

        r = new Random();

    }

    public void spawnBasicEnemy(float x, float y)
    {
        this.handler.objects.add(new BasicEnemy(x,y,ID.BasicEnemy,handler));
        levelManager.incrementAmountOfBasicEnemies();;
    }

    public void spawnBasicEnemy(Random r)
    {

        this.handler.objects.add(new BasicEnemy(r.nextFloat(Game.WIDTH - 48),r.nextFloat(Game.HEIGHT - 48),ID.BasicEnemy,handler));
        levelManager.incrementAmountOfBasicEnemies();
    }

    public void spawnFastEnemy(Random r)
    {

        this.handler.objects.add(new FastEnemy(r.nextFloat(Game.WIDTH - 48),0,ID.FastEnemy,handler));
        levelManager.incrementAmountOfFastEnemies();
    }

    public void spawnFastEnemy(float x, float y)
    {

        this.handler.objects.add(new FastEnemy(x,y,ID.FastEnemy,handler));
        levelManager.incrementAmountOfFastEnemies();;
    }

    public void spawnBossEnemyNum1(float x, float y)
    {
        handler.objects.add(new BossNum1(x,y,ID.BossEnemy,handler));
        levelManager.incrementAmountOfBossEnemies();
    }

    public void spawnBossEnemyNum2(float x, float y)
    {
        handler.objects.add(new BossNum2(x,y, ID.BossEnemy,this,handler));
        levelManager.incrementAmountOfBossEnemies();
    }


    public void removeBossEnemies(Handler handler)
    {
        for(int i = handler.objects.size()-1; i >= 0; i--)
        {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ID.BossEnemy)
            {
                handler.objects.remove(i);
                levelManager.decrementAmountOfBossEnemies();
            }

            if(tempObject.getId() == ID.BossNum1Bullet)
            {
                handler.objects.remove(i);
            }
        }

    }


    public void removeBasicEnemy(BasicEnemy basicEnemy)
    {
        this.handler.objects.remove(basicEnemy);
        levelManager.decrementAmountOfBasicEnemies();
    }

    public void removeBasicEnemy(int index)
    {
        this.handler.objects.remove(index);
        levelManager.decrementAmountOfBasicEnemies();
    }


    public void removeFastEnemy(FastEnemy fastEnemy)
    {
        this.handler.objects.remove(fastEnemy);
        levelManager.decrementAmountOfFastEnemies();
    }

    public void removeFastEnemy(int index)
    {
        this.handler.objects.remove(index);
        levelManager.decrementAmountOfFastEnemies();
    }

    public void removeAllBasicEnemies(Handler handler)
    {
        for(int i = handler.objects.size()-1; i >= 0; i--)
        {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ID.BasicEnemy)
            {
                removeBasicEnemy(i);
            }
        }

    }

    public void removeAllFastEnemies(Handler handler)
    {
        for(int i = handler.objects.size()-1; i >= 0; i--)
        {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ID.FastEnemy)
            {
                removeBasicEnemy(i);
            }
        }

    }
}
