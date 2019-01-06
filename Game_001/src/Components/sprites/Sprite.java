package Components.sprites;

import Components.GameObject;
import Components.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite extends Component{
    
    private BufferedImage image;
    private Animation[] anim;
    private Animation currentAnim;

    public BufferedImage getImage() {
        if (image != null)
            return image;
        else if (currentAnim != null)
            return currentAnim.playAnimation();
        else
            return null;
    }
    
    public Sprite(GameObject gameObject, BufferedImage image){
        super(gameObject);
        this.image = image;
    }
    
    public Sprite(GameObject gameObject, Animation[] anim){
        super(gameObject);
        this.anim = anim;
        currentAnim = anim[0];
    }
    
    private void draw(Graphics g, BufferedImage image){
        g.drawImage(image, (int)getGameObject().transform.getPosition()[0], (int)getGameObject().transform.getPosition()[1], null);
    }
    
    public void playAnimation(int animation){
        currentAnim = anim[animation];
        currentAnim.reset();
    }
    
    public Animation getAnimation(){
        return currentAnim;
    }
    
    public Animation getAnimation(int animation){
        return anim[animation];
    }
    
    public void render(Graphics g){
        if(image != null)
            draw(g, image);
        if(anim != null)
            draw(g, currentAnim.playAnimation());
    }
    
}
