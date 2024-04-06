package org.lilmoon.circles;

import org.lilmoon.common.Interactable;
import org.lilmoon.common.MainCanvas;

import java.awt.*;

public class Background implements Interactable {
    private double time;
    private static final double AMPLITUDE = 255.0 / 2;
    private Color color;

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        time += deltaTime;
        int red = (int) Math.round(AMPLITUDE + AMPLITUDE * Math.sin(time * 2));
        int green = (int) Math.round(AMPLITUDE + AMPLITUDE * Math.sin(time * 3));
        int blue = (int) Math.round(AMPLITUDE + AMPLITUDE * Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {
        canvas.setBackground(color);
    }
}