package Entity;

import java.security.Key;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import Main.GamePanel;
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler theKeyH) {
        this.gp = gp;
        this.keyH = theKeyH;
    }
    public void setDefaultValues() {
        
    }

}