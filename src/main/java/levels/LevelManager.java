package levels;

import main.Game;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utils.LoadSave.LEVEL_ATLAS;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;

    public LevelManager(Game game) {
        this.game = game;
        
        importOutsideSprites();

    }

    private void importOutsideSprites() {
        BufferedImage image = LoadSave.getSpriteAtlas(LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                int index = i * 12 + j;
                levelSprite[index] = image.getSubimage(j * 32, i * 32, 32, 32);
            }
        }

    }

    public void draw(Graphics graphics) {
        graphics.drawImage(levelSprite[2], 0, 0, null);
    }

    public void update() {

    }
}
