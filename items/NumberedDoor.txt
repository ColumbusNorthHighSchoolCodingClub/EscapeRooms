package items;

import gameObjects.Item;
import java.awt.Point;
import gameObjects.Item;
import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import items.SimpleButton;

/**
 *
 * @author 20maloneb
 */
public class NumberedDoor extends Item
{
    private String numberOnDoor;
    boolean isOpen = false;
            
    public NumberedDoor(String a, String text, Point loc)
    {
        super(a, new Rectangle(loc.x, loc.y, 100,200));
        numberOnDoor = text;
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
        isOpen = !isOpen;
        System.out.println("Numbered Door Clicked!");
    }
    
    public void draw(Graphics g)
    {
        if(!isOpen)
            g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
            g.setColor(Color.BLACK);
            g.drawString(numberOnDoor, getRect().x, getRect().y);
    }
}
