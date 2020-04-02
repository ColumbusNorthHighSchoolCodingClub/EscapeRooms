package gameObjects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

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
        pointValue = 100;
        items = new ArrayList<>();
    }
    
    public int getPointValue() { return pointValue; }
    public void addItem(Item i) { items.add(i); }
    public ArrayList<Item> getItems() { return items; }

    public void onClick(Point p, Player player)
    {
        for(int index=0; index<items.size(); index++)
        {
            Item i = items.get(index);
        
            if(i.getHitBox().contains(p))
            {
                i.reactToClick(p,player);
                if(i.pickUpOnClick())
                {
                    player.addItem(i);   //TODO test this!!
                    items.remove(index);
                }
            }
        }
    }
    
    public void onDrag(Point p, Player player) {
        for(int index=0; index<items.size(); index++)
        {
            Item i = items.get(index);
                i.reactToDrag(p,player);
        }
    }
    public void onMouseRelease(Point p, Player player) {
        for(int index=0; index<items.size(); index++)
        {
            Item i = items.get(index);
                i.reactToMouseRelease(p,player);
        }
    }
    
    public void onKey(char c, Player player)
    {
        for(int index=0; index<items.size(); index++)
        {
            Item i = items.get(index);
                i.reactToKey(c,player);
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
        for(Item i : items)
            i.draw(g,io);
    }
       
    public Item getItemByName(String s)
    {
        for (Item i : items)
        {
            if(i.getName().equals(s))
                return i;
        }
        return null;
    }
}
