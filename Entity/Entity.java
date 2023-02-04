package Entity;
import java.awt.image.BufferedImage;

import Main.GamePanel;
import Main.KeyHandler;
public class Entity {

    GamePanel gp;
    KeyHandler keyH;
    
    public String name = "";

    public int x, y;
  
    private int myDef;
    private int mySpd;
    private int myMoveSpd;
  
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;


    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    //getters
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getDef() {
        return myDef;
    }
    public int getSpd() {
        return mySpd;
    }
    public int getMoveSpd() {
        return myMoveSpd;
    }
    //setters
    public void setX(int theX) {
        x = theX;
    }
    public void setY(int theY) {
        y = theY;
    }

    public void setDef(int theDef) {
        myDef = theDef;
    }
    public void setSpd(int theSpd) {
        mySpd = theSpd;
    }
    public void setMoveSpd(int theMoveSpd) {
        myMoveSpd = theMoveSpd;
    }
}
