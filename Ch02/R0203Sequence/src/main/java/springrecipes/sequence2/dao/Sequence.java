package springrecipes.sequence2.dao;

public class Sequence {
    private final String id;
    private final String suffix;

    public Sequence(String id, String suffix) {
        this.id = id;
        this.suffix = suffix;
    }

    public String getId() {
        return id;
    }

    public String getSuffix() {
        return suffix;
    }
}
