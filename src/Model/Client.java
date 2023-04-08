package Model;

import java.util.List;

public class Client extends Person{
    private String address;
    private String email;
    private String phoneNumber;
    private Order shoppingCart;

    public Client(String firstName, String lastName, String address, String email, String phoneNumber, Order shoppingCart, List<Order> pastOrders) {
        super(firstName, lastName);
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shoppingCart = shoppingCart;
        this.pastOrders = pastOrders;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Order getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Order shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    private List<Order> pastOrders;
}

