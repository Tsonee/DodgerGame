package com.snakeGame.main.GameStuff;

import com.snakeGame.main.InGameObjects.Head;

public class Powerups
{
    private LootSpawner lootSpawner;
    private HUD hud;

    public Powerups(LootSpawner lootSpawner,HUD hud)
    {
        this.lootSpawner = lootSpawner;
        this.hud = hud;
    }

    public void emeraldPercentageUp()
    {
        lootSpawner.incrementEmeraldPercentageBy10();
    }

    public void playerSpeedUp()
    {
        Head.speed++;
    }

    public void maxHeartUp()
    {
        hud.maxHeartsUp();
    }

    public void regenUp()
    {
        hud.regenNum++;
    }

}
