package Service;

import Model.Client;

import java.util.List;

public class ClientService implements ClientInterface{

    @Override
    public Client findClientById(int id) {
        for (int c=0; c<Client.getListOfClients().size(); c++) {
            if(Client.getListOfClients().get(c).getId() == id)
                return Client.getListOfClients().get(c);
        }
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
