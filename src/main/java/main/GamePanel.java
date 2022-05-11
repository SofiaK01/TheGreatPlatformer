package main;

import inputs.KeyboardImputs;
import inputs.MouseInputs;

import javax.swing.*;
;import java.awt.*;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;


public class GamePanel extends JPanel {
    private int x = 100, y = 100;

    private MouseInputs mouseInputs = new MouseInputs();
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        addKeyListener(new KeyboardImputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        System.out.println(GAME_WIDTH+" "+ GAME_HEIGHT);
        setPreferredSize(size);
    }

    public void updateGame() {

    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        game.render(graphics);
    }

    public Game getGame() {
        return game;
    }
}
