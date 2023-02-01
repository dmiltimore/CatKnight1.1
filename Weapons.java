public abstract class Weapons extends TakeableItem {

    private int damage;
    private static int DEFAULT_DAMAGE = 10;
    private static int DEFAULT_VOLUME = 5;

    public Weapons(String name, String description) {
        this(Weapons.DEFAULT_DAMAGE, Weapons.DEFAULT_VOLUME, name, description);
    }

    public Weapons(int damage, int VOLUME, String name, String description) {
        super(VOLUME, name, description); 
        this.damage = damage;
    }

    public int attack() {
        return this.damage;
    }

    public boolean use(CanTakeItem o) {
        try {
            ((CanTakeWeapon) o).switchWeapon(this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    
}
