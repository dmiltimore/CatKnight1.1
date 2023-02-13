package Object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ObjectLantern extends SuperObject {
    public ObjectLantern() {
        name = "Lantern";
        try{
            image = ImageIO.read(getClass().getResource("/Assets/Objects/lantern.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
