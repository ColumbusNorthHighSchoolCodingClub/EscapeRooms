/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import animation.ArcadeRunner;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

/**
 *
 * @author tytym
 */
public class TextBox {
    private final int EDGE_WIDTH=20;
    private String text;
    private Rectangle box;
    private boolean isOpen;
    private boolean closeOnClick;
    public TextBox() {
        text = "";
        isOpen = false;
    }
    public void draw(Graphics g,ImageObserver io) {
        if(isOpen) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(3));
            g.setFont(ArcadeRunner.customFont);
            g.setColor(new Color(224, 222, 200));
            g.fillRect(box.x,box.y,box.width,box.height);
            g.setColor(Color.black);
            g.drawRect(box.x,box.y,box.width,box.height);
            g.drawString(text,box.x+EDGE_WIDTH,box.y-EDGE_WIDTH/2+box.height);
        }
    }
    public void closeBox() {
        isOpen=false;
    }
    public void openBox(String str,boolean click) {
        text=str;
        closeOnClick = click;
        AffineTransform affinetransform = new AffineTransform();     
        FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
        Font font = ArcadeRunner.customFont;
        int width = (int)(font.getStringBounds(text, frc).getWidth());
        int height = (int)(font.getStringBounds(text, frc).getHeight());
        height+=EDGE_WIDTH;
        width+=2*EDGE_WIDTH;
        //System.out.println(width);
        box= new Rectangle(310-width/2, 440-height-20, width, height);
        isOpen=true;
    }
    public boolean shouldClose() { return closeOnClick;}
    public boolean isOpen() {return isOpen;}
}
