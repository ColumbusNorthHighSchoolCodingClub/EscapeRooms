/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author 21agrawala
 */
public class SequencedButton extends Item
{
    private String text;
    private boolean isOn = false;
    
    public SequencedButton(String n, String t, Point loc)
    {
        super(n, new Rectangle(loc.x, loc.y, 30, 30));
        text = t;
    }
    public boolean isOn()
    {
            return isOn;
    }
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        if(isOn)
        {
            g.setColor(Color.GREEN);
            g.drawString(text, getRect().x, getRect().y);
        }
        else
        {
            g.setColor(Color.RED);
        }
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.setColor(Color.BLACK);
    }
    
    
}
