package Model;

import Service.JDBC_PRODUCT;
import Service.JDBC_TYPE;

public class Type {
    private int id;
    private static int nextId = JDBC_TYPE.getMaxTypeId() + 1;
    private String name;

    public Type(String name) {
        this.id = nextId;
        nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                '}';
    }
}
