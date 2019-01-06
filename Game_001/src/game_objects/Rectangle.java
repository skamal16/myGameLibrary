package game_objects;

import Components.GameObject;
import Components.colliders.SquareCollider;
import Components.sprites.Sprite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Rectangle extends GameObject{
    
    private final int width, height;
    private BufferedImage img;

    public Rectangle(float x, float y, int width, int height, Color color) {
        this(x, y, width, height, color, null);
    }

    public Rectangle(float x, float y, int width, int height, Color color, GameObject collidables) {
        super(x, y, collidables);
        this.width = width; this.height = height;
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();
    }
    
    public void setColor(Color color){
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(color);
        g2d.fillRect(0, 0, width, height);
        g2d.dispose();
        removeSprite(getSprites()[0]);
        addSprite(new Sprite(this, img));
    }

    @Override
    public void init() {
        addSprite(new Sprite(this, img));
        addCollider(new SquareCollider(this));
    }
    
}
