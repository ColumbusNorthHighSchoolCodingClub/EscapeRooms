package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author spockm
 */
public class SimpleButton extends Item
{
    boolean isOn = false;
    
    public SimpleButton()
    {
        super("SimpleButton", new Rectangle(500,200,20,20));
    }
    
    public boolean isOn() { return isOn; }
    
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
        System.out.println("SimpleButton Clicked!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(isOn)
            g.setColor(Color.GREEN);
        else
            g.setColor(Color.RED);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
    }
}
