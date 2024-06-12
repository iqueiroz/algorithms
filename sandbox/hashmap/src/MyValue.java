public class MyValue {
    private final int id;
    private final String name;

    public MyValue(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        hash = 31 * hash + (this.name == null ? 0 : name.hashCode());
        return hash;
    }
}
