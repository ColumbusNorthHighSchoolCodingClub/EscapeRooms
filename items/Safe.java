package items;

import animation.ArcadeDemo;
import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class Safe extends Item
{
    boolean isOpen = false;
    boolean locked = true;
    Room room;
    Item item;
    Point loc;
    public Safe(Room rm,Point pt,Item i)
    {
        super("Safe", new Rectangle(pt.x,pt.y,72,72),null);
        room=rm;
        item=i;
        loc = pt;
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
        if(!locked) {
            if(!isOpen) {
                room.addItem(item);
            }
            isOpen=true;
        } else
            ArcadeDemo.textBox.openBox("The Safe is locked!",true);
        
    }
    public void unlock() {
        locked=false;
    }
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
        {
            g.drawImage(safeClosedImage, getRect().x, getRect().y, io);
            //super.draw(g,io);
        } else {
            g.drawImage(safeOpenImage, getRect().x, getRect().y, io);
        }
    }
}
