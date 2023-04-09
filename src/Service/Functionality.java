package Service;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Functionality {
    public void MyMethod() {
        Product p1 = new Product("bread", "a white product that we no longer eat", 3.99);
        Product p2 = new Product( "creion", "tool to draw with", 1.05);
        System.out.println(p1);
        System.out.println(p2);

        Person per1 = new Person("Ana", "Voinea");
        Author author1 = new Author("razvan", "ilie", "romania");
        System.out.println(per1);
        System.out.println(author1);
        System.out.println(author1.getId());

        Band band1 = new Band("ROOOOOOOOCK");
        System.out.println(band1.getListOfPersons());

        Person per2 = new Person("harry", "potter");
        band1.addPersonToBand(per2);
        System.out.println(band1.getListOfPersons());

        band1.addPersonToBand(author1);
        System.out.println(band1.getListOfPersons());
        System.out.println(band1);

        Order order1 = new Order(new Date());
        Order order2 = new Order(new Date());

        Client client1 = new Client("ana", "maria", "soseaua mea","ana@ana", "0766543987");
        Client client2 = new Client("maria", "razvan", "soseaua noastra","noi2@ana", "0766543563");

//        System.out.println(client1);
//        A static function doesn't depend on any object, so I can't call it by an object,
//              so I need to call it by the Class:
//        System.out.println(client1.getListOfClients());  I CAN'T DO THIS
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");

        Order order5 = new Order(new Date());
        System.out.println("Testez addProductToShoppingCart");
        order5.addProductToThisOrder(p1);
        client1.setShoppingCart(order5);
        System.out.println("Client 1 after shopping cart added" + client1);

        System.out.println("---------AM TERMINAT FUNCTIONALITY----------");
    }


}
