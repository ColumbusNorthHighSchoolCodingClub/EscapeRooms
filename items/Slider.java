/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 *
 * @author 21riddlen
 */
public class Slider extends Item {

    private int slideY;
    private int x;
    private int y;
    private int diameter;
    private int rectWidth;
    private int rectHeight;
    private Color c;
    private boolean moving;
    private int maxHeight;
    private int minHeight;

    public Slider(Point loc, int width, int height, int dia, Color c) {
        super("Slider", new Rectangle(loc.x, loc.y, dia, dia));
        x = loc.x;
        y = loc.y;
        diameter = dia;
        slideY = y;
        rectWidth = width;
        rectHeight = height;
        moving = false;
        minHeight = y + diameter / 2;//adjusted for shift of circle
        maxHeight = y + rectHeight - diameter + diameter / 2;//adjusted for shift of circle
    }

    public void reactToMousePress(Point p) {
        moving = true;
    }

    public void reactToMouseRelease(Point p) {
        moving = false;
        setRect(new Rectangle(x, slideY, diameter, diameter));
    }

    public double getIntensity() {
        return (double)(maxHeight - slideY) /(double) (maxHeight-minHeight);
    }

    public void draw(Graphics g, ImageObserver io) {
        //System.out.println(getIntensity());
        //draw vertical bar
        g.setColor(Color.gray);
        g.fillRect(x, y, rectWidth, rectHeight);
        drawCircle(g, io);
    }

    public void drawCircle(Graphics g, ImageObserver io) {
        g.setColor(Color.black);
        int drawY;
        if (moving) {
            drawY = mouseY;
        } else {
            drawY = slideY;
        }
        if (drawY < minHeight) {
            drawY = minHeight;
        }
        if (drawY > maxHeight) {
            drawY = maxHeight;
        }
        slideY = drawY;
        g.fillOval(x - diameter / 2 + rectWidth / 2, drawY - diameter / 2, diameter, diameter);
    }
}
