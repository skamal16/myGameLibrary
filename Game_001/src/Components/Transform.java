package Components;

public class Transform {
    
    private float[] position;
    private float rotation;
    private float[] scale;
    
    public Transform(float x, float y, float rotation, float scaleX, float scaleY){
        position = new float[] {x, y};
        this.rotation = rotation;
        scale = new float[] {scaleX, scaleY};
    }
    
    public Transform(){
        this(0, 0, 0, 1, 1);
    }

    public float[] getPosition() {
        return position;
    }

    public float getRotation() {
        return rotation;
    }

    public float[] getScale() {
        return scale;
    }

    public void setPosition(float[] position) {
        this.position = position;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void setScale(float[] scale) {
        this.scale = scale;
    }
    
}
