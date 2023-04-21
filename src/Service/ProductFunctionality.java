package Service;

import Model.Client;
import Model.Order;
import Model.Product;

import java.util.Date;

public class ProductFunctionality {
    public void testingProductFunctionality() {
        testingProductInitialization();
        testingOrderInitialization();
        testingOrderOperations();
        testingProductOperations();
        testingProductFind("bread");
    }
    public void testingProductInitialization(){
        Product p1 = new Product("bread", "a white product that we no longer eat", 3.99);
        Product p2 = new Product( "creion", "tool to draw with", 1.05);
        System.out.println("List of products:" + Product.getListOfProducts());
    }

    public void testingOrderInitialization(){
        Order order1 = new Order(new Date());
        Order order2 = new Order(new Date());
        System.out.println("List of orders:" + Order.getListOfOrders());
    }
    public void testingOrderOperations(){
        Client client = new Client("Ionut", "Voinea", "soseaua Colentina","ionut@ana", "0766743987");
        Product product = new Product("Sweet Alabama", "O melodie frumoasa", 25.78);
        Order order = new Order(new Date());
        order.addProductToThisOrder(product);
        client.setShoppingCart(order);
        System.out.println("Client after shopping cart added: " + client);
    }
    public void testingProductOperations(){
        Product p3 = new Product("Vaslind spre ceruri", "Carte de povesti", 25);
        System.out.println("List of products:  " + Product.getListOfProducts());
        ProductService productServiceTest = new ProductService();
        productServiceTest.deleteProductByName("Vaslind spre ceruri");
        System.out.println("List of products after delete:  " + Product.getListOfProducts());
    }
    public void testingProductFind(String title){
        ProductService productServiceTest = new ProductService();
        System.out.println("Product with title " + title + ": " + productServiceTest.findProductByTitle(title));
    }

}
