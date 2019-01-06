package Components;

import Components.colliders.Collider;
import Components.colliders.ColliderGroup;
import Components.sprites.Sprite;
import Components.sprites.SpriteGroup;
import java.awt.Graphics;

public abstract class GameObject {
    
    public Transform transform = new Transform();
    private Component[] components;
    private Script[] scripts;
    private GameObject[] children;
    private GameObject parent;
    private SpriteGroup spriteGroup;
    private ColliderGroup colliderGroup;
    
    public GameObject(){
        this(0, 0, null);
    }
    
    public GameObject(float x, float y){
        this(x, y, null);
    }
    
    public GameObject(float x, float y, GameObject parent){
        scripts = new Script[0];
        components = new Component[0];
        children = new GameObject[0];
        transform.setPosition(new float[]{x, y});
        this.parent = parent;
    }
    
    public GameObject(GameObject parent){
        this(0, 0, parent);
    }
    
    public void removeSprite(Sprite sprite){
        spriteGroup.removeSprite(sprite);
        removeComponent(sprite);
    }
    
    public void removeCollider(Collider collider){
        colliderGroup.removeCollider(collider);
        removeComponent(collider);
    }
    
    public GameObject[] getChildren(){
        return children;
    }
    
    public void init(){
        for(GameObject go : children)
                go.init();
            for(Script sc : scripts)
                sc.init();
    };
    
    public void update(){
        for (GameObject go : children) {
            go.update();
        }
        for(Script sc : scripts)
            sc.update();
    }
    
    public GameObject getParent(){
        return parent;
    }
    
    public void addChild(GameObject child){
        GameObject[] temp = new GameObject[children.length + 1];
        System.arraycopy(children, 0, temp, 0, children.length);
        temp[children.length] = child;
        children = temp;
    }
    
    public Collider[] getColliders(){
        if(colliderGroup == null)
            return null;
        return colliderGroup.getColliders();
    }
    
    public Sprite[] getSprites(){
        return spriteGroup.getSprites();
    }
    
    public void addScript(Script script){
        Script[] temp = new Script[scripts.length + 1];
        System.arraycopy(scripts, 0, temp, 0, scripts.length);
        temp[scripts.length] = script;
        scripts = temp;
    }
    
    public void addSprite(Sprite sprite){
        if (spriteGroup == null)
            spriteGroup = new SpriteGroup();
        spriteGroup.addSprite(sprite);
        addComponent(sprite);
    }
    
    public void addCollider(Collider collider){
        if (colliderGroup == null)
            colliderGroup = new ColliderGroup();
        colliderGroup.addCollider(collider);
        addComponent(collider);
    }
    
    public void render(Graphics g){
        if(spriteGroup != null)
            spriteGroup.render(g);
        for (GameObject go : children)
            go.render(g);
    }
    
    private void removeComponent(Component c){
        Component[] temp = new Component[components.length - 1];
        int i = 0;
        while(i < components.length){
            if (components[i].equals(c))
                break;
            i++;
        }
        
        System.arraycopy(components, 0, temp, 0, i);
        if(i != components.length - 1)
            System.arraycopy(components, i + 1, temp, i, temp.length);
        
        components = temp;
    }

    private void addComponent(Component component) {
        Component[] temp = new Component[components.length + 1];
        System.arraycopy(components, 0, temp, 0, components.length);
        temp[components.length] = component;
        components = temp;
    }
}