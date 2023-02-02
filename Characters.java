import Entity.Entity;

public class Characters extends Entity {
    private Weapons activeWeapons;
    private int HP;
    private final int MAX_HP = 100;
    private static final int NO_WEAPON_DAMAGE = 15;

    public int attack() {
        if (activeWeapons != null) {
            return this.activeWeapons.attack();
        } else {
            return NO_WEAPON_DAMAGE;
        }
    }

    public int attacked(int damage) {
        this.HP -= damage;
        return this.HP;
    }

    public int getHP() {
        return this.HP;
    }

    public Weapons getWeapons() {
        return this.activeWeapons;
    }

    public void heal(int HP) {
        this.HP += HP;
    }

    public void switchWeapons (Weapons w) {
        if (this.activeWeapons == null) {
            this.activeWeapons = w;
        }
    }
}
