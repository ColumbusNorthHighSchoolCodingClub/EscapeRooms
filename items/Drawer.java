/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author 22willsr
 */
public class Drawer extends Item {
    boolean isOpen = false;
    public Drawer()
    {
        super("Drawer", new Rectangle(200,200,120,75));
    }
    public boolean isOpen()
    {
        return isOpen;
    }
    public void reactToClick(Point p, Player player)
    {
        isOpen = !isOpen;
        System.out.println("Drawer Clicked!");
    }
    public void draw(Graphics g, ImageObserver io)
    {
        if(isOpen)
        { g.setColor(Color.GREEN);
        g.fillRect(200, 200, 175, 130);
        g.setColor(Color.BLACK);
        g.fillRect(225, 225, 125, 80);
        
        }
        
        else
        { g.setColor(Color.GREEN);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);}
    }
}

