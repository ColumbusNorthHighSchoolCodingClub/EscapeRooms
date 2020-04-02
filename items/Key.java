package items;

import gameObjects.Item;
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
public class Key extends Item
{
    
    public Key(Point loc)
    {
        super("Key", new Rectangle(loc.x, loc.y, 30, 30));
        enablePickUpOnClick();
    }
        
    public void draw(Graphics g, ImageObserver io)
    {
//        g.setColor(Color.YELLOW);
//        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.drawImage(keyImage, getRect().x, getRect().y, io);
    }
}
