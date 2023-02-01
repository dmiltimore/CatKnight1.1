import Entity.Entity;

public class Enemy extends Entity {  
    // fields
    private int HP;
    private int damage;

    
    private static int DEFAULT_HP;
    private static int DEFULT_DAMAGE;

    public Enemy() {
        this(Enemy.DEFULT_DAMAGE, Enemy.DEFAULT_HP);
    }

    public Enemy(int HP, int damage) {
        this.HP = HP;
        this.damage = damage;
    }

    // allows enemey to attack and returns the taken damage
    public int attack () {
        if (this.HP > 0) {
            return this.damage;
        } else {
            return 0;
        }
    }

    // returns enemy damage based on atack
    public int attacked(int damage) {
        this.HP -= damage;
        return this.HP;
    }

    //public String toString();
}
