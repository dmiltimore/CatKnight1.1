public abstract class Potions extends TakeableItem {
    private static final int DEFAULT_VOLUME = 5;
    private static final int DEFAULT_HP_HEAL = 20;

    private int HP_HEAL;

    public Potions (int HP_HEAL, int VOLUME, String name, String description) {
        super(VOLUME, name, description);
    }

    public Potions(int HP_HEAL, String name, String description) {
        this(HP_HEAL, Potions.DEFAULT_VOLUME, name, description);
    }

    public Potions(String name, String description) {
        this(Potions.DEFAULT_HP_HEAL, name, description);
    }
    public int getHP_HEAL() {
        return this.HP_HEAL;
    }

    public boolean use(CanTakeItem o) {
        try {
            ((Healable) o).heal(this.getHP_HEAL());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
