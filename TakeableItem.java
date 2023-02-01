public abstract class TakeableItem extends Items{
    private final int VOLUME;

    // items have volume to determine the amount of damage it holds depending on size
    public TakeableItem (int VOLUME, String name, String description) {
        super(name, description);
        this.VOLUME = VOLUME;
    }
    public int getVOLUE() {
        return this.VOLUME;
    }
    // where a player can take an item is determined
    abstract public boolean use(CanTakeItem o);

}
