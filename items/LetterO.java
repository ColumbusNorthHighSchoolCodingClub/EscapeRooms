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
public class LetterO extends Item
{
     public LetterO(Point loc)
    {
        super("O", new Rectangle(loc.x, loc.y, 50, 50));
        enablePickUpOnClick();
    }
         public void draw(Graphics g, ImageObserver io)
    {
       

        g.drawImage(OImage, getRect().x, getRect().y, io);
    }
}
