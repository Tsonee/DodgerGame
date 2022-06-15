package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.InGameObjects.Head;

import javax.management.ObjectName;
import java.awt.*;

public class HUD
{
    protected int score = 0;

    private int heartNumber = 3;

    private int distance = 16;

    protected int level = 0;

    private int maxHearts = 4;

    protected int emeraldNumber = 0;

    protected int emeraldSpawnPercentage = 50;

    protected int regenNum = 1;

    public void tick()
    {
        heartNumber = Game.clamp(heartNumber,0,maxHearts);
    }

    public void render(Graphics g)
    {

            g.setColor(Color.white);
            g.drawString("Hearts: ", 0, 12);

            drawHearts(g);

            g.setColor(Color.white);
            g.drawString("Score: " + score, 540, 16);

            g.setColor(Color.white);
            g.drawString("Level: " + level, 540, 32);

            g.setColor(Color.white);
            g.drawString("Emeralds: " + emeraldNumber,0,28);



            //stats
            g.setColor(Color.white);
            g.drawString("Stats:",0,380);
            g.setColor(Color.white);
            g.drawString("Max Hearts: " + maxHearts, 0, 395);

            g.setColor(Color.white);
            g.drawString("Regen: " + regenNum, 0, 410);

            g.setColor(Color.white);
            g.drawString("Player speed:" + (int)Head.speed,0,425);

            g.setColor(Color.white);
            g.drawString("Emerald spawn %: " + emeraldSpawnPercentage,0,440);

    }

    public void scoreIncrement()
    {
        this.score++;
    }

    public void drawHearts(Graphics g)
    {
        g.setColor(new Color(255, 91, 91));
        for(int i = 1; i <= heartNumber; i++)
        {
            g.fillRect(32+i*distance,4,10,10);
        }
    }

    public void incrementHearts()
    {
        heartNumber++;
    }

    public void decrementHearts()
    {
        heartNumber--;
    }

    public void setHeartNumber(int heartNumber)
    {
        this.heartNumber = heartNumber;
    }

    public int getHeartNumber()
    {
        return this.heartNumber;
    }

    public void levelUp()
    {
        this.level++;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void maxHeartsUp()
    {
        this.maxHearts++;
    }

    public void heartNumberUp()
    {
        this.heartNumber+=regenNum;
    }

    public void heartNumberDown()
    {
        this.heartNumber--;
    }

    public void setMaxHearts(int maxHearts)
    {
        this.maxHearts = maxHearts;
    }

    public int getMaxHearts()
    {
        return this.maxHearts;
    }

    public void incrementEmeraldNumber()
    {
        this.emeraldNumber++;
    }

    public void decrementEmeraldNumber()
    {
        this.emeraldNumber--;
    }

}
