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
public class TimedButton extends Item
{
    private boolean isOn = false;
    private int timer = 0;
    
    public TimedButton()
    {
        super("TimedButton", new Rectangle(500,200,20,20));
    }
    
    public boolean isOn() { return isOn; }
    
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
        timer = 120;
        System.out.println("TimedButton Clicked!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        
        if(isOn)
        {
            g.setColor(Color.GREEN);
            if(timer==0) isOn=false;
            else timer--;
        }
        else
            g.setColor(Color.RED);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
    }
}
