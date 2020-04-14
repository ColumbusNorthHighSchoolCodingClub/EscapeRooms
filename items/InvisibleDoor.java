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
 * @author 20songe
 */
public class InvisibleDoor extends Item{
    
    private boolean isOpen=false;
    
    public InvisibleDoor()
    {
        super("InvisibleDoor", new Rectangle(300,250,100,230));
    }
    
    public boolean isOpen() { return isOpen; }
    
     public void reactToClick(Point p, Player player)
    {
        isOpen = !isOpen;
        System.out.println("Invisible Door is Clicked!");
    }
     
     public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
            g.setColor(new Color(0,0,0,0));
            super.draw(g,io);
        }
            
    }
    


