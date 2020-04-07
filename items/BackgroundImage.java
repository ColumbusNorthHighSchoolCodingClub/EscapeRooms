package items;

import gameObjects.Item;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point; 
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class BackgroundImage extends Item
{
    Image backgroundImage;
    
    public BackgroundImage(Image i)
    {
        super("Background", new Rectangle(0,0,640,480));
        backgroundImage = i;
    }
        
    public void draw(Graphics g, ImageObserver io)
    {
//        g.setColor(Color.YELLOW);
//        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.drawImage(backgroundImage, getRect().x, getRect().y, io);
    }
    
}
