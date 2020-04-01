/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Item;
import gameObjects.Room;
import items.BasicDoor;
import items.Maze;
import java.awt.Point;

/**
 *
 * @author 20lirettet
 */
public class RoomTwo extends Room
{
    public RoomTwo()
    {
        super();
        Point[] blocks = {new Point(0,0),new Point(0,1),new Point(0,2),new Point(0,3),new Point(0,4),new Point(0,5),new Point(0,6),new Point(0,7),new Point(0,8),new Point(0,9),new Point(0,10),new Point(0,11),new Point(0,12),new Point(0,13),new Point(0,14),new Point(0,15),new Point(0,16),new Point(0,17),new Point(0,18),new Point(0,19),
            new Point(1,0),new Point(1,19),
            new Point(2,0),new Point(2,2),new Point(2,3),new Point(2,4),new Point(2,5),new Point(2,6),new Point(2,7),new Point(2,8),new Point(2,9),new Point(2,10),new Point(2,11),new Point(2,12),new Point(2,14),new Point(2,15),new Point(2,16),new Point(2,17),new Point(2,19),
            new Point(3,0),new Point(3,2),new Point(3,12),new Point(3,14),new Point(3,16),new Point(3,19),
            new Point(4,0),new Point(4,2),new Point(4,3),new Point(4,4),new Point(4,6),new Point(4,8),new Point(4,9),new Point(4,10),new Point(4,12),new Point(4,14),new Point(4,16),new Point(4,18),new Point(4,19),
            new Point(5,0),new Point(5,6),new Point(5,8),new Point(5,12),new Point(5,16),new Point(5,18),new Point(5,19),
            new Point(6,0),new Point(6,2),new Point(6,3),new Point(6,4),new Point(6,5),new Point(6,6),new Point(6,8),new Point(6,9),new Point(6,10),new Point(6,11),new Point(6,12),new Point(6,13),new Point(6,14),new Point(6,15),new Point(6,16),new Point(6,19),
            new Point(7,0),new Point(7,2),new Point(7,8),new Point(7,13),new Point(7,17),new Point(7,19),
            new Point(8,0),new Point(8,2),new Point(8,4),new Point(8,5),new Point(8,6),new Point(8,7),new Point(8,8),new Point(8,10),new Point(8,11),new Point(8,12),new Point(8,13),new Point(8,15),new Point(8,17),new Point(8,19),
            new Point(9,0),new Point(9,2),new Point(9,6),new Point(9,10),new Point(9,11),new Point(9,15),new Point(9,19),
            new Point(10,0),new Point(10,2),new Point(10,3),new Point(10,4),new Point(10,6),new Point(10,8),new Point(10,11),new Point(10,13),new Point(10,14),new Point(10,16),new Point(10,18),new Point(10,19),
            new Point(11,0),new Point(11,6),new Point(11,8),new Point(11,9),new Point(11,11),new Point(11,13),new Point(11,14),new Point(11,16),new Point(11,19),
            new Point(12,0),new Point(12,2),new Point(12,3),new Point(12,4),new Point(12,5),new Point(12,6),new Point(12,9),new Point(12,11),new Point(12,13),new Point(12,14),new Point(12,16),new Point(12,17),new Point(12,19),
            new Point(13,0),new Point(13,2),new Point(13,3),new Point(13,4),new Point(13,5),new Point(13,6),new Point(13,7),new Point(13,9),new Point(13,11),new Point(13,16),new Point(13,19),
            new Point(14,0),new Point(14,2),new Point(14,9),new Point(14,11),new Point(14,12),new Point(14,13),new Point(14,14),new Point(14,15),new Point(14,18),new Point(14,19),
            new Point(15,0),new Point(15,6),new Point(15,7),new Point(15,8),new Point(15,9),new Point(15,11),new Point(15,17),new Point(15,18),new Point(15,19),
            new Point(16,0),new Point(16,2),new Point(16,3),new Point(16,4),new Point(16,9),new Point(16,11),new Point(16,13),new Point(16,14),new Point(16,15),new Point(16,16),new Point(16,17),new Point(16,18),new Point(16,19),
            new Point(17,0),new Point(17,2),new Point(17,3),new Point(17,4),new Point(17,6),new Point(17,7),new Point(17,8),new Point(17,9),new Point(17,11),new Point(17,13),new Point(17,17),new Point(17,18),new Point(17,19),
            new Point(18,0),new Point(18,9),new Point(18,11),new Point(18,15),new Point(18,19),
            new Point(19,0),new Point(19,1),new Point(19,2),new Point(19,3),new Point(19,4),new Point(19,5),new Point(19,6),new Point(19,7),new Point(19,8),new Point(19,9),new Point(19,10),new Point(19,11),new Point(19,12),new Point(19,13),new Point(19,14),new Point(19,15),new Point(19,16),new Point(19,17),new Point(19,18),new Point(19,19),
            
        
        
        };
        this.addItem(new Maze(blocks,new Point (1,1),new Point (18,18)));
    }
    
    public boolean isDone()
    {
        return (((Maze)getItemByName("Maze")).solved());    
    }
}
