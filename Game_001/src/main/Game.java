package main;

import Scenes.SceneHandler;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Game extends Engine
{
    public static BufferedImage[] IMAGES;
    SceneHandler sceneHandler;
    InputHandler inputHandler;
    
    Game(String title, int scale){
        super(title, scale);
        ImageLoader loader = new ImageLoader();
        IMAGES = loader.load();
        sceneHandler = new SceneHandler();
        inputHandler = new InputHandler();
    }
    
    @Override
    public void tick(){
        sceneHandler.tick();
    }
    
    @Override
    public void render(Graphics g){
        
        sceneHandler.render(g);
        
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        inputHandler.mousePressed(me);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        inputHandler.mouseReleased(me);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        inputHandler.keyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        inputHandler.keyReleased(e);
    }
    
    public static void main(String args[])
    {
        Game game = new Game("Game_001", 1);
        
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        JFrame frame = new JFrame(game.TITLE);
        
        frame.add(game);
        frame.setUndecorated(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        frame.setCursor(blankCursor);
        frame.setVisible(true);
        
        game.start();
    }
}