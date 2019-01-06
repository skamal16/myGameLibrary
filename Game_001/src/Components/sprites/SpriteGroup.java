package Components.sprites;

import java.awt.Graphics;

public class SpriteGroup {
    
    private Sprite[] sprites = new Sprite[0];
    
    public void addSprite(Sprite sprt){
        Sprite[] temp = new Sprite[sprites.length + 1];
        System.arraycopy(sprites, 0, temp, 0, sprites.length);
        temp[sprites.length] = sprt;
        sprites = temp;
    }
    
    public void removeSprite(Sprite sprt){
        Sprite[] temp = new Sprite[sprites.length - 1];
        int i = 0;
        while(i < sprites.length){
            if (sprites[i].equals(sprt))
                break;
            i++;
        }
        
        System.arraycopy(sprites, 0, temp, 0, i);
        System.arraycopy(sprites, i + 1, temp, i, temp.length);
        
        sprites = temp;
    }
    
    public Sprite[] getSprites(){
        return sprites;
    }
    
    public void render(Graphics g){
        for (Sprite sprite : sprites)
            if (sprite != null)
                sprite.render(g);
    }
    
}
