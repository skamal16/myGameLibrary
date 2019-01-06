package game_objects;

import gui.Button;
import java.awt.Color;
import Scenes.SceneHandler;
import java.awt.image.BufferedImage;
import main.Game;

public class Start extends Button{

    public Start(Mouse mouse) {
        super("START", Color.WHITE, "Forte", 48, Game.WIDTH/2, Game.HEIGHT/2, mouse);
    }
    
    @Override
    public void init(){
        super.init();
        BufferedImage img = this.getSprites()[0].getImage();
        float[] pos = this.transform.getPosition();
        pos[0] -= img.getWidth() / 2;
        pos[1] -= img.getHeight() / 2 + 200;
        this.transform.setPosition(pos);
    }

    @Override
    public void function() {
        SceneHandler.sceneChange(1);
    }
    
}
