package Service;

import Model.*;

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
    }


}
