package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    //Screeen Settings
<<<<<<< HEAD
    final  int originalTileSize = 16; //16 x 16 tile
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; //48 x 48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
=======
    final private int originalTileSize = 16;
    final private int scale = 3;
    
    final private int tileSize = originalTileSize * scale;
    final private int maxScreenCol = 16;
    final private int maxScreenRow = 12;
    final private int screenWidth = tileSize * maxScreenCol;
    final private int screenHeight = tileSize * maxScreenRow;
>>>>>>> a433d3cb887822a4a9b5924f1c89f554c939ca7d

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));    
        this.setBackground(Color.black);    
        this.setDoubleBuffered(true);


    }
    
}
