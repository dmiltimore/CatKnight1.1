public abstract class TakeableItem extends Items{
    private final int VOLUME;

    public TakeableItem (int VOLUME, String name, String description) {
        super(name, description);
        this.VOLUME = VOLUME;
    }
    public int getVOLUE() {
        return this.VOLUME;
    }
    abstract public boolean use(CanTakeItem o);

}
