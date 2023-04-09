import Model.Client;
import Service.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Functionality service = new Functionality();
        service.MyMethod();

        ClientInterface clientInterface = new ClientService();
//        List<String> x = new ArrayList<String>(); list este o interfata si arraylist este implementarea interfetei
//        ca sa pot lucra cu orice functie din java, trebuie sa o apelez ori folosind numeleClasei.numeleFunctie ori numeObiect.numeFunctie
        System.out.println(clientInterface.findClientById(5));
        System.out.println("Testez deleteClientById");
        clientInterface.deleteClientById(800);
        System.out.println(clientInterface.findClientById(5));

        System.out.println("Testez findClientsByNumberOfOrders");
        for(int i = 0; i< clientInterface.findClientsByNumberOfOrders(1).size(); i++)
            System.out.println(clientInterface.findClientsByNumberOfOrders(1).get(i));


    }
}