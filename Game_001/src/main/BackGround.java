package main;

import Components.GameObject;
import Components.sprites.Sprite;
import java.awt.image.BufferedImage;

public class BackGround extends GameObject{
    
    BufferedImage image;

    public BackGround(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void init() {
        addSprite(new Sprite(this, image));
    }
    
}
