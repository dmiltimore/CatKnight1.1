public class WinkyBlinker extends Enemy {
   
    // sets damage and HP
    private static int DEFAULT_HP = 15;
    private static int DEFULT_DAMAGE = 30;

    // calls super
    public WinkyBlinker(int HP, int damage) {
        super(HP, damage);
    }

    // specifies HP and damage for WinkyBlinker
    public WinkyBlinker() {
        this(WinkyBlinker.DEFAULT_HP_WBHP, WinkyBlinker.DEFULT_DAMAGE_WBD);
    }

    public String toString() {
        return "WinkyBlinker";
    }
}
