package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Rectangle;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    int hasKey = 0;

    //public BufferedImage image = null;

    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.getScreenWidth()/2 - (gp.tileSize/2);
        screenY = gp.getScreenHeight()/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 10;
        solidAreaDefaultX = solidArea.x;
        solidaAreaDefaultY = solidArea.y;
        solidArea.width = 16;
        solidArea.height = 16;


        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        setMoveSpd(4);
        direction = "down";

    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatUp.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatUp1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatDown.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatDown1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatLeft.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatLeft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatRight.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatRight2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        } 
    }
    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || 
           keyH.leftPressed == true || keyH.rightPressed == true) { //key listener and walking check
            
            if(keyH.upPressed == true){
                direction = "up";
            } else if(keyH.downPressed == true){
                direction = "down";
            } else if(keyH.leftPressed == true){
                direction = "left";
            } else if(keyH.rightPressed == true){
                direction = "right";
            } 

            // check tile collision 
            collisionOn = false;
            gp.cChecker.checkTile(this);

            int objectIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objectIndex);

            // if collision is false player can move
            if(collisionOn == false) {
                switch(direction) {
                    case "up": worldY -= getMoveSpd(); break;
                    case "down": worldY += getMoveSpd(); break;
                    case "left":  worldX -= getMoveSpd(); break;
                    case "right": worldX += getMoveSpd(); break;
                }
            }
            
            spriteCounter++;
            if(spriteCounter > 10) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if(spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
 
        }
        
    }
    public void pickUpObject(int i) {
        if(i != 999) {
            String objectName = gp.object[i].name;
            switch(objectName) {
                case "Potion":
                    hasKey++;
                    gp.object[i] = null;
                    System.out.println("Key: " + hasKey);
                    break;
                case "Lantern":
                    hasKey++;
                    gp.object[i] = null;
                    System.out.println("Lantern: " + hasKey);
                    break;
                case "Coin":
                    hasKey++;
                    gp.object[i] = null;
                    System.out.println("Lantern: " + hasKey);
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
    

        BufferedImage image = null;

        switch(direction) { //sets direction to input being pressed
        case "up":
            if(spriteNum == 1) {
            image = up1;
            }
            if(spriteNum == 2) {
                image = up2;
            }
            break;
        case "down":
            if(spriteNum == 1) {
            image = down1;
            }
            if(spriteNum == 2) {
                image = down2;
            }
            break;
        case "left":
            if(spriteNum == 1) {
                image = left1;
            }
            if(spriteNum == 2) {
                image = left2;
            }
            break;
        case "right":
            if(spriteNum == 1) {
                image = right1;
            }
            if(spriteNum == 2) {
                image = right2;
            }
            break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}