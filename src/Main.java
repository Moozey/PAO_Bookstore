import Service.*;

public class Main {
    public static void main(String[] args) {
        Functionality service = new Functionality();
        service.MyMethod();
        ClientInterface clientInterface = new ClientService();
        System.out.println(clientInterface.findClientById(5));

    }
}