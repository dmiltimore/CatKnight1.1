package Main;

import Object.ObjectCoin;
import Object.ObjectLantern;
import Object.ObjectPotion;


public class AssestSetter {
    GamePanel gp;
    public AssestSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.object[0] = new ObjectPotion();
        gp.object[0].worldX = 23 * gp.tileSize;
        gp.object[0].worldY = 7 * gp.tileSize;

        gp.object[1] = new ObjectPotion();
        gp.object[1].worldX = 23 * gp.tileSize;
        gp.object[1].worldY = 40 * gp.tileSize;

        gp.object[2] = new ObjectLantern();
        gp.object[2].worldX = 37 * gp.tileSize;
        gp.object[2].worldY = 7 * gp.tileSize;

        gp.object[3] = new ObjectLantern();
        gp.object[3].worldX = 10 * gp.tileSize;
        gp.object[3].worldY = 9 * gp.tileSize;

        gp.object[4] = new ObjectCoin();
        gp.object[4].worldX = 8 * gp.tileSize;
        gp.object[4].worldY = 28 * gp.tileSize;

        gp.object[5] = new ObjectCoin();
        gp.object[5].worldX = 12 * gp.tileSize;
        gp.object[5].worldY = 22 * gp.tileSize;

    }
}
