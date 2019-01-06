package Scenes;

import gui.Label;
import game_objects.Circle;
import java.awt.Color;
import java.awt.Graphics;
import game_objects.Mouse;

public class Level_2 extends Level{
    
    private final Label title;
    
    Circle c2;
    Circle c1;
    
    Mouse mouse;
    
    public Level_2() {
        super(2);
        title = new Label("Level 2", Color.BLACK, 50, 50);
        mouse = new Mouse();
        c1 = new Circle(800, 500, 200, Color.BLACK);
        c2 = new Circle(0, 0, 50, Color.RED);
    }
    
    public void checkCollision(){
        if(c1.getColliders()[0].isCollide(c2))
            c1.setColor(Color.RED);
        else
            c1.setColor(Color.BLACK);
    }
    
    @Override
    public void render(Graphics g){
        super.render(g);
        mouse.render(g);
        c1.render(g);
        c2.render(g);
    }

    @Override
    public void init() {
        mouse.init();
        c1.init();
        c2.init();
        c2.transform.setPosition(mouse.transform.getPosition());
        mouse.visibility(false);
        add(title);
    }

    @Override
    public void update() {
        c2.transform.setPosition(mouse.transform.getPosition());
        mouse.update();
        checkCollision();
    }
    
}
