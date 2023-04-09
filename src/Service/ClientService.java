package Service;

import Model.Client;

import java.util.List;

public class ClientService implements ClientInterface{

    @Override
    public Client findClientById(int id) {
//        System.out.println();
        return null;
    }

    @Override
    public void deleteClientById(int id) {

    }

    @Override
    public Client addClient(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Client> findClientsByNumberOfOrders(int orders) {
        return null;
    }

    @Override
    public List<Client> findClientsWithOpenShoppingCart() {
        return null;
    }


}
