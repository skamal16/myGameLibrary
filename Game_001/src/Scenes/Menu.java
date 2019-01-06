package Scenes;

import gui.Button;
import gui.Label;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import game_objects.Mouse;

public abstract class Menu extends Scene{
    
    public Mouse cursor;

    public Menu(BufferedImage image) {
        super(image);
        cursor = new Mouse();
    }
    
    @Override
    public void init(){
        cursor.init();
    }
    
    @Override
    public void update(){
        cursor.update();
    }
    
    @Override
    public void render(Graphics g){
        super.render(g);
        cursor.render(g);
    }
    
    public static void click(){
        for(Label i : labels)
                    if (i instanceof Button){
                        Button b = (Button) i;
                        b.click();
                    }
    }
    
}
