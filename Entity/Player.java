package Entity;
<<<<<<< HEAD
import Main.GamePanel;
import Main.KeyHandler;
=======

import main.GamePanel;
import main.KeyHandler;

>>>>>>> e6ffbfdcc213637fd434e4cef9f5977b945563eb
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