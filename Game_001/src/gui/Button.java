package gui;

import Components.colliders.SquareCollider;
import java.awt.Color;
import game_objects.Mouse;

public abstract class Button extends Label{
    
    private Mouse mouse;
    
    public Button(String text, Mouse mouse){
        this(text, Color.BLACK, mouse);
    }
    
    public Button(String text, Color color, Mouse mouse){
        this(text, color, 0, 0, mouse);
    }
    
    public Button(String text, Color color, float x, float y, Mouse mouse){
        this(text, color, "Forte", 48, x, y, null, mouse);
    }
        
    public Button(String text, Color color, String fnt, int fntSize, float x, float y, Color color2, Mouse mouse){
        super(text, color, fnt, fntSize, x, y, color2);
        this.mouse = mouse;
    }
    
    public Button(String text, Color color, String fnt, int fntSize, float x, float y, Mouse mouse){
        this(text, color, fnt, fntSize, x, y, null, mouse);
    }
    
    public void click(){
        if (mouse.getColliders()[0].isCollide(this))
            function();
    }
    
    @Override
    public void init(){
        super.init();
        addCollider(new SquareCollider(this));
    }
    
    public abstract void function();

}