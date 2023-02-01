public abstract class Weapons extends TakeableItem {

    // weapons have damage, and volume. the volume describes its power
    private int damage;
    private static int DEFAULT_DAMAGE = 10;
    private static int DEFAULT_VOLUME = 5;

    public Weapons(String name, String description) {
        this(Weapons.DEFAULT_DAMAGE, Weapons.DEFAULT_VOLUME, name, description);
    }

    // calls the super class to define weapon name and description
    public Weapons(int damage, int VOLUME, String name, String description) {
        super(VOLUME, name, description); 
        this.damage = damage;
    }

    // allows item to attack, take damage
    public int attack() {
        return this.damage;
    }

    // allows player to take item and switch items
    public boolean use(CanTakeItem o) {
        try {
            ((CanTakeWeapon) o).switchWeapon(this);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    
}
