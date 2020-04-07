package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class WoodenDoor extends Item
{

    boolean isOpen = false;
    
    public void draw(Graphics g, ImageObserver io)
    {
        g.setColor(Color.RED);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height); 
    }
    
    public WoodenDoor()
    {
       super("WoodenDoor", new Rectangle(300,250,100,230)); 
    }
    
 public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
        if(player.hasItem("Candle"))
        {
            isOpen = true;
            System.out.println("You burnt down a wooden door!");
        }
    }
}
