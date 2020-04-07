/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

/**
 *
 * @author 21reisingerm
 */
public class LetterL extends Item
{
     public LetterL(Point loc)
    {
        super("L", new Rectangle(loc.x, loc.y, 50, 50));
        enablePickUpOnClick();
    }
         public void draw(Graphics g, ImageObserver io)
    {
       

        g.drawImage(LImage, getRect().x, getRect().y, io);
    }
}