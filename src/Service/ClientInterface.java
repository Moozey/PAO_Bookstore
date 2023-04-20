package Service;

import Model.Client;

import java.util.List;

public interface ClientInterface {
    Client findClientById(int id);
    void deleteClientById(int id);
    List<Client> findClientsByNumberOfOrders(int orders);
    List<Client> findClientsWithOpenShoppingCart();

    void updateClientLastName(String lastName, Client client);
    void updateClientAddress(String address, Client client);


}
