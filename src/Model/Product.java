package Model;

import java.util.ArrayList;
import java.util.List;

public class Product implements Comparable<Product> {
    private int id;
    private static int nextId = 1;
    private String title;
    private String description;
    private double price;
    private static List<Product> listOfProducts = new ArrayList<Product>();


    public Product(String title, String description, double price) {
        this.id = nextId;
        nextId++;
        this.title = title;
        this.description = description;
        this.price = price;
        addProductToList(this);
    }
    public void addProductToList(Product product){
        this.listOfProducts.add(product);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> getListOfProducts() {
        return listOfProducts;
    }

    public static Product findProductByName(String name) {
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getTitle() == name)
                return listOfProducts.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    public String printIdAndTitle() {
        return "(" +
                "id: " + this.getId() +
                ", title: " + this.getTitle() +
                ", class: " + this.getClass().getSimpleName() +
                ')';
    }
    @Override
    public int compareTo(Product o) {
        if (this.price > o.price) {
            return 1;
        }
        else if (this.price < o.price) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
