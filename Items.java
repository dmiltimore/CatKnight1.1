public abstract class Items implements Description {
    private final String NAME;
    private final String DESCRIPTION;

    public Items(String name, String description) {
        this.NAME = name;
        this.DESCRIPTION = description;
    }

    public String getNAME(){
        return this.NAME;
    }

    public String readDesciprtion() {
        return this.DESCRIPTION;
    }
}
