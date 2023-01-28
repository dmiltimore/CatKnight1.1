package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    //Screeen Settings
    final private int originalTileSize = 16; //16 x 16 tile
    final private int scale = 3;
    
    final private int tileSize = originalTileSize * scale; //48 x 48
    final private int maxScreenCol = 16;
    final private int maxScreenRow = 12;
    final private int screenWidth = tileSize * maxScreenCol; //768 pixels
    final private int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));    
        this.setBackground(Color.black);    
        this.setDoubleBuffered(true);


    }
    //getters
    
    //setters
}
