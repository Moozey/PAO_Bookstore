package Service;

import Model.Product;

public class Functionality {
    public void MyMethod() {
        Product p1 = new Product(1, "bread", "a white product that we no longer eat", 3.99);
        Product p2 = new Product(1, "creion", "tool to draw with", 1.05);
        System.out.println(p1);
        System.out.println(p2);
    }


}
