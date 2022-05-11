package main;

import inputs.KeyboardImputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private int x = 100, y = 100;

    private BufferedImage image, subImage;

    private MouseInputs mouseInputs = new MouseInputs();

    public GamePanel() {
        importImage();
        setPanelSize();
        addKeyListener(new KeyboardImputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    private void importImage() {
        InputStream inputStream = getClass().getResourceAsStream("/player_sprites.png");
        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1200, 800);
        setMinimumSize(size);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        subImage = image.getSubimage(1 * 64, 1 * 40, 64, 40);
        graphics.drawImage(subImage, x, y, 128, 80, null);

    }

    public void changeX(int value) {
        this.x += value;

    }

    public void changeY(int value) {
        this.y += value;

    }

}
