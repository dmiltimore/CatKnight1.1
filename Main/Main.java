package Main;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] theArgs){

        // displays and starts game
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); // allows fullscreen and screen sizing
        window.setTitle("Cat Knight"); 

        ImageIcon image = new ImageIcon("Stronglady.png");
        window.setIconImage(image.getImage());

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}