package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class flexibleDoor extends Item
{
    boolean isOpen = false;
    
    public flexibleDoor(int x,int y,int h,int w)
    {
        super("flexibleDoor", new Rectangle(x,y,h,w));
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
        if(player.hasItem("Key"))
        {
            isOpen = true;
            System.out.println("Unlocked a Door!");
        }
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
            super.draw(g,io);
    }
}
