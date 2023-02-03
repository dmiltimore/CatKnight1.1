package Entity;
import java.awt.image.BufferedImage;

import Main.GamePanel;
import Main.KeyHandler;
public class Entity {

    GamePanel gp;
    KeyHandler keyH;
    
    public String name = "";

    public int myX;
    public int myY;
    private int myHP;
    private int myAtk;
    private int myDef;
    private int mySpd;
    private int myMoveSpd;
    protected Boolean collision;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    // character status

    public int maxHealth;
    public int currentHealth;
    public boolean alive = true;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    //getters
    public int getX() {
        return myX;
    }
    public int getY() {
        return myY;
    }
    public int getHP() {
        return myHP;
    }
    public int getAtk() {
        return myAtk;
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
        myX = theX;
    }
    public void setY(int theY) {
        myY = theY;
    }
    public void setHP(int theHP) {
        myHP = theHP;
    }
    public void setAtk(int theAtk) {
        myAtk = theAtk;
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
