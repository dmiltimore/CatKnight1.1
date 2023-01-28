package Entity;
import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
    }
    public void setDefaultValues() {
        myX = 100;
        myY = 100;
        setMoveSpd(4);
    }
}