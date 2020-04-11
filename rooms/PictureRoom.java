/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Player;
import gameObjects.Room;
import items.PictureFrame;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import static gameObjects.Item.backgroundJ;
import items.Key;
import items.flexibleDoor;
import java.awt.Point;

/**
 *
 * @author jdawg
 * 
 *For some reason when the key is picked up it doesn't stop animating it and add it to the
 * players inventory
 */
public class PictureRoom extends Room {

    Player player;
    PictureFrame p1 = new PictureFrame(315, 80);
    Key k = new Key(new Point(382, 145));

    public PictureRoom() {
        super();
        this.addItem(k);
        this.addItem(p1);
        this.addItem(new flexibleDoor(559,114,55,282));
    }

    public boolean isDone() {
        return ((flexibleDoor)getItemByName("flexibleDoor")).isOpen();
    }

    public void draw(Graphics g, ImageObserver io) {
        g.drawImage(backgroundJ, 0, 0, io);
        k.draw(g, io);
        p1.draw(g, io);
    }
}
