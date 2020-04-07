/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import static java.awt.Color.GREEN;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
/**
 *
 * @author Eamon
 */
public class HiddenButton extends Item
{
    boolean isOn = false;
    private Color c;
    public HiddenButton(int x, int y, Color z)
    {
        super("HiddenButton", new Rectangle(x,y,30,30));
        c = z;
    }
    public boolean isOn() { return isOn; }
    
    public void reactToClick(Point p, Player player)
    {
        isOn = !isOn;
        System.out.println("HiddenButton Clicked!");
    }
    public void draw(Graphics g, ImageObserver io)
    {
        if(isOn)
            g.setColor(GREEN);
        else
            g.setColor(c);
        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
    }
}
