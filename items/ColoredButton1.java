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
public class ColoredButton1 extends Item
{
    private String textOnButton;
    private Color color;
    private boolean isOn = false;
    
    public ColoredButton1(String n, Color inputColor, Point loc)
    {
        super(n, new Rectangle(loc.x, loc.y, 20,20));
        color=inputColor;
        //textOnButton = text;
    }
    
    public boolean isOn() { return isOn; }
    
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
        System.out.println("ColoredButton "+getName()+" Clicked!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(isOn)
            g.setColor(Color.BLACK);
        //will set the color to green if it is activated
        else
            g.setColor(color);
        //if it is not activated, it will be the rainbow color
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
//        g.setColor(Color.BLACK); //draw the text onto the button
//        g.drawString(textOnButton, getRect().x, getRect().y);
        //dont need any more text drawing
    }
    
}