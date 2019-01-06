package Components.sprites;

import java.awt.image.BufferedImage;

public class Animation {
    
    private final BufferedImage spriteSheet;
    
    private int frame;
    private final int totalFrames;
    private final int size;
    private int index = 0;
    private final int speed;
    private final boolean invert;
    
    public Animation(BufferedImage spriteSheet, int size, int totalFrames, int speed, boolean invert){
        this.spriteSheet = spriteSheet;
        this.size = size;
        this.totalFrames = totalFrames;
        this.speed = speed;
        this.invert = invert;
        frame = (invert) ? totalFrames : 1;
    }
    
    public Animation(BufferedImage spriteSheet, int size, int totalFrames, int speed){
        this(spriteSheet, size, totalFrames, speed, false);
    }
    
    private BufferedImage grabImage(int x, int y){
        BufferedImage img = spriteSheet.getSubimage((x * size) - size, (y * size) - size, size, size);
        return img;
    }
    
    public BufferedImage playAnimation(){
        BufferedImage img = grabImage(frame, 1);
        update();
        return img;
    }
    
    private void update(){
        index++;
        if(index > speed){
            index = 0;
            if(!invert)
                if (frame < totalFrames) {
                    frame++;
                } else {
                    frame = 1;
                }
            else
                if (frame > 1) {
                    frame--;
                } else {
                    frame = totalFrames;
                }
        }
    }
    
    public void reset(){
        frame = 1;
    }
}
