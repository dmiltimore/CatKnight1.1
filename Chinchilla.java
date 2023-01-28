public class Chinchilla extends Enemy {
    private static int DEFAULT_HP = 10;
    private static int DEFULT_DAMAGE = 20;

    public Chinchilla(int HP, int damage) {
        super(HP, damage);
    }

    public Chinchilla() {
        this(Chinchilla.DEFAULT_HP_CHP, Chinchilla.DEFULT_DAMAGE_CD);
    }

    public String toString() {
        return "Chinchilla";
    }
}
