package com.snakeGame.main.GameStuff;

import com.snakeGame.main.General.ID;
import com.snakeGame.main.InGameObjects.Head;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter
{
    private final int sellCardNumWidth = 16;
    private final int sellCardNumHeight = 16;

    private boolean sellCard1Enabled = true;
    private boolean sellCard2Enabled = true;
    private boolean sellCard3Enabled = true;

    private boolean sellCard4Enabled = true;

    private boolean sellCard5Enabled = true;

    private Game game;

    private HUD hud;

    private Powerups powerups;

    private int choice1cost = 3;
    private int choice2cost = 5;
    private int choice3cost = 4;

    private int choice4cost = 2;

    private int choice5cost = 5;


    public Shop(Game game, HUD hud,Powerups powerups)
    {
        this.game = game;
        this.hud = hud;
        this.powerups = powerups;
    }


    @Override
    public void mousePressed(MouseEvent e)
    {
        int mousePosX = e.getX();
        int mousePosY = e.getY();

        if(mouseIsOver(mousePosX,mousePosY,150,200,sellCardNumWidth,sellCardNumHeight))// first option
        {
            if(hud.emeraldNumber >= choice1cost)
            {
                powerups.maxHeartUp();
                powerups.maxHeartUp();
                hud.emeraldNumber -= choice1cost;
                sellCard1Enabled = false;
            }
        }else  if(mouseIsOver(mousePosX,mousePosY,290,200,sellCardNumWidth,sellCardNumHeight))// second option
        {
            if(hud.emeraldNumber >= choice2cost)
            {
                powerups.playerSpeedUp();
                hud.emeraldNumber-=choice2cost;
                sellCard2Enabled = false;
            }
        }else  if(mouseIsOver(mousePosX,mousePosY,430,200,sellCardNumWidth,sellCardNumHeight))// third
        {
            if(hud.emeraldNumber >= choice3cost)
            {
                powerups.emeraldPercentageUp();
                hud.emeraldNumber-=choice3cost;
                sellCard3Enabled = false;
            }
        }else if(mouseIsOver(mousePosX,mousePosY,150,325,sellCardNumWidth,sellCardNumHeight)) // forth option
        {
            if(hud.emeraldNumber >= choice4cost)
            {
                powerups.maxHeartUp();
                hud.emeraldNumber-= choice4cost;
                sellCard4Enabled = false;
            }
        }else if(mouseIsOver(mousePosX,mousePosY,290,325,sellCardNumWidth,sellCardNumHeight)) // fifth option
        {
            if(hud.emeraldNumber >= choice5cost)
            {
                powerups.regenUp();
                hud.emeraldNumber-= choice5cost;
                sellCard5Enabled = false;
            }
        }else if(mouseIsOver(mousePosX,mousePosY,400,375,128,64))
        {
            sellCard1Enabled = true;
            sellCard2Enabled = true;
            sellCard3Enabled = true;
            sellCard4Enabled = true;
            sellCard5Enabled = true;
            game.setGameState(Game.State.INGAME);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("ariel",1,50));
        g.drawString("SHOP", 180, 50);


        Font font1 = new Font("ariel",1,10);
        //1st choice



        if(sellCard1Enabled == true)
        {
            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Price: " + choice1cost + " emeralds",125,150);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Max Hearts +2",125,175);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawRect(150, 200, sellCardNumWidth, sellCardNumHeight);
            g.drawString("1", 155, 212);
        }

        //2nd choice
        if(sellCard2Enabled == true)
        {
            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Price: " + choice2cost + " emeralds",265,150);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Player Speed +1",265,175);


            g.setColor(Color.white);
            g.setFont(font1);
            g.drawRect(290, 200, sellCardNumWidth, sellCardNumHeight);
            g.drawString("2", 295, 212);
        }

        //3rd choice
        if(sellCard3Enabled == true)
        {
            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Price: " + choice3cost + " emeralds",405,150);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Emerald Spawn Chance +10%",405,175);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawRect(430, 200, sellCardNumWidth, sellCardNumHeight);
            g.drawString("3", 435, 212);
        }

        //choice 4
        if(sellCard4Enabled == true)
        {
            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Price: " + choice4cost + " emeralds",125,275);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Max Hearts +1",125,300);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawRect(150, 325, sellCardNumWidth, sellCardNumHeight);
            g.drawString("4", 155, 337);
        }

        //choice 5
        if(sellCard5Enabled == true)
        {
            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Price: " + choice5cost + " emeralds",265,275);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawString("Regen +1",265,300);

            g.setColor(Color.white);
            g.setFont(font1);
            g.drawRect(290, 325, sellCardNumWidth, sellCardNumHeight);
            g.drawString("5", 295, 337);
        }


        //FINIHBUTTON
        g.setFont(new Font("ariel",1,20));
        g.setColor(Color.white);
        g.drawRect(400,375, 128,64);
        g.drawString("FINISH",425,415);
    }

    private boolean mouseIsOver(int mx,int my,int x, int y, int width, int height)
    {
        if(mx > x && mx < x+width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        }else return false;
    }

}
