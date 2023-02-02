package Entity;

import Main.GamePanel;
import Main.KeyHandler;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.getScreenWidth()/2 - (gp.tileSize/2);
        screenY = gp.getScreenHeight()/2 - (gp.tileSize/2);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        myX = 100;
        myY = 100;
        setMoveSpd(4);
        direction = "down";
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/up.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/down.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/left.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/right.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/right2.png"));
        } catch(IOException e) {
            e.printStackTrace();
        } 
    }
    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || 
            keyH.leftPressed == true || keyH.rightPressed == true) { //key listener and walking check
            if(keyH.upPressed == true){
                direction = "up";
                myY -= getMoveSpd();
            } else if(keyH.downPressed == true){
                direction = "down";
               myY += getMoveSpd();
            } else if(keyH.leftPressed == true){
                direction = "left";
                myX -= getMoveSpd();
            } else if(keyH.rightPressed == true){
                direction = "right";
                myX += getMoveSpd();
            }   
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(myX, myY, gp.getTileSize(), gp.getTileSize());

        BufferedImage image = null;

        switch(direction) { //sets direction to input being pressed
        case "up":
            if (spriteNum == 1) {
                image = up1;
            }
            if (spriteNum == 2) {
                image = up2;
            }
            break;
        case "down":
            if (spriteNum == 1) {
                image = down1;
            }
            if (spriteNum == 2) {
                image = down2;
            }
            break;
        case "left":
            if (spriteNum == 1) {
                image = left1;
            }
            if (spriteNum == 2) {
                image = left2;
            }
            break;
        case "right":
            if (spriteNum == 1) {
                image = right1;
            }
            if (spriteNum == 2) {
                image = right2;
            }
            break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}