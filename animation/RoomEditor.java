package animation;

import gameObjects.Item;
import gameObjects.Room;
import items.BasicDoor;
import items.ColorCombo;
import items.CombinationSafe;
import items.Key;
import items.LockedDoor;
import items.NamedButton;
import items.NumberedDoor;
import items.Paper;
import items.SimpleButton;
import items.SimpleButtonBordered;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import rooms.RoomOne;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rickyehara
 */
public class RoomEditor {

    ArrayList<Item> staticitems = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Boolean> buttonOver = new ArrayList();
    ArrayList<Rectangle> buttons = new ArrayList();
    ArrayList<Item> placed = new ArrayList();
    Item selected;
    int x = 0;
    int y = 0;
    int xoffset = 0;
    int yoffset = 0;
    String s = "placeholder";
    boolean menu = true;
    Room r;// = new RoomOne();

    public RoomEditor(Room rin) {
        r = rin;
        initializeItems();
    }

    public RoomEditor() {
        initializeItems();
    }

    private void initializeItems() {
        System.out.println("Once you have placed the items, press p to print their coordinates - given as x,y");
        items.add(new BasicDoor());
        items.add(new CombinationSafe());
        //items.add(new KamiPuzzle());
        items.add(new LockedDoor());
        items.add(new Paper());
        //items.add(new Maze());
        items.add(new SimpleButton());
        items.add(new SimpleButtonBordered());
        items.add(new Key(new Point(x, y)));
        items.add(new ColorCombo(new Point(x, y)));
        items.add(new NamedButton("NamedButton", s, new Point(x, y)));
        items.add(new NumberedDoor("NumberedDoor", s, new Point(x, y)));
        //items.add(new RushHourPuzzle());
        for (int counter = 0; counter < items.size(); counter++) {
            buttonOver.add(false);
            buttons.add(new Rectangle(0, counter * 20, 120, 20));
        }
    }

    public Graphics drawEditor(Graphics g, ImageObserver io, int mouseX, int mouseY) {
        x = mouseX + xoffset;
        y = mouseY + yoffset;
        drawMenu(g);
        drawItems(g, io);
        if (r != null) {
            r.draw(g, io);
        }
        return g;
    }

    public Graphics drawItems(Graphics g, ImageObserver io) {
        for (Item i : placed) {
            i.draw(g, io);
        }
        if (!menu) {
            selected.set(x, y);
            selected.draw(g, io);
        }
        return g;
    }

    public Graphics drawMenu(Graphics g) {
        if (menu) {
            for (int counter = 0; counter < items.size(); counter++) {
                if (buttons.get(counter).contains(x, y)) {
                    buttonOver.set(counter, true);
                    g.setColor(Color.YELLOW);
                    fillRect(buttons.get(counter), g);
                    g.setColor(Color.BLACK);
                } else {
                    buttonOver.set(counter, false);
                }
                g.drawString(items.get(counter).getName() + " ", 5, (counter * 20) + 15);
                drawRect(buttons.get(counter), g);
            }
        }
        return g;
    }
    
    public void printLoc(){
        for(int counter = 0; counter < placed.size(); counter++){
            System.out.println(placed.get(counter).getName() + " is at " + placed.get(counter).getRect().x + ", " + placed.get(counter).getRect().y);
        }
    }

    public void click() {
        if (menu) {
            for (int counter = 0; counter < items.size(); counter++) {
                if (buttonOver.get(counter)) {
                    //System.out.println("clicked");
                    //items.get(counter).
                    selected = items.get(counter);
                    menu = !menu;
                }
            }
        } else {
            placed.add(selected);
            menu = !menu;
            xoffset = 0;
            yoffset = 0;
            //System.out.println(selected);
        }
    }

    public void offset(boolean left, boolean right, boolean up, boolean down) {
        if (left) {
            xoffset--;
        }
        if (right) {
            xoffset++;
        }
        if (up) {
            yoffset--;
        }
        if (down) {
            yoffset++;
        }
    }

    public Graphics drawRect(Rectangle r, Graphics g) {
        g.drawRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
        return g;
    }

    public Graphics fillRect(Rectangle r, Graphics g) {
        g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
        return g;
    }
}
