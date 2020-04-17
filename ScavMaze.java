/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Point;
import gameObjects.Item;
import gameObjects.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

/**
 *
 * @author lambi
 */
public class ScavMaze extends Item {
    Point[] blocks;
    ArrayList<Point> keyLocs = new ArrayList<>();
    ArrayList<Point> teleporters = new ArrayList<>();
    Point playerLoc;
    Point end;
    int keysNum = 0;
    boolean solved = false;
    public ScavMaze(Point[] blocks1, Point playerLoc1, Point end1, ArrayList<Point> keys, ArrayList<Point> tele)
    {
        super("ScavMaze",new Rectangle(1,1,1,1));
        blocks = blocks1;
        keyLocs = keys;
        teleporters = tele;
        playerLoc = playerLoc1;
        end = end1;
    }
    public boolean solved()
    {
        return solved;
    }
    public boolean blocksHasPoint(Point p)
    {
        for(Point b:blocks)
        {
            if(b.equals(p))
             return true;
        }
        return false;
    }
    public boolean teleporterPoint(Point p)
    {
        for(Point t:teleporters)
        {
            if(t.equals(p))
             return true;
        }
        return false;
    }
    public boolean keyPoint(Point p)
    {
        for(Point k:keyLocs)
        {
            if(k.equals(p))
             return true;
        }
        return false;
    }
    public void draw(Graphics g, ImageObserver io)
    {
        g.setColor(Color.BLACK);
        g.drawString("Use WASD", 500, 100);
        g.drawString("Keys: " + keysNum, 500, 150);
        if(solved==false)
        {
        for(int x = 0;x<20;x++)
        {
            for(int y = 0;y<20;y++)
            {
                if(blocksHasPoint(new Point(x,y)))
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(x*20+10, y*20+30, 20, 20);
                    g.setColor(Color.BLACK);
                    g.fillRect(x*20+11, y*20+31, 19, 19);
                }
                else if(keyPoint(new Point(x,y)))
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(x*20+10, y*20+30, 20, 20);
                    g.setColor(Color.YELLOW);
                    g.fillRect(x*20+11, y*20+31, 19, 19);
                }
                else if(teleporterPoint(new Point(x,y)))
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(x*20+10, y*20+30, 20, 20);
                    g.setColor(Color.ORANGE);
                    g.fillRect(x*20+11, y*20+31, 19, 19);
                }
                else if(playerLoc.equals(new Point(x,y)))
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(x*20+10, y*20+30, 20, 20);
                    g.setColor(Color.BLUE);
                    g.fillRect(x*20+11, y*20+31, 19, 19);
                }
                else if(end.equals(new Point(x,y)))
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(x*20+10, y*20+30, 20, 20);
                    g.setColor(Color.GREEN);
                    g.fillRect(x*20+11, y*20+31, 19, 19); 
                }
                else
                {
                    g.setColor(Color.BLACK);
                    g.drawRect(x*20+10, y*20+30, 20, 20);
                    g.setColor(Color.WHITE);
                    g.fillRect(x*20+11, y*20+31, 19, 19); 
                }
            }
        }
        }
    }
    //move spot around maze
    
    @Override
    public void reactToKey(char c, Player player) {
       if(c=='w')
       {
        Point dest = new Point(playerLoc.x,playerLoc.y-1);  
        if(dest.x>=0&&dest.x<=19&&dest.y>=0&&dest.y<=19&&!blocksHasPoint(dest))
        playerLoc=dest;
       }
       if(c=='a')
       {
        Point dest = new Point(playerLoc.x-1,playerLoc.y);  
        if(dest.x>=0&&dest.x<=19&&dest.y>=0&&dest.y<=19&&!blocksHasPoint(dest))
        playerLoc=dest;   
       }
       if(c=='s')
       {
        Point dest = new Point(playerLoc.x,playerLoc.y+1);  
        if(dest.x>=0&&dest.x<=19&&dest.y>=0&&dest.y<=19&&!blocksHasPoint(dest))
        playerLoc=dest;   
       }
       if(c=='d')
       {
        Point dest = new Point(playerLoc.x+1,playerLoc.y);  
        if(dest.x>=0&&dest.x<=19&&dest.y>=0&&dest.y<=19&&!blocksHasPoint(dest))
        playerLoc=dest;   
       }
       
       if(playerLoc.equals(end))
           solved = true;
       else if(keyPoint(playerLoc))
       {
           keysNum++;
           for(int n = 0; n < keyLocs.size(); n++)
               if(keyLocs.get(n).equals(playerLoc))
                   keyLocs.remove(n);
       }
       else if(teleporterPoint(playerLoc))
       {
           int currentIndex = 0;
           for(int l = 0; l < teleporters.size(); l++)
               if(teleporters.get(l).equals(playerLoc))
                   currentIndex = l;
           int nextIndex = (teleporters.size()-1) - currentIndex;
           if(keysNum == 3)
               playerLoc.setLocation(teleporters.get(nextIndex));
       }
    }
}
