package Object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectPotion extends SuperObject {
    public ObjectPotion() {
        name = "Potion";
        try{
            image = ImageIO.read(getClass().getResource("/Assets/Objects/potion_red.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
