package Components.colliders;

import Components.GameObject;

public class CircleCollider extends Collider{
    
    public float radius;
    
    public CircleCollider(GameObject go){
        super(go);
        this.radius = go.getSprites()[0].getImage().getWidth();
    }
    
}