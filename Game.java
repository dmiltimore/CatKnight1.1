
public class Game {
    private boolean gameOver;
    private final Player PLAYER;
    

    public void quitGame() {
        this.gameOver = true;
    }

    public void runGame() {
    
    }

    public void testGameOver() {
        if(!this.gameOver) {
            if(this.PLAYER.getHP() <= 0) {
                this.gameOver = true;
                System.out.println("You died, game over.");
            } else if (this.PLAYER.getHP > 0) {
                // command for continue on after fighting boss

            }

        }
    }

    
}
