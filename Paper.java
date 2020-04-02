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
 * @author spockm
 */
public class Paper extends Item
{
   
    
    public Paper()
    {
        super("Paper", new Rectangle(20,50,20,30));
    }
    
    
    public void reactToClick(Point p, Player player)
    {
       
        System.out.println("The paper says: " + "seven one one.");
        
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
            g.setColor(Color.WHITE);
            super.draw(g,io);
                  
    }
}
