package Scenes;

import game_objects.Load;
import game_objects.Start;
import gui.Button;
import static main.Game.IMAGES;

public class MainMenu extends Menu{
    
    private final Button start;
    private final Button load;

    public MainMenu() {
        super(IMAGES[0]);
        start = new Start(cursor);
        load = new Load(cursor);
    }

    @Override
    public void init() {
        super.init();
        add(start);
        add(load);
    }
    
}
