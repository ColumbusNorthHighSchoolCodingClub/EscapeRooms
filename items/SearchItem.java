/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import static gameObjects.Item.keyImage;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author 20songe
 */
public class SearchItem extends Item{
    
    private Image search;
    public SearchItem(Image i, Point loc)
    {
        super("SearchItem", new Rectangle(loc.x, loc.y, 30, 30));
        search = i;
        enablePickUpOnClick();
    }
   
    public void reactToClick(Point p, Player player)
    {
        player.addItem(this);
        System.out.println("A click occured and has overriden the reactToClick method");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
//        g.setColor(Color.YELLOW);
//        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.drawImage(search, getRect().x, getRect().y, io);
    }
    
    
}
