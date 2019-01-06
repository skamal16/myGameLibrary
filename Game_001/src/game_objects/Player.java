package game_objects;

import Components.GameObject;
import Components.Script;
import Components.colliders.SquareCollider;
import Components.sprites.Animation;
import Components.sprites.Sprite;
import Scripts.PlayerMovement;
import static main.Game.IMAGES;

public class Player extends GameObject{
    
    private final Animation[] anim;
    private Script playerMovement;
    public GameObject collidables;
    
    public Player(float x, float y, GameObject collidables){
        super(x, y);
        anim = new Animation[]{
            new Animation(IMAGES[2], 150, 6, 200), 
            new Animation(IMAGES[3], 150, 6, 200, true),
            new Animation(IMAGES[4], 150, 1, 1000),
            new Animation(IMAGES[5], 150, 1, 1000),
            new Animation(IMAGES[6], 150, 1, 1000)
        };
        this.collidables = collidables;
    }

    @Override
    public void init() {
        playerMovement = new PlayerMovement(this, collidables);
        addScript(playerMovement);
        addSprite(new Sprite(this, anim));
        addCollider(new SquareCollider(this, 130, 150));
    }
}
