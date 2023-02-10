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
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

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
<<<<<<< HEAD
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Assets/Tiles/dirt.png"));
=======
            tile[3].image = ImageIO.read(getClass().getResource("/Assets/Tiles/dirt.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResource("/Assets/Tiles/sand.png"));

            
>>>>>>> 3d7c80503ae1ae876ce4633c7577277d93910f5d
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
            while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();

                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){

        }
    }
    
    
    public void draw(Graphics2D g2) {
        
        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
     }
}
