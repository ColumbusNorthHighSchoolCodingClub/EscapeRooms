package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * An Item is a clickable object that can be drawn and perhaps contain things. 
 * It can change when clicked and could be part of the puzzle of the room.  
 * 
 * It is expected that MANY classes will extend this class.  
 * 
 * @author spockm
 */
public class Item 
{
    private String name; 
    private Rectangle rect;
    private boolean pickUpOnClick;
    
    public Item(String what, Rectangle r)
    {
        name = what;
        rect = new Rectangle(r);
        pickUpOnClick = false;
    }
    
    public String getName() { return name; }    
    public boolean pickUpOnClick() { return pickUpOnClick; }
    public Rectangle getRect() { return rect; }
    
    public void reactToClick(Point p, Player player)
    {
        System.out.println("A click occured, but the Item has not overriden the reactToClick method");
    }
    
    public Rectangle getHitBox()
    {
        return rect;
    }
    
    public void draw(Graphics g)
    {
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}
