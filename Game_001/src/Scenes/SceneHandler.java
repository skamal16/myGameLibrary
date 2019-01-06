package Scenes;

import java.awt.Graphics;

public class SceneHandler {
    private static final Scene MAINMENU = new MainMenu(), PAUSEMENU = new PauseMenu();
    private static final Scene[] LEVELS = {new Level_1(), new Level_2()};
    private static Scene activeScene = MAINMENU;
    
    public void tick(){
        activeScene.tick();
    }
    
    public void render(Graphics g){
        activeScene.render(g);
    }
    
    public static void sceneChange(int x){
        switch(x){
            case -1:
                activeScene = MAINMENU;
                break;
            case 0:
                activeScene = PAUSEMENU;
                break;
            default:
                activeScene = LEVELS[x - 1];
                break;
        }
    }
    
}
