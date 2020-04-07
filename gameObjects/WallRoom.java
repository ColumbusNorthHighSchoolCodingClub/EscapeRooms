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
public class WallRoom extends Room
{
    private int pointValue;
    private Room[] walls;
    public int activeWall;
    public int numWalls;
    
    public WallRoom(int numWalls)
    {
        activeWall=0;
        pointValue = 100;
        walls = new Room[numWalls];
        this.numWalls=numWalls;
        for(int i=0;i<walls.length;i++) {
            walls[i] = new Room();
            if(numWalls>1) {
                walls[i].addItem(new RightArrow(this));
                walls[i].addItem(new LeftArrow(this));
            }
        }
        
    }
    public Room getActiveWall() {return walls[activeWall];}
    public int getPointValue() { return pointValue; }
    public void addItem(Item i,int wallNum) { walls[wallNum].addItem(i); }
    public void addItem(Item i) {addItem(i,activeWall);}
    public ArrayList<Item> getItems(int wallNum) { return walls[wallNum].getItems(); }

    public void onClick(Point p, Player player)
    {
        for(int index=0; index<getActiveWall().getItems().size(); index++)
        {
            Item i = getActiveWall().getItems().get(index);
        
            if(i.getHitBox().contains(p))
            {
                i.reactToClick(p,player);
                if(i.pickUpOnClick()&&player.getNumItems()<5)
                {
                    ArcadeDemo.textBox.openBox("You picked up a " + i.getName() +".", true);
                    player.addItem(i);
                    getActiveWall().getItems().remove(i);
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
        for(Item i : walls[activeWall].getItems())
            i.draw(g,io);
    }
       
    public Item getItemByName(String s)
    {
        for(Room w:walls) {
            for (Item i : w.getItems())
            {
                if(i.getName().equals(s))
                    return i;
            }
        }
        return null;
    }
        
}
