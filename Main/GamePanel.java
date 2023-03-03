package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import Entity.Player;
import Object.SuperObject;
import Tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    //Screeen Settings
    final int originalTileSize = 16;
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    //World Settings
    public final int maxWorldCol = 20;
    public final int maxWorldRow = 20;

    int FPS = 60;

    //SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssestSetter aSetter = new AssestSetter(this);
    Thread gameThread;


    // ENTITY AND OBJECT

    public Player player = new Player(this, keyH);
    public SuperObject object[] = new SuperObject[10];
    public UI ui = new UI(this);


    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    // players position default
    // int playerX = 100;
    // int playerY = 100; 
    // int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));    
        this.setBackground(Color.black);    
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);



    }
    public void setupGame() {
        aSetter.setObject();
        playMusic(1); //plays cafe song
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        gameState = playState;
    }

    public void run() {

        double drawInterval = 1000000000/FPS; // 0.0166
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        } 

    }

    public void update() {
        if(gameState == playState) {
            player.update();
        }
        if(gameState == pauseState) {

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        long drawStart = 0;
        if(keyH.checkDrawTime == true) {
            drawStart = System.nanoTime();
        }
        // tile
        tileM.draw(g2);

        // object
        for(int i = 0; i < object.length; i++) {
            if(object[i] != null) {
                object[i].draw(g2, this);
            }
        }

        // player
        player.draw(g2); //draws player second layer

        ui.draw(g2);
        
        g2.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic() {
        music.stop();
    }
    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }

     //getters
     public int getTileSize() {
        return tileSize;
    }

    public int getScreenWidth(){
        return screenWidth;
    }

    public int getScreenHeight(){
        return screenHeight;
    }
    //setters

}




