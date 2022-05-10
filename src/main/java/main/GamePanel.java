package main;

import inputs.KeyboardImputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        addKeyListener(new KeyboardImputs());

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.fillRect(100, 100, 200, 50);
        graphics.setColor(Color.BLUE);
        graphics.drawLine(150, 160, 50, 170);
    }
}
