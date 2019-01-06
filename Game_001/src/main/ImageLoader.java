package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    
    private final BufferedImage[] images = new BufferedImage[10];
    
    public BufferedImage[] load(){
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            images[0] = loader.loadImage("/starry_bg_1080.png");
            images[1] = loader.loadImage("/red-glass-cursor.png");
            images[2] = loader.loadImage("/run_right.png");
            images[3] = loader.loadImage("/run_left.png");
            images[4] = loader.loadImage("/idle.png");
            images[5] = loader.loadImage("/halt_right.png");
            images[6] = loader.loadImage("/halt_left.png");
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return images;
        
    }
    
}
