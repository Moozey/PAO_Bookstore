package Model;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;

    private static int nextId = 1;
    private Date data;

    public Order(Date data) {
        this.id = nextId;
        nextId++;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    private List<Product> listOfProducts;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", data=" + data +
                ", listOfProducts=" + listOfProducts +
                '}';
    }
}
