package items;

import animation.ArcadeDemo;
import gameObjects.Item;
import gameObjects.Player;
import gameObjects.Room;
import gameObjects.WallRoom;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class Clue extends Item
{
    String text;
    Point location;
    public Clue(Point loc,String str)
    {
        super("Clue", new Rectangle(loc.x, loc.y, 28, 32),clueImage);
        text=str;
        location = loc;
    }
        
    public void draw(Graphics g, ImageObserver io)
    {
        g.drawImage(getImage(), getRect().x, getRect().y, io);
    }
    public void reactToClick(Point p, Player player)
    {
        ArcadeDemo.textBox.openBox(text, true);
    }
    
}
