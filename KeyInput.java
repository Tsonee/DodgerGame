package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.GameObject;
import com.snakeGame.main.General.ID;
import com.snakeGame.main.InGameObjects.Head;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private Game game;

    private Handler handler;

    private HUD hud;

    public KeyInput(Handler handler,Game game,HUD hud)
    {
        this.handler = handler;
        this.game = game;
        this.hud = hud;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();


        if(game.getGameState() == Game.State.INGAME)
        {
            if(key == KeyEvent.VK_ESCAPE)
            {
                    game.setGameState(Game.State.MENU);
            }

            for(int i = 0; i < handler.objects.size();i++)
            {
                GameObject tempObject = handler.objects.get(i);

                if (tempObject.getId() == ID.Head) {

                    if (key == KeyEvent.VK_W) {
                        tempObject.setVelX(0f);
                        tempObject.setVelY(-Head.speed);
                    }
                    if (key == KeyEvent.VK_S) {
                        tempObject.setVelX(0f);
                        tempObject.setVelY(Head.speed);
                    }
                    if (key == KeyEvent.VK_D) {
                        tempObject.setVelY(0f);
                        tempObject.setVelX(Head.speed);
                    }
                    if (key == KeyEvent.VK_A) {
                        tempObject.setVelY(0f);
                        tempObject.setVelX(-Head.speed);
                    }
                }
            }
        }
    }

    /*public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

    }*/

}
