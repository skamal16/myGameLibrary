package Scenes;

import Components.GameObject;
import game_objects.Empty;
import gui.Label;
import game_objects.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import game_objects.Mouse;
import game_objects.Player;
import static main.Engine.HEIGHT;
import static main.Engine.WIDTH;

public class Level_1 extends Level{
    
    private final Label title;
    
    private final Player player;
    
    private final Rectangle r1;
    private final Rectangle r2;
    
    private final Rectangle ground;
    
    public GameObject collidables;
    
    private final Mouse mouse;
    
    public Level_1() {
        super(1);
        title = new Label("Level 1", Color.BLACK, 50, 50);
        
        collidables = new Empty();
        
        player = new Player(100, 800, collidables);
        
        mouse = new Mouse();
        
        ground = new Rectangle(0, 1000, (int)(WIDTH * 1.5), HEIGHT - 1000, Color.GRAY, collidables);

        r1 = new Rectangle(900, 500, 200, 100, Color.BLACK);
        r2 = new Rectangle(0, 0, 50, 50, Color.RED);
    }
    
    public void checkCollision(){
        if(r1.getColliders()[0].isCollide(r2))
            r1.setColor(Color.RED);
        else
            r1.setColor(Color.BLACK);
    }
    
    @Override
    public void render(Graphics g){
        super.render(g);
        player.render(g);
        mouse.render(g);
        collidables.render(g);
        r1.render(g);
        r2.render(g);
    }

    @Override
    public void init() {
        collidables.addChild(ground);
        player.init();
        mouse.init();
        collidables.init();
        r1.init();
        r2.init();
        r2.transform.setPosition(mouse.transform.getPosition());
        mouse.visibility(false);
        add(title);
    }

    @Override
    public void update() {
        player.update();
        r2.transform.setPosition(mouse.transform.getPosition());
        mouse.update();
        checkCollision();
    }
    
}
