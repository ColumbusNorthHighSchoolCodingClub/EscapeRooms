/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import static gameObjects.Item.targetImage;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Random;

/**
 *
 * @author 20songe
 */
public class Target extends Item{
    
    private int x;
    private int y;
    private Graphics g;
    private ImageObserver io;
    public Target(Point loc)
    {
        super("Target", new Rectangle(loc.x,loc.y,50,50));
    }
    
    public Rectangle getHitBox()
    {
        return new Rectangle(this.getRect().x+15,this.getRect().y+17,17,16);
    }
    
    public void reactToClick(Point p, Player player)
    {
        Random rand = new Random();
        x=rand.nextInt(580);
        y=rand.nextInt(420);
     
        this.setRect(new Rectangle(x,y,50,50));
        System.out.println("Yay!");
    }
    
    public void draw(Graphics g, ImageObserver io)
    {
//        g.setColor(Color.YELLOW);
//        g.fillRect(getRect().x, getRect().y, getRect().width, getRect().height);
        g.drawImage(targetImage, getRect().x, getRect().y, io);
    }
   
    
    
       
    
}
