package Components.colliders;

public class ColliderGroup {
    
    private Collider[] colliders = new Collider[0];
    
    public void addCollider(Collider col){
        Collider[] temp = new Collider[colliders.length + 1];
        System.arraycopy(colliders, 0, temp, 0, colliders.length);
        temp[colliders.length] = col;
        colliders = temp;
    }
    
    public void removeCollider(Collider col){
        Collider[] temp = new Collider[colliders.length - 1];
        int i = 0;
        while(i < colliders.length){
            if (colliders[i].equals(col))
                break;
            i++;
        }
        
        System.arraycopy(colliders, 0, temp, 0, i);
        System.arraycopy(colliders, i + 1, temp, i, temp.length);
        
        colliders = temp;
    }

    public Collider[] getColliders() {
        return colliders;
    }
    
}
