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

    public BufferedImage image = null;

    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        x = 100;
        y = 100;
        setMoveSpd(4);
        direction = "down";

    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCat.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCat.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatWalking.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCatWalking1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCat.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCat.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCat.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Assets/Character_Models/player/TabbyCat.png"));
        } catch(IOException e) {
            e.printStackTrace();
        } 
    }
    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || 
           keyH.leftPressed == true || keyH.rightPressed == true) { //key listener and walking check
            
            if(keyH.upPressed == true){
                direction = "up";
                y -= getMoveSpd();
            } else if(keyH.downPressed == true){
                direction = "down";
               y += getMoveSpd();
            } else if(keyH.leftPressed == true){
                direction = "left";
                x -= getMoveSpd();
            } else if(keyH.rightPressed == true){
                direction = "right";
                x += getMoveSpd();
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

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(myX, myY, gp.getTileSize(), gp.getTileSize());

        BufferedImage image = null;

        switch(direction) { //sets direction to input being pressed
        case "up":
            if(spriteNum == 1) {
            image = up1;
            }
            if(spriteNum == 2) {
                image = up2;
            }
        case "down":
            if(spriteNum == 1) {
            image = down1;
            }
            if(spriteNum == 2) {
                image = down2;
            }
        case "left":
            if(spriteNum == 1) {
                image = left1;
            }
            if(spriteNum == 2) {
                image = left2;
            }
        case "right":
            if(spriteNum == 1) {
                image = right1;
            }
            if(spriteNum == 2) {
                image = right2;
            }
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}