package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    //Screeen Settings
    final  int originalTileSize = 16; //16 x 16 tile
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; //48 x 48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));    
        this.setBackground(Color.black);    
        this.setDoubleBuffered(true);


    }
    
}
