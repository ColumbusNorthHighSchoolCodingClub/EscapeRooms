package items;

import animation.ArcadeDemo;
import gameObjects.Item;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class LockedDoor extends Item
{
    boolean isOpen = false;
    boolean locked = true;
    public LockedDoor()
    {
        super("LockedDoor", new Rectangle(310-70,440-275,140,275),null);
    }
    
    public boolean isOpen() { return isOpen; }
    
    public void reactToClick(Point p, Player player)
    {
        if(!locked) {
            isOpen=true;
        }
        if(player.hasItemActive("Key"))
        {
            if(locked)
                ArcadeDemo.textBox.openBox("Unlocked a LockedDoor!",true);
            locked=false;
        } else {
            ArcadeDemo.textBox.openBox("The door is locked!",true);
        }
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(!isOpen)
        {
            g.drawImage(doorClosedImage, getRect().x, getRect().y, io);
            //super.draw(g,io);
        } else {
            g.drawImage(doorOpenImage, getRect().x, getRect().y, io);
        }
    }
}
