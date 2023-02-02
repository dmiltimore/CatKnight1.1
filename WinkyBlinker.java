public class WinkyBlinker extends Enemy {
   
    // sets damage and HP
    private static int DEFAULT_HP_WINKY = 15;
    private static int DEFULT_DAMAGE_WINKY = 30;

    // calls super
    public WinkyBlinker(int HP, int damage) {
        super(HP, damage);
    }

    // specifies HP and damage for WinkyBlinker
    public WinkyBlinker() {
        this(WinkyBlinker.DEFAULT_HP_WINKY, WinkyBlinker.DEFULT_DAMAGE_WINKY);
    }

    public String toString() {
        return "WinkyBlinker";
    }
}
