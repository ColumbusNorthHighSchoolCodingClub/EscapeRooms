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
public class BasicDoor extends Item
{
    boolean isOpen = false;
    
    public BasicDoor()
    {
        super("BasicDoor", new Rectangle(300,300,200,300));
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
        isOpen = !isOpen;
        System.out.println("Basic Door Clicked!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
        {
            g.setColor(Color.CYAN);
            super.draw(g,io);
        }
    }
}
