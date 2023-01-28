package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

    //Screeen Settings
    final private int originalTileSize = 16;
    final private int scale = 3;
    
    final private int tileSize = originalTileSize * scale;
    final private int maxScreenCol = 16;
    final private int maxScreenRow = 12;
    final private int screenWidth = tileSize * maxScreenCol;
    final private int screenHeight = tileSize * maxScreenRow;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));    
        this.setBackground(Color.black);    
        this.setDoubleBuffered(true);


    }
    
}
