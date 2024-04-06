package org.lilmoon.common;

import org.lilmoon.common.MainCanvas;

import java.awt.*;

public interface Interactable {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}
