package main;

import entities.Player;
import levels.LevelManager;

import java.awt.*;

public class Game implements Runnable {
    private static final double FPS_SET = 120;
    private static final double UPS_SET = 200;
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private Player player;
    private LevelManager levelManager;

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.5f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (SCALE * TILES_DEFAULT_SIZE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game() {
        ititClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();

    }

    private void ititClasses() {
        player = new Player(200, 200);
        levelManager = new LevelManager(this);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastCheck = System.currentTimeMillis();
        long now = System.nanoTime();

        long previousTime = System.nanoTime();


        int frames = 0;
        int updates = 0;


        double deltaU = 0;
        double deltaF = 0;

        while (true) {

            long currentTime = System.nanoTime();


            deltaU += ((currentTime - previousTime) / timePerUpdate);
            deltaF += ((currentTime - previousTime) / timePerFrame);
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }


            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + "  |  UPS:" + updates);
                frames = 0;
                updates = 0;
            }
        }

    }

    public void render(Graphics graphics) {
        player.render(graphics);
        levelManager.draw(graphics);
    }

    private void update() {
        player.update();
        levelManager.update();
    }

    public Player getPlayer() {
        return player;
    }

    public void windowfocusLost() {
        player.resetDirBooleans();
    }
}