package Components.colliders;

import Components.Component;
import Components.GameObject;

public abstract class Collider extends Component{
    
    public Collider(GameObject gameObject){
        super(gameObject);
    }
    
    public boolean isCollide(GameObject[] gameObjects){
        for (GameObject go : gameObjects) {
            if(isCollide(go))
                return true;
            if(go.getChildren() != null)
                isCollide(go.getChildren());
        }
        return false;
    }
    
    public boolean isCollide(GameObject go){
        
        Collider col = go.getColliders()[0];
        
        if(col instanceof SquareCollider && this instanceof SquareCollider){
            SquareCollider sc = (SquareCollider)col;
            SquareCollider sc2 = (SquareCollider)this;
            return squareCollide(sc, sc2);
        }else if(col instanceof CircleCollider && this instanceof CircleCollider){
            CircleCollider cc = (CircleCollider)col;
            CircleCollider cc2 = (CircleCollider)this;
            return circleCollide(cc, cc2);
        }
        
        return false;
    }
    
    private static boolean circleCollide(CircleCollider cc, CircleCollider cc2){
        float[] pos1 = cc.getGameObject().transform.getPosition();
        float[] pos2 = cc2.getGameObject().transform.getPosition();
        float centerX1 = pos1[0] + cc.radius, centerY1 = pos1[1] + cc.radius;
        float centerX2 = pos2[0] + cc2.radius, centerY2 = pos2[1]+ cc2.radius;
        
        System.out.println(getDistance(centerX1, centerY1, centerX2, centerY2));
        
        return getDistance(centerX1, centerY1, centerX2, centerY2) < cc.radius + cc2.radius;
    }
    
    private static float getDistance(float x1, float y1, float x2, float y2){
        float xDistance = x2 - x1;
        float yDistance = y2 - y1;
        
        return (float) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }
    
    private static boolean squareCollide(SquareCollider sc, SquareCollider sc2){
        float[] pos1 = sc.getGameObject().transform.getPosition();
        float[] pos2 = sc2.getGameObject().transform.getPosition();
        float[] size1 = {sc.width, sc.height};
        float[] size2 = {sc2.width, sc2.height};
        
        return squareCollide(pos1, pos2, size1, size2);
    }
    
    public boolean squareCollide(float[] pos, GameObject[] gameObjects){
        for(GameObject go : gameObjects){
            if (squareCollide(pos, go))
                return true;
            if (go.getChildren() != null)
                squareCollide(pos, go.getChildren());
        }
        return false;
    }
    
    public boolean squareCollide(float[] pos, GameObject go){
        if (go.getColliders() != null)
            if(squareCollide(pos, (SquareCollider) go.getColliders()[0]))
                return true;
        if (go.getChildren() != null)
            if(squareCollide(pos, go.getChildren()))
                return true;
        return false;
    }
    
    private boolean squareCollide(float[] pos, SquareCollider sc){
        float[] pos2 = sc.getGameObject().transform.getPosition();
        SquareCollider sc2 = (SquareCollider) this;
        float[] size2 = {sc.width, sc.height};
        float[] size1 = {sc2.width, sc2.height};
        
        return squareCollide(pos, pos2, size1, size2);
    }
    
    private static boolean squareCollide(float[] pos1, float[] pos2, float[] size1, float[] size2){
        float[][] collider1 = {pos1, {pos1[0] + size1[0], pos1[1] + size1[1]}};
        float[][] collider2 = {pos2, {pos2[0] + size2[0], pos2[1] + size2[1]}};
        boolean xCross = rangeIntersect(collider1[0][0], collider1[1][0], collider2[0][0], collider2[1][0]);
        boolean yCross = rangeIntersect(collider1[0][1], collider1[1][1], collider2[0][1], collider2[1][1]);
        
        return xCross && yCross;
    }
    
    private static boolean rangeIntersect(float min0, float max0, float min1, float max1){
        return Math.max(min0, max0) >= Math.min(min1, max1) &&
                Math.min(min0, max0) <= Math.max(min1, max1);
    }

    
}
