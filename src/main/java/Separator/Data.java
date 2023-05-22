package Separator;

public class Data {
    private final String name;
    private final int id;
    private final long number;

    public Data(String name, int id, long number) {
        this.name = name;
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "name: " + name + "\nid: " + id + "\nnumber: " + number;
    }
}