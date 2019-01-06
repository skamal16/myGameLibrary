package gui;

import Components.GameObject;
import Components.sprites.Sprite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class Label extends GameObject{

    private BufferedImage img;
    private BufferedImage img2;
    
    public Label(String text){
        this(text, Color.BLACK);
    }
    
    public Label(String text, Color color){
        this(text, color, 0, 0);
    }
    
    public Label(String text, Color color, float x, float y){
        this(text, color, "Forte", 48, x, y, null);
    }
        
    public Label(String text, Color color, String fnt, int fntSize, float x, float y, Color color2){
        super(x, y);
        
        img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font(fnt, Font.PLAIN, fntSize);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(color);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();
        
        if(color2 != null){
            img2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            g2d = img2.createGraphics();
            g2d.setColor(color2);
            g2d.fillRect(0, 0, width, height);
            g2d.dispose();
        }
    }

    @Override
    public void init() {
        if(img2 != null)
            addSprite(new Sprite(this, img2));
        addSprite(new Sprite(this, img));
    }

}