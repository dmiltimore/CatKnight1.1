package Main;

import java.awt.Color;
import java.text.DecimalFormat; 
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    
    // fonts
    Font Montserrat;
    Font arial_40;

    // images
    BufferedImage playerImage;
    boolean cropped = false;

    // dialogue iamges
    BufferedImage npcImage;
    BufferedImage objImage;

    // name
    public boolean nameBlank = true;
    public boolean enterName = false;

    // messages, dialogue
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public boolean moreDialogue = false;


    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        //arial_80B = new Font("Arial", Font.BOLD, 80);

    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState) {
            // insert play stuff

        }
        if(gp.gameState == gp.pauseState) {

        }
    }

    public void drawPausedScreen() {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.getScreenHeight()/2;

        g2.drawString(text, x, y);
    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.getScreenWidth()/2 - length/2;
        return x;
    }

}
