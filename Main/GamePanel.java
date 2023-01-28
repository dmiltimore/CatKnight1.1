package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

    //Screeen Settings
    final private int originalTileSize = 16;
    final private int scale = 3;
    
    final private int tileSize = originalTileSize * scale;
    final private int maxScreenCol = 16;
    final private int maxScreenRow = 12;
    final private int screenWidth = tileSize * maxScreenCol;
    final private int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set player's deafault position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));    
        this.setBackground(Color.black);    
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);



    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {

        double drawInterval = 1000000000/FPS; // 0.0166
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {
            


            update();
            repaint();
            
            try{
                double remainingTime = nextDrawTime-System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime > 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;

            } catch (InterruptedException){


            }
            
        }
    }

    public void update() {

        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if(keyH.downPressed == true){
            playerY += playerSpeed;
        }
        else if(keyH.leftPressed == true){
            playerX -= playerSpeed;

        }
        else if(keyH.rightPressed == true){
            playerX += playerSpeed;
        }

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }

}


    //getters
    
    //setters

