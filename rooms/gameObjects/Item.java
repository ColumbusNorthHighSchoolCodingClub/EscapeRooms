package gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

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
    public void enablePickUpOnClick() { pickUpOnClick = true; }
    public Rectangle getRect() { return rect; }
    
    public void reactToClick(Point p, Player player)
    {
        System.out.println("A click occured, but the Item has not overriden the reactToClick method");
    }
    
    public Rectangle getHitBox()
    {
        return rect;
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
    
    //Make these static so that the Image only gets loaded once (not for each instance)
    public static Image keyImage;
    public static void loadImages(Toolkit toolkit)
    {
        keyImage = toolkit.getImage("src/items/images/key.gif");
    }

}
