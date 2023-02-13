package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectCoin extends SuperObject {
    public ObjectCoin() {
        name = "Coin";
        try{
            image = ImageIO.read(getClass().getResource("/Assets/Objects/coin_bronze.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
