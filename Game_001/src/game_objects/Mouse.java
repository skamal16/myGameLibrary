package game_objects;

import Components.GameObject;
import Components.Script;
import Components.colliders.SquareCollider;
import Components.sprites.Sprite;
import Scripts.MouseMovement;
import static main.Game.IMAGES;
import java.awt.image.BufferedImage;

public class Mouse extends GameObject{
    
    private final BufferedImage image = IMAGES[1];
    private Script mouseMovement;

    @Override
    public void init() {
        addSprite(new Sprite(this, image));
        addCollider(new SquareCollider(this));
        mouseMovement = new MouseMovement(this);
        addScript(mouseMovement);
    }
    
    public void visibility(boolean state){
        BufferedImage img = (state) ? image : null;
        removeSprite(getSprites()[0]);
        addSprite(new Sprite(this, img));
    }
    
}
