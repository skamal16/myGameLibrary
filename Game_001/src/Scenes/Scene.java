package Scenes;

import gui.Label;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.BackGround;
import static main.Engine.HEIGHT;
import static main.Engine.WIDTH;

public abstract class Scene {
    
    public BackGround BG;
    public static Label[] labels = new Label[0];
    private boolean running = false;
    
    Scene(BufferedImage image){
        BG = new BackGround(image);
    }
    
    Scene(){
        BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        g2d.setColor(Color.WHITE);
        g2d.dispose();
        BG = new BackGround(img);
    }
    
    public void add(Label label) {
        Label[] temp = new Label[labels.length + 1];
        System.arraycopy(labels, 0, temp, 0, labels.length);
        temp[labels.length] = label;
        labels = temp;
    }
    
    public void tick(){
        if(!running){
            BG.init();
            init();
            for(Label i : labels)
                i.init();
            running = true;
        }
        update();
    }
    
    public abstract void init();
    
    public abstract void update();
    
    public void render(Graphics g){
        BG.render(g);
        for (Label i : labels) {
            i.render(g);
        }
    }
}
