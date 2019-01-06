package Components.colliders;

import Components.GameObject;

public class SquareCollider extends Collider{
    
    public float width, height;
    
    public SquareCollider(GameObject go){
        this(go, go.getSprites()[0].getImage().getWidth(), go.getSprites()[0].getImage().getHeight());
    }
    
    public SquareCollider(GameObject go, float width, float height){
        super(go);
        this.width = width;
        this.height = height;
    }

}
