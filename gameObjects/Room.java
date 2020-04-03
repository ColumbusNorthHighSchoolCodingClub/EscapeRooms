package gameObjects;

import animation.ArcadeDemo;
import static gameObjects.Item.backgroundImage;
import items.RightArrow;
import items.LeftArrow;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Room is a puzzle in this game.  Each room has an inventory of Items, 
 * and can give hints.  
 * 
 * It is planned that many classes will extend this class.  
 * 
 * @author spockm
 */
public class Room 
{
    private int pointValue;
    private ArrayList<Item> items;
    
    public Room()
    {
        items = new ArrayList<Item>();
        pointValue = 100;
        
    }

    public void addItem(Item i) { items.add(i); }
    public ArrayList<Item> getItems() { return items; }

    public void onClick(Point p, Player player)
    {
        for(int index=0; index<getItems().size(); index++)
        {
            Item i = getItems().get(index);
        
            if(i.getHitBox().contains(p))
            {
                i.reactToClick(p,player);
                if(i.pickUpOnClick()&&player.getNumItems()<5)
                {
                    ArcadeDemo.textBox.openBox("You picked up a " + i.getName() +".", true);
                    player.addItem(i);   //TODO test this!!
                    items.remove(index);
                }
            }
        }
    }
    
    public boolean isDone()
    {
        return false;
    }
    
    public String getHint()
    {
        return "Click on the door";
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        
        g.drawImage(backgroundImage, 0, 0, io);
        for(Item i :getItems())
            i.draw(g,io);
    }
       
    public Item getItemByName(String s)
    {
        for (Item i : getItems())
        {
            if(i.getName().equals(s))
                return i;
        }
        return null;
    }
        
}
