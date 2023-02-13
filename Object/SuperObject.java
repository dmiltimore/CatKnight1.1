package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import Main.GamePanel;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidaAreaDefaultY = 0;


    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY; // camera error my be due to wrong x
        

        if(worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX &&
           worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX &&
           worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY &&
           worldY - gp.getTileSize() < gp.player.worldY + gp.player.screenY){

                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }
    }

}
