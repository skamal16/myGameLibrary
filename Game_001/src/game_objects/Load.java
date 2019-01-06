package game_objects;

import gui.Button;
import java.awt.Color;
import java.awt.image.BufferedImage;
import main.Game;

public class Load extends Button{

    public Load(Mouse mouse) {
        super("LOAD", Color.WHITE, "Forte", 48, Game.WIDTH/2, Game.HEIGHT/2, mouse);
    }
    
    @Override
    public void init(){
        super.init();
        BufferedImage img = this.getSprites()[0].getImage();
        float[] pos = this.transform.getPosition();
        pos[0] -= img.getWidth()/2;
        pos[1] -= img.getHeight()/2 + 100;
        this.transform.setPosition(pos);
    }

    @Override
    public void function() {
        
    }
    
}
