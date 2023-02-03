package Tile;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public int[] mapArray;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[100];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();

    }
    public void getTileImage() {
        try {
            tile[0] = new Tile(); 
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/grass.png")); //adds grass image to tile array
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/water.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/brick.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 22; j++) {
                    int row = i * 34;
                    int col = j * 34;
                    //bricks
                    if (j == 0 || j == 21) {
                        g2.drawImage(tile[2].image, row, col, gp.tileSize, gp.tileSize, null);
                    }
                    if (i == 0 || i == 29) {
                        g2.drawImage(tile[2].image, row, col, gp.tileSize, gp.tileSize, null);
                    }

                    //grass
                    if (i > 0 && i < 29 && j < 21 && j > 0) {
                        g2.drawImage(tile[0].image, row, col, gp.tileSize, gp.tileSize, null);
                    }

                    //water
                    if (i > 10 && i < 20 && j > 8 && j < 14) {
                        g2.drawImage(tile[1].image, row, col, gp.tileSize, gp.tileSize, null);
                    }
                }
            }
        
        

        
     }
}
