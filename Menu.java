package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.ID;
import com.snakeGame.main.InGameObjects.Coin;
import com.snakeGame.main.InGameObjects.Head;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter
{
    //button width and height
    private final int buttonWidth = 128;

    private final int buttonHeight = 64;

    private Game game;

    private Handler handler;

    private HUD hud;

    private LevelManager levelManager;

    private Random r;


    public Menu(Game game,Handler handler,HUD hud,LevelManager levelManager)
    {
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        this.levelManager = levelManager;

        r = new Random();
    }


    @Override
    public void mousePressed(MouseEvent e)
    {
        int mousePosX = e.getX();
        int mousePosY = e.getY();

        if(game.getGameState() == Game.State.MENU)
        {
            if (mouseIsOver(mousePosX, mousePosY, 230, 100, buttonWidth, buttonHeight)){ // PLAY BUTTON
                if(handler.objects.isEmpty()) game.startANewGame();
                else game.setGameState(Game.State.PLAYMENU);
            } else if (mouseIsOver(mousePosX, mousePosY, 230, 300, buttonWidth, buttonHeight)) { // EXIT BUTTON
                System.exit(1);
            }
        }else if(game.getGameState() == Game.State.PLAYMENU)
        {
            if(mouseIsOver(mousePosX, mousePosY, 140, 160, buttonWidth, buttonHeight)) //NEW RUN BUTTON
            {
                game.startANewGame();
            }else if(mouseIsOver(mousePosX, mousePosY, 288, 160, buttonWidth, buttonHeight)) //CONTINUE BUTTON
             {
                 game.setGameState(Game.State.INGAME);
             }else if(mouseIsOver(mousePosX, mousePosY, 25, 375, buttonWidth, buttonHeight)) // BACK BUTTON
            {
                game.setGameState(Game.State.MENU);
            }
        }



    }

    private boolean mouseIsOver(int mx,int my,int x, int y, int width, int height)
    {
        if(mx > x && mx < x+width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        }else return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    public void render(Graphics g)
    {
        Font font1 = new Font("ariel", 1, 30);
        Font font2 = new Font("ariel", 1, 50);
        Font font3 = new Font("ariel",1,20);

        if (game.getGameState() == Game.State.MENU) {

            g.setColor(Color.white);
            g.setFont(font2);
            g.drawString("MENU", 215, 50);

            //PLAY BUTTON
            g.setFont(font1);
            g.setColor(Color.white);
            g.drawRect(230, 100, buttonWidth, buttonHeight);
            g.drawString("PLAY", 250, 140);

            //EXIT BUTTON
            g.setFont(font1);
            g.setColor(Color.white);
            g.drawRect(230, 300, buttonWidth, buttonHeight);
            g.drawString("EXIT", 255, 340);
        } else if (game.getGameState() == Game.State.PLAYMENU)
        {
            g.setFont(font2);
            g.setColor(Color.white);
            g.drawString("PLAY MENU",135,50);

            //CONTINUE BUTTON
            g.setFont(font3);
            g.setColor(Color.white);
            g.drawRect(140,160, buttonWidth,buttonHeight);
            g.drawString("NEW RUN",150,200);

            //NEW RUN BUTTON
            g.setFont(font3);
            g.setColor(Color.white);
            g.drawRect(288,160, buttonWidth,buttonHeight);
            g.drawString("CONTINUE",295,200);

            //BACKBUTTON
            g.setFont(font3);
            g.setColor(Color.white);
            g.drawRect(25,375, buttonWidth,buttonHeight);
            g.drawString("BACK",50,415);

        }


    }
}
