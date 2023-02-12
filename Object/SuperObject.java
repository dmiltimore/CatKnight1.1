package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.GamePanel;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

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
