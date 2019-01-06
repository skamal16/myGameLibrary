package game_objects;

import Components.GameObject;
import Components.sprites.Sprite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Circle extends GameObject{
    
    private final int radius;
    private BufferedImage img;

    public Circle(float x, float y, int radius, Color color) {
        super(x, y);
        this.radius = radius;
        img = new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(color);
        g2d.fillOval(0, 0, radius*2, radius*2);
        g2d.dispose();
    }
    
    public void setColor(Color color){
        BufferedImage img = new BufferedImage(radius*2, radius*2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(color);
        g2d.fillOval(0, 0, radius*2, radius*2);
        g2d.dispose();
        removeSprite(this.getSprites()[0]);
        addSprite(new Sprite(this, img));
    }

    @Override
    public void init() {
        addSprite(new Sprite(this, img));
    }
    
}
