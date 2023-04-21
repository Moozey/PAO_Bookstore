package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;

    private static int nextId = 1000;
    private Date data;

    private static List<Order> listOfOrders = new ArrayList<>();
    private List<Product> listOfProductsForThisOrder = new ArrayList<>();

    public Order(Date data) {
        this.id = nextId;
        nextId++;
        this.data = data;
        addOrderToList(this);
    }
    public void addOrderToList(Order order){
        this.listOfOrders.add(order);
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

    public void addProductToThisOrder(Product product){
        listOfProductsForThisOrder.add(product);
//        System.out.println("ListOfProductsOnThisOrder: " + listOfProductsForThisOrder);

    }

    public static List<Order> getListOfOrders() {
        return listOfOrders;
    }

    public List<Product> getListOfProductsForThisOrder() {
        return listOfProductsForThisOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", data=" + data +
                ", listOfProducts=" + listOfProductsForThisOrder +
                '}';
    }
}
