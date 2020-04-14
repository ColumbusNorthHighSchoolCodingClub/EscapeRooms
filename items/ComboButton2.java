package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class ComboButton2 extends Item
{
    boolean isOn = false;
    
    public ComboButton2()
    {
        super("ComboButton2", new Rectangle(500,200,20,20));
    }
    public boolean isOn() { return isOn; }
    
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
        System.out.println("ComboButton2 Clicked!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(isOn)
            g.setColor(Color.GRAY);
        else
            g.setColor(Color.BLUE);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
    }
}
