package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * When a screen has multiple Buttons, it would be useful to name them.  
 * @author spockm
 */
public class NamedButton extends Item
{
    private String textOnButton;
    private boolean isOn = false;
    
    public NamedButton(String n, String text, Point loc)
    {
        super(n, new Rectangle(loc.x, loc.y, 20,20));
        textOnButton = text;
    }
    
    public boolean isOn() { return isOn; }
    
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
        System.out.println("NamedButton "+getName()+" Clicked!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(isOn)
            g.setColor(Color.GREEN);
        else
            g.setColor(Color.RED);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.setColor(Color.BLACK); //draw the text onto the button
        g.drawString(textOnButton, getRect().x, getRect().y);
    }
    
}
