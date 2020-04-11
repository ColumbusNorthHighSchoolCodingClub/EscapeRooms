/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import static gameObjects.Item.openPic;
import static gameObjects.Item.closePic;
import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author jdawg
 */
public class PictureFrame extends Item {

    int x;
    int y;
    int xMax = x + 130;
    int yMax = y + 166;
    boolean isOpen = false;

    //constructor
    public PictureFrame(int x1, int y1) {
        super("PictureFrame", new Rectangle(x1, y1, 130, 166));
        x = x1;
        y = y1;
        xMax = x + 130;
        yMax = y + 166;
        System.out.println(x + " " + xMax + " " + y + " " + yMax);
    }

    //get/set
    public boolean isOpen() {
        return isOpen;
    }

    public void reactToClick(Point p, Player player) {
        if (isOpen) {
            if (p.x < x + 23 && p.x > x && p.y < yMax && p.y > y) {
                isOpen = false;
            }
        } else {
            if (p.x < xMax && p.x > x && p.y < yMax && p.y > y) {
                isOpen = true;
            }
        }
    }

    public void draw(Graphics g, ImageObserver io) {
        if (isOpen) {
            g.drawImage(openPic, getRect().x, getRect().y, io);
        } else {
            g.drawImage(closePic, getRect().x, getRect().y, io);
        }
    }
}
