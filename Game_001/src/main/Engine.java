package main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public abstract class Engine extends Canvas implements Runnable
{
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static int SCALE = 2;
    public String TITLE = "Main";
    private boolean running = false;
    private Thread thread;
    private final BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    
    Engine(String title, int scale){
        TITLE = title;
        SCALE = scale;
    }
    
    public void init(){
        this.requestFocus();
        addKeyListener(new KeyInput(this));
        addMouseListener(new MouseInput(this));
    }
    
    public synchronized void start()
    {
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop()
    {
        if(!running)
            return;
        
        running = false;
        try
        {
            thread.join();
        } 
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.exit(1);
        
    }
    
    @Override
    public void run()
    {
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            
            handleGraphics();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    public abstract void mousePressed(MouseEvent me);
    
    public abstract void mouseReleased(MouseEvent me);
    
    public abstract void keyPressed(KeyEvent e);
    
    public abstract void keyReleased(KeyEvent e);
    
    public abstract void tick();
    
    public void handleGraphics(){
        
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //////////////////////////
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        render(g);
        
        //////////////////////////
        g.dispose();
        bs.show();
        
    }
    
    public abstract void render(Graphics g);
}