package org.lilmoon.circles;

import org.lilmoon.bricks.Brick;
import org.lilmoon.common.CanvasRepaintListener;
import org.lilmoon.common.Interactable;
import org.lilmoon.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Interactable[] sprites = new Interactable[15];

    private MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles!");

        sprites[0] = new Background();
        for (int i = 1; i < 10; i++) {
            sprites[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    removeSpriteFromArray();
                }
            }
        });
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    addNewSpriteToArray();
                }
            }
        });
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (Interactable sprite : sprites) {
            if (sprite != null) sprite.update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (Interactable sprite : sprites) {
            if (sprite != null) sprite.render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    public void addNewSpriteToArray() {
        try {
            isArrayFull();
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null,"Array is full. You can't add more sprites...","ARRAY FULL ERROR",JOptionPane.ERROR_MESSAGE);
        }
            for (int i = 0; i < sprites.length; i++) {
                if (sprites[i] == null) {
                    sprites[i] = new Brick();
                    break;
                }
            }
    }

    public void removeSpriteFromArray() {
        try{
            isArrayEmpty();
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null,"Array is empty. You can't delete anything...","ARRAY EMPTY ERROR",JOptionPane.ERROR_MESSAGE);
        }
            for (int i = 0; i < sprites.length; i++) {
                if (sprites[i] != null) {
                    sprites[i] = null;
                    break;
                }
            }

    }

    public void isArrayFull(){
        int counter = 0;
        for (Interactable sprite : sprites) {
            if (sprite != null) counter ++;
        }
        if (counter == sprites.length){
            throw new RuntimeException();
        }
    }

    public void isArrayEmpty(){
        int counter = 0;
        for (Interactable sprite : sprites) {
            if (sprite == null) counter ++;
        }
        if (counter == sprites.length) {
            throw new RuntimeException();
        }
    }
}

