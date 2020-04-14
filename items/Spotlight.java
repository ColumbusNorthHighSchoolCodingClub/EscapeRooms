/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import gameObjects.Item;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

/**
 * Spotlight
 * Follows the mouse cursor and draws a spotlight.
 * 
 * by Tate McKenney
 */
public class Spotlight extends Item {
    
    private int x; // x coordinate of center of spotlight
    private int y; // y coordinate of center of spotlight
    
    
    public Spotlight() {
        super("Spotlight", new Rectangle());
    }
    
    
    // Moves the spotlight to the given position
    public void setPosition(int xPos, int yPos) {
        x = xPos;
        y = yPos;
        setRect(new Rectangle(x - 100, y - 100, 200, 200));
    }
    
    
    public void draw(Graphics g, ImageObserver io) {
        g.setColor(new Color(255, 255, 64, 160));
        g.fillOval(x - 100, y - 100, 200, 200);
    }
}
