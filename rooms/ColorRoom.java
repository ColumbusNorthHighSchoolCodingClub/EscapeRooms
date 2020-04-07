/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

import gameObjects.Room;
import items.Slider;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

/**
 *
 * @author 21riddlen
 */
public class ColorRoom extends Room {

    private double[] intensities;

    private int sliderStartX;
    private int sliderGap;
    private int sliderY;
    private Color goalColor;
    private int thresholdAmount;

    private int circlesX;
    private int circlesY;
    private int diameter;

    public ColorRoom() {
        super();

        sliderStartX = 50;
        sliderGap = 50;
        sliderY = 50;

        circlesX = 50;
        circlesY = 200;
        diameter = 100;

        intensities = new double[]{0, 0, 0};
        goalColor = makeRandomColor();
        thresholdAmount = 30;

        //red slider
        addItem(new Slider(new Point(sliderStartX, sliderY), 5, 100, 20, Color.magenta));
        //green slider
        addItem(new Slider(new Point(sliderStartX + sliderGap, sliderY), 5, 100, 20, Color.green));
        //blue slider
        addItem(new Slider(new Point(sliderStartX + 2 * sliderGap, sliderY), 5, 100, 20, Color.cyan));

        //color circles
        //addItem(new ColorCircle(new Point(100, 150), goalColor));
    }

    public Color makeRandomColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    public boolean matchesGoalColor() {
        return Math.abs(intensities[0] * 255 - goalColor.getRed()) < thresholdAmount && Math.abs(intensities[1] * 255 - goalColor.getGreen()) < thresholdAmount && Math.abs(intensities[2] * 255 - goalColor.getBlue()) < thresholdAmount;
    }

    public boolean isDone() {
        return matchesGoalColor();
    }

    public void draw(Graphics g, ImageObserver io) {
        for (int i = 0; i < 3; i++) {
            getItems().get(i).draw(g, io);
            getItems().get(i).updateMouseCoords(mouseX, mouseY);
            intensities[i] = ((Slider) getItems().get(i)).getIntensity();
        }
        //((ColorCircle) getItems().get(3)).draw(g, io, intensities);

        drawCircles(g, io);
    }

    public void drawCircles(Graphics g, ImageObserver io) {
        g.setColor(new Color((int) (intensities[0] * 255 + 0), (int) (intensities[1] * 255 + 0), (int) (intensities[2] * 255 + 0)));
        g.fillOval(circlesX, circlesY, diameter, diameter);

        g.setColor(goalColor);
        g.fillOval(circlesX, circlesY + diameter + diameter / 10, diameter, diameter);
    }
}
