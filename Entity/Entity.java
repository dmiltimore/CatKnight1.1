package Entity;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

import Main.GamePanel;
import Main.KeyHandler;
public class Entity {

    GamePanel gp;
    KeyHandler keyH;
    

    public int worldX, worldY;
  
    private int myDef;
    private int mySpd;
    private int myMoveSpd;
  
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidaAreaDefaultY;
    public boolean collisionOn = false;


    public Entity(GamePanel gp) {
        this.gp = gp;
    }
    //getters
    public int getX() {
        return worldX;
    }
    public int getY() {
        return worldY;
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
        worldX = theX;
    }
    public void setY(int theY) {
        worldY = theY;
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
