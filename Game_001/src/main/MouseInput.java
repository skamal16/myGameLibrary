package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter    {

    Engine engine;
    
    public MouseInput(Engine engine){
        this.engine = engine;
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        engine.mousePressed(me);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        engine.mouseReleased(me);
    }
    
}
