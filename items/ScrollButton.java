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
public class ScrollButton extends Item
{
    private String textOnButton;
    private String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int index;
    public ScrollButton(String name,Point loc)
    {
        super(name, new Rectangle(loc.x, loc.y, 20,20),null);
        textOnButton = "A";
        index=0;
    }
    
    public void reactToClick(Point p, Player player)
    {
        index++;
        if(index>=letters.length())
            index=0;
        textOnButton=letters.charAt(index)+"";
        //System.out.println("NamedButton "+getName()+" Clicked!");
    }
    public String getText() {return textOnButton;}
    public void draw(Graphics g, ImageObserver io)
    {
        g.setColor(Color.GREEN);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.setColor(Color.BLACK); //draw the text onto the button
        g.drawString(textOnButton, getRect().x, getRect().y);
    }
    
}