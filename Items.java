public abstract class Items implements Description{
    //fields
    private String NAME;
    private String DESCRIPTION;

    // passes name and description of item
    public Items(String name, String description) {
        this.NAME = name;
        this.DESCRIPTION = description;
    }

    // returns items name
    public String getNAME() {
        return this.NAME;
    }

    // returns iteams description
    public String readDescription() {
        return this.DESCRIPTION;
    }
}
