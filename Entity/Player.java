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
    public void update() {
        if(keyH.upPressed == true){
            myY -= getMoveSpd();
        }
        else if(keyH.downPressed == true){
            myY += getMoveSpd();
        }
        else if(keyH.leftPressed == true){
            myX -= getMoveSpd();

        }
        else if(keyH.rightPressed == true){
            myX += getMoveSpd();
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        g2.fillRect(myX, myY, gp.getTileSize(), gp.getTileSize());
    }
}