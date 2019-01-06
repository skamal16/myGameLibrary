package Scenes;

import java.awt.image.BufferedImage;

public abstract class Level extends Scene{
    
    private final int tag;
    
    public Level(BufferedImage image, int tag) {
        super(image);
        this.tag = tag;
    }
    
    public Level(int tag){
        super();
        this.tag = tag;
    }
    
    public void endLevel(){
        SceneHandler.sceneChange(tag + 1);
    }
}
