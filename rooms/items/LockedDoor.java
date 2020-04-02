package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class LockedDoor extends Item
{
    boolean isOpen = false;
    
    public LockedDoor()
    {
        super("LockedDoor", new Rectangle(300,300,200,300));
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
        if(player.hasItem("Key"))
        {
            isOpen = true;
            System.out.println("Unlocked a LockedDoor!");
        }
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
            super.draw(g,io);
    }
}
