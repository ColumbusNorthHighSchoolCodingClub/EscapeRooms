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
 * @author 22leec
 */
public class ColoredButton extends Item
{
    boolean isOn = false;
    Color[] myColors = {Color.RED, Color.MAGENTA, Color.YELLOW, Color.BLUE, Color.GREEN};
    Color color = Color.RED;
    
    public ColoredButton()
    {
        super("ColoredButton", new Rectangle(500,200,20,20));
    }
    
    public boolean isOn() { return isOn; }
    
    int i = 0;
    public void reactToClick(Point p, Player player)
    {
        i++;
        if(i == myColors.length)
            i = 0;
        color = myColors[i];
        
        if(i==4)
            isOn = !isOn;
        else
            isOn = false;
        System.out.println("ColoredButton Clicked!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
        g.setColor(color);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
    }
}
