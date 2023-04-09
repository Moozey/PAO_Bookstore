package Service;

import Model.Client;
import Model.Order;

import java.util.ArrayList;
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
        for (int c=0; c<Client.getListOfClients().size(); c++) {
            if(Client.getListOfClients().get(c).getId() == id)
                Client.getListOfClients().remove(c);
        }
    }
    @Override
    public List<Client> findClientsByNumberOfOrders(int orders) {
        List<Client> listOfCustomers = new ArrayList<Client>();
        for (int c=0; c<Client.getListOfClients().size(); c++) {
            if(Client.getListOfClients().get(c).getPastOrders().size() >= orders)
                listOfCustomers.add(Client.getListOfClients().get(c));
        }
        return listOfCustomers;
    }

    @Override
    public List<Client> findClientsWithOpenShoppingCart() {

        return null;
    }


}
