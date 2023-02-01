public class Chinchilla extends Enemy {
    private static int DEFAULT_HP_CHIN = 10;
    private static int DEFULT_DAMAGE_CHIN = 20;

    public Chinchilla(int HP, int damage) {
        super(HP, damage);
    }

    public Chinchilla() {
        this(Chinchilla.DEFAULT_HP_CHIN, Chinchilla.DEFULT_DAMAGE_CHIN);
    }

    public String toString() {
        return "Chinchilla";
    }
}
