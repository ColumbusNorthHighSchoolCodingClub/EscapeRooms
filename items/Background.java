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
 * @author Eamon
 */
public class Background extends Item
{
    boolean isOpen = false;
    
    public Background()
    {
        super("Background", new Rectangle(0,0,800,800));
    }
    
    public boolean isOpen() { return isOpen; }
    
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
        {
            g.setColor(Color.WHITE);
            super.draw(g,io);
        }
    }
}
