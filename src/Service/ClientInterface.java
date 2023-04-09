package Service;

import Model.Client;

import java.util.List;

public interface ClientInterface {
    Client findClientById(int id);
    void deleteClientById(int id);
    List<Client> findClientsByNumberOfOrders(int orders);
    List<Client> findClientsWithOpenShoppingCart();

}
