package Service;

import Model.Client;
import Model.Order;
import Model.Product;

import java.util.Date;
import java.util.List;

public class OrderFunctionality {
    public void testingOrderFunctionality(){
        testingOrderInitialization();
    }
    public void testingOrderInitialization(){
        Client client = new Client("Ionut", "Voinea", "Soseaua Colentina", "ionut@ionut.com", "0765432987");
        Client client2 = new Client("Roxana", "Sima", "Soseaua Alba Iulia", "roxi@ionut.com", "0765435487");
        Product product = new Product("telefon", "scump", 2400);
        Product product1 = new Product("tableta", "Dimenisune 6 cm", 2000);
        Product product2 = new Product("televizor", "Dimenisune 10 cm", 3000);
        Order o1 = new Order();
        Order o2 = new Order();
        o1.addProductToThisOrder(product);
        o1.addProductToThisOrder(product1);
        o2.addProductToThisOrder(product);
        o2.addProductToThisOrder(product1);
        o2.addProductToThisOrder(product2);
        client.setShoppingCart(o1);
        client2.setShoppingCart(o2);
        System.out.println("Client has shopping cart: " + client);
        System.out.println("Client placed order " + client.getShoppingCart());
        client.placeOrder();
        client2.placeOrder();
        System.out.println("Client after placing order " + client);
        ProductService productService = new ProductService();
        String telefon = "telefon";
        String tableta = "tableta";
        List<Client> listOfClientsWhoOrderedProductX = productService.showClientsWhoOrderedProduct(telefon);
        System.out.print("List of clients who ordered product " + telefon + " : ");
        productService.printClientsJustIdAndName(listOfClientsWhoOrderedProductX);
    }
}
