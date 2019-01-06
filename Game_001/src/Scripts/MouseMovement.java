package Scripts;

import Components.Script;
import game_objects.Mouse;
import java.awt.MouseInfo;
import java.awt.Point;

public class MouseMovement extends Script{
    
    private final Mouse mouse;
    private Point pointer;
    
    public MouseMovement(Mouse mouse){
        this.mouse = mouse;
    }

    @Override
    public void init() {
        
    }

    @Override
    public void update() {
        pointer = MouseInfo.getPointerInfo().getLocation();
        mouse.transform.setPosition(new float[]{(float)pointer.getX(), (float)pointer.getY()});
    }
    
}
