public abstract class Weapons extends Items {

    private int damage;
    private static int DEFAULT_DAMAGE = 10;

    public Weapons(String name, String description) {
        this(Weapons.DEFAULT_DAMAGE, name, description);
    }

    public Weapons(int damage, String name, String description) {
        super(name, description); 
        this.damage = damage;
    }

    
}
