package Tile;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import java.awt.Graphics2D;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[100];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/Assets/Maps/StageOne.txt"); // Path to Map

    }
    public void getTileImage() {
        try {
            tile[0] = new Tile(); 
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/grass.png")); //adds grass image to tile array
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/water.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/tree.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResource("/Assets/Tiles/dirt.png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void loadMap(String theFilePath) {
        
        try{
            InputStream is = getClass().getResourceAsStream(theFilePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }
    
    
    public void draw(Graphics2D g2) {
        
        int worldRow = 0;
        int worldCol = 0;



        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.getTileSize();
            int worldY = worldRow * gp.getTileSize();
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY; // camera error my be due to wrong x
            
            if(worldX + gp.getTileSize() > gp.player.worldX - gp.player.screenX &&
               worldX - gp.getTileSize() < gp.player.worldX + gp.player.screenX &&
               worldY + gp.getTileSize() > gp.player.worldY - gp.player.screenY &&
               worldY - gp.getTileSize() < gp.player.worldY + gp.player.screenY){

                    g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

                }
           
            worldCol++;

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }
        }
     }
}