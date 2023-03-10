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
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/Assets/Maps/Cafe.txt"); // Path to Map

    }
    public void getTileImage() {
        try {
            tile[0] = new Tile(); 
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/grass.png")); //adds grass image to tile array
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/water.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/earth.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResource("/Assets/Tiles/tree.png"));
            tile[4].collision = true;
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResource("/Assets/Tiles/earth.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResource("/Assets/Tiles/WindowTop.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResource("/Assets/Tiles/WindowMid.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResource("/Assets/Tiles/WindowBottom.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResource("/Assets/Tiles/CafeFloor.png"));

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResource("/Assets/Tiles/CafeTablePlain.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResource("/Assets/Tiles/WallBottom.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResource("/Assets/Tiles/WallMiddle.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResource("/Assets/Tiles/CatsRule.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResource("/Assets/Tiles/WallTop.png"));
            tile[14].collision = true;

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResource("/Assets/Tiles/CafePaws.png"));
            tile[15].collision = true;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResource("/Assets/Tiles/Carpet.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResource("/Assets/Tiles/Void.png"));
            tile[17].collision = true;

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResource("/Assets/Tiles/Stairs.png"));

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
        
        int worldCol = 0;
        int worldRow = 0;



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