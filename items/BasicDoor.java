package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

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
    
    public void draw(Graphics g)
    {
        if(!isOpen)
            super.draw(g);
    }
}
