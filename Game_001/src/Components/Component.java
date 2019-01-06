package Components;

public abstract class Component {
    
    private final GameObject gameObject;
    
    public Component(GameObject gameObject){
        this.gameObject = gameObject;
    }
    
    public GameObject getGameObject(){
        return gameObject;
    }
}
