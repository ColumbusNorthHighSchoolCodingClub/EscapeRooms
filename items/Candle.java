package items;

import gameObjects.Item;
import static gameObjects.Item.candleImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class Candle extends Item 
{
    
    public Candle()
    {
        super("Candle", new Rectangle(100,100,10,25));
        enablePickUpOnClick();
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        g.setColor(Color.YELLOW);
        //g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.drawImage(candleImage, getRect().x, getRect().y, io);
    }
    
}