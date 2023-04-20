package Model;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person{
    private String address;
    private String email;
    private String phoneNumber;
    private Order shoppingCart;
    private static List<Client> listOfClients = new ArrayList<Client>();
    private List<Order> pastOrders;

    public Client(String firstName, String lastName, String address, String email, String phoneNumber) {
        super(firstName, lastName);
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
//        this.listOfClients.add(this);
        addClientToList(this);
        System.out.println("listOfClients" + listOfClients);
    }
    private void addClientToList(Client client) {
        this.listOfClients.add(client);
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
    public static List<Client> getListOfClients() {
        return listOfClients;
    }

    public List<Order> getPastOrders() {
//        System.out.println("getPastOrders " + this.getId() + pastOrders);
        return pastOrders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + this.getId() + '\'' +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", shoppingCart=" + shoppingCart +
                ", pastOrders=" + pastOrders +
                '}';
    }


}

