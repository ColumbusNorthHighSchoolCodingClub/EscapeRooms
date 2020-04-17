/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Room;
import items.ScavMaze;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author lambi
 */
public class ScavengerMaze extends Room {

    public ScavengerMaze() {
        super();
        ArrayList<Point> keys = new ArrayList<>();
        Point key1 = new Point(16, 3);
        Point key2 = new Point(2, 11);
        Point key3 = new Point(13, 16);
        keys.add(key1);
        keys.add(key2);
        keys.add(key3);

        ArrayList<Point> tele = new ArrayList<>();
        Point tele1 = new Point(9, 7);
        Point tele2 = new Point(5, 1);
        tele.add(tele1);
        tele.add(tele2);

        Point[] blocks = {new Point(0, 0),new Point(1, 0),new Point(2, 0),new Point(3, 0), 
            new Point(4, 0),new Point(5, 0),new Point(6, 0),new Point(7, 0),new Point(8, 0),
            new Point(9, 0),new Point(10, 0),new Point(11, 0),new Point(12, 0),
            new Point(13, 0),new Point(14, 0),new Point(15, 0),new Point(16, 0),new Point(17, 0),
            new Point(18, 0),new Point(19, 0),new Point(0, 1),new Point(0, 2),new Point(0,3),
        new Point(0,4),new Point(0,5),new Point(0,6),new Point(0,7),new Point(0,8),new Point(0,9),
        new Point(0,10),new Point(0,11),new Point(0,12),new Point(0,13),new Point(0,14),new Point(0,15),
        new Point(0,16),new Point(0,17),new Point(0,18),new Point(0,19),new Point(1,19),new Point(2,19),
        new Point(3,19),new Point(4,19),new Point(5,19),new Point(6,19),new Point(7,19),new Point(8,19),
        new Point(9,19),new Point(10,19),new Point(11,19),new Point(12,19),new Point(13,19),new Point(14,19),
        new Point(15,19),new Point(16,19),new Point(17,19),new Point(18,19),new Point(19,19),new Point(19,1),
        new Point(19,2),new Point(19,3),new Point(19,4),new Point(19,5),new Point(19,6),new Point(19,7),
        new Point(19,8),new Point(19,9),new Point(19,10),new Point(19,11),new Point(19,12),new Point(19,13),
        new Point(19,14),new Point(19,15),new Point(19,16),new Point(19,17),new Point(19,18),new Point(4,1),
        new Point(12,1),new Point(13,1),new Point(15,1),new Point(1,2),new Point(2,2),new Point(5,2),
        new Point(6,2),new Point(7,2),new Point(8,2),new Point(9,2),new Point(10,2),new Point(11,2),
        new Point(12,2),new Point(13,2),new Point(17,2),new Point(1,3),new Point(3,3),new Point(7,3),
        new Point(14,3),new Point(15,3),new Point(17,3),new Point(4,4),new Point(5,4),new Point(8,4),
        new Point(9,4),new Point(16,4),new Point(2,5),new Point(6,5),new Point(11,5),new Point(12,5),
        new Point(13,5),new Point(17,5),new Point(3,6),new Point(7,6),new Point(8,6),new Point(14,6),
        new Point(15,6),new Point(16,6),new Point(2,7),new Point(4,7),new Point(8,7),
        new Point(10,7),new Point(11,7),new Point(12,7),new Point(18,7),new Point(2,8),new Point(5,8),
        new Point(8,8),new Point(9,8),new Point(10,8),new Point(13,8),new Point(15,8),new Point(16,8),
        new Point(17,8),new Point(6,9),new Point(12,9),new Point(15,9),new Point(1,10),new Point(3,10),
        new Point(7,10),new Point(8,10),new Point(9,10),new Point(10,10),new Point(14,10),new Point(18,10),
        new Point(1,11),new Point(3,11),new Point(4,11),new Point(11,11),new Point(12,11),new Point(13,11),
        new Point(16,11),new Point(18,11),new Point(1,12),new Point(6,12),new Point(8,12),new Point(9,12),new Point(15,12),
        new Point(3,13),new Point(4,13),new Point(5,13),new Point(10,13),new Point(11,13),new Point(12,13),
        new Point(13,13),new Point(14,13),new Point(15,13),new Point(16,13),new Point(1,14),
        new Point(5,14),new Point(17,14),new Point(2,15),new Point(6,15),new Point(7,15),new Point(8,15),
        new Point(9,15),new Point(10,15),new Point(11,15),new Point(12,15),new Point(13,15),new Point(14,15),new Point(16,15),
        new Point(17,15),new Point(2,16),new Point(7,16),new Point(14,16),new Point(18,16),
        new Point(1,17),new Point(4,17),new Point(5,17),new Point(6,17),new Point(3,18),new Point(14,18)};

        this.addItem(new ScavMaze(blocks, new Point(1, 1), new Point(11, 1), keys, tele));
    }

    public boolean isDone() {
        return (((ScavMaze) getItemByName("ScavMaze")).solved());
    }
}
