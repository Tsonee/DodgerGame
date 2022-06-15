package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.ID;
import com.snakeGame.main.InGameObjects.*;

import java.awt.*;
import java.util.Random;

public class LevelManager
{

    private Handler handler;

    private HUD hud;

    private  int amountOfBasicEnemies = 0;

    private  int amountOfFastEnemies = 0;

    private int amountOfAllEnemies = 0;

    private int amountOfBossEnemies = 0;

    public LootSpawner lootSpawner;

    public EnemyManager enemyManager;

    private Random r;

    protected int scoreStep;

    protected boolean startTheFirstLevel = false;

    private Game game;

    public Powerups powerups;




    public LevelManager(Handler handler,HUD hud,Game game)
    {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        r = new Random();

        this.lootSpawner = new LootSpawner(handler,hud);
        this.enemyManager = new EnemyManager(handler,this);

        powerups = new Powerups(lootSpawner,hud);
    }

    public void tick()
    {
        if(game.getGameState() == Game.State.INGAME) {
            amountOfAllEnemies = amountOfBasicEnemies + amountOfFastEnemies + amountOfBossEnemies;

            if (hud.level == 0 && startTheFirstLevel == true) {
                if (handler.objects.isEmpty() != false) handler.objects.clear();

                handler.addObject(new Head(100f, 100f, ID.Head, handler, hud, this));
                lootSpawner.spawnCoin();
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.spawnBasicEnemy(r);
                startTheFirstLevel = false;
                hud.levelUp();
            }
            else if (hud.level == 1 && scoreStep >= 5) {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.spawnBasicEnemy(r);
                hud.levelUp();
                hud.heartNumberUp();
                scoreStepReset();
            } else if (hud.level == 2 && scoreStep >= 5) {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.spawnBasicEnemy(r);
                hud.levelUp();
                hud.heartNumberUp();
                scoreStepReset();
            } else if (hud.level == 3 && scoreStep >= 5) {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.removeAllBasicEnemies(handler);
                enemyManager.spawnFastEnemy(r);
                hud.levelUp();
                hud.heartNumberUp();
                scoreStepReset();
            } else if (hud.level == 4 && scoreStep >= 5) {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.spawnFastEnemy(r);
                enemyManager.spawnFastEnemy(r);
                hud.levelUp();
                hud.heartNumberUp();
                scoreStepReset();
            } else if (hud.level == 5 && scoreStep >= 5) {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.removeAllFastEnemies(handler);
                enemyManager.spawnBossEnemyNum1(-18, 180);
                hud.levelUp();
                hud.heartNumberUp();
                scoreStepReset();
            } else if (hud.level == 6 && scoreStep >= 5) {
                game.setGameState(Game.State.SHOP);
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.removeBossEnemies(handler);
                enemyManager.spawnBasicEnemy(r);
                enemyManager.spawnFastEnemy(r);
                hud.heartNumberUp();
                hud.levelUp();
                scoreStepReset();
            } else if (hud.level == 7 && scoreStep >= 5) {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.spawnFastEnemy(r);
                hud.heartNumberUp();
                hud.levelUp();;
                scoreStepReset();
            } else if(hud.level == 8 && scoreStep >= 5)
            {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.spawnBasicEnemy(r);
                hud.heartNumberUp();
                hud.levelUp();;
                scoreStepReset();
            }else if(hud.level == 9 && scoreStep >= 5)
            {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.removeAllBasicEnemies(handler);
                enemyManager.removeAllFastEnemies(handler);
                enemyManager.spawnBossEnemyNum2((Game.WIDTH-62)/2,Game.HEIGHT);
                hud.heartNumberUp();
                hud.levelUp();
                scoreStepReset();
            }else if(hud.level == 10 && scoreStep >= 5)
            {
                lootSpawner.spawnEmeraldWithChance(r);
                enemyManager.removeAllFastEnemies(handler);
                enemyManager.removeBossEnemies(handler);
                hud.heartNumberUp();
                hud.levelUp();
                scoreStepReset();
                game.setGameState(Game.State.SHOP);
            }else if(hud.level == 11 && scoreStep >= 5)
            {

            }
        }

    }
    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.drawString("Enemies: " + amountOfAllEnemies, 540, 48);
    }




    public int getAmountOfAllEnemies()
    {
        return this.amountOfAllEnemies;
    }

    public void incrementAmountOfBasicEnemies()
    {
        this.amountOfBasicEnemies++;
    }

    public void decrementAmountOfBasicEnemies()
    {
        this.amountOfBasicEnemies--;
    }

    public void incrementAmountOfFastEnemies()
    {
        this.amountOfFastEnemies++;
    }

    public void incrementAmountOfBossEnemies()
    {
        this.amountOfBossEnemies++;
    }

    public void decrementAmountOfBossEnemies()
    {
        this.amountOfBossEnemies--;
    }

    public void decrementAmountOfFastEnemies()
    {
        this.amountOfFastEnemies--;
    }


    public void incrementScoreStep()
    {
        this.scoreStep++;
    }

    private void scoreStepReset()
    {
        scoreStep = 0;
    }

    public void setAmountOfBasicEnemies(int amountOfBasicEnemies) {
        this.amountOfBasicEnemies = amountOfBasicEnemies;
    }

    public void setAmountOfBossEnemies(int amountOfBossEnemies) {
        this.amountOfBossEnemies = amountOfBossEnemies;
    }

    public void setAmountOfFastEnemies(int amountOfFastEnemies) {
        this.amountOfFastEnemies = amountOfFastEnemies;
    }



}
