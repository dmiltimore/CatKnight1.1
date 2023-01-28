public class Enemy extends Entity {  
    // fields
    private int HP;
    private int damage;

    
    private static DEFAULT_HP;
    private static DEFULT_DAMAGE;

    public Enemy() {
        this(Enemy.DEFULT_DAMAGE, Enemy.DEFAULT_HP);
    }

    public Enemy(int HP, int damage) {
        this.HP = HP;
        this.damage = damage;
    }

    public int attack () {
        if (this.HP > 0) {
            return this.damage;
        } else {
            return 0;
        }
    }

    public int attacked(int damage) {
        this.HP -= damage;
        return this.HP;
    }

    //public String toString();
}
