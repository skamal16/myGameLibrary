package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
    
    Engine engine;
    
    public KeyInput(Engine engine){
        this.engine = engine;
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        engine.keyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        engine.keyReleased(e);
    }
    
}
