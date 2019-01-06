package Scripts;

import Components.GameObject;
import Components.Script;
import Components.sprites.Sprite;
import game_objects.Player;
import static main.InputHandler.HORIZONTAL_AXIS;
import static main.InputHandler.JUMP;

public class PlayerMovement extends Script{
    
    private final Player player;
    private float dx;
    private float dy;
    private final float speed = 2, jumpForce = 40, drag = 0.1f, gravity = 2f, max_speed = 8;
    private final int cooldown = 5;
    private int clock = 0;
    
    public PlayerMovement(Player player, GameObject collidables){
        this.player = player;
    }

    @Override
    public void init() {
        dx = 0;
        dy = 0;
    }

    @Override
    public void update() {
        movement();
        anim();
    }
    
    private void anim(){
        Sprite sprt = player.getSprites()[0];
        if (HORIZONTAL_AXIS == 1 && sprt.getAnimation() != sprt.getAnimation(0)) {
            sprt.playAnimation(0);
            System.out.println("run right");
        } else if (HORIZONTAL_AXIS == -1 && sprt.getAnimation() != sprt.getAnimation(1)) {
            sprt.playAnimation(1);
            System.out.println("run left");
        } else if(HORIZONTAL_AXIS == 0){
            if (dx < 0.5 && dx > -0.5 && sprt.getAnimation() != sprt.getAnimation(2)) {
                sprt.playAnimation(2);
                System.out.println("idle");
            } else if(dx > 0.5 && sprt.getAnimation() != sprt.getAnimation(3)){
                sprt.playAnimation(3);
                System.out.println("halt_right");
            } else if(dx < -0.5 && sprt.getAnimation() != sprt.getAnimation(4)){
                sprt.playAnimation(4);
                System.out.println("halt_left");
            }
        }
    }
    
    private void movement(){
        clock++;
        
        float jump;
        if (clock > cooldown * 10){
            jump = jumpForce;
            if(JUMP == 1)
                clock = 0;
        }else
            jump = 0;
        
        dy += JUMP * -jump + gravity;
        dx += speed * HORIZONTAL_AXIS + -dx*drag;
        
        if(dx >= max_speed)
            dx = max_speed;
        else if(dx <= -max_speed)
            dx = -max_speed;
        else if(dx < 0.5 && dx > -0.5)
            dx = 0;
        
        float[] pos = player.transform.getPosition();
        float[] posx = {pos[0] + dx, pos[1]};
        
        if (!player.getColliders()[0].squareCollide(posx, player.collidables))
            player.transform.setPosition(posx);
        
        float[] posy = {player.transform.getPosition()[0], pos[1] + dy};
        
        if (!player.getColliders()[0].squareCollide(posy, player.collidables))
            player.transform.setPosition(posy);
        
        if(pos[1] == player.transform.getPosition()[1])
            dy = 0;
    }
    
}
