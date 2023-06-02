package Service;

import Model.*;

import java.util.List;

public class PersonFunctionality {


    public void testingPersonFunctionality() {
        testingPersonInitialization();
        testingAuthorInitialization();
        testingUpdateFunctions();
        testingClientOperations();
        testingAddingPersonsToBand();
    }

    public void testingPersonInitialization() {
        Person per1 = new Person("Ana", "Voinea");
        Person per2 = new Person("ANUTA", "POTTER");
        System.out.println("ListOfPersons:    " + Person.getListOfPersons());
    }

    public void testingAuthorInitialization() {
        Author author1 = new Author("razvan", "ilie", "romania");
        System.out.println("List of authors:    " + Author.getListOfAuthors());

        JDBC_AUTHOR jdbc = new JDBC_AUTHOR();
        Author author2 = new Author("Mihai", "Eminescu", "Romania");
        Author author3 = new Author("Ion-Luca", "Caragiale", "Romania");
        jdbc.createAuthor(author2);
        jdbc.createAuthor(author3);
        jdbc.deleteAuthor(author3);
//        jdbc.updateAuthor(author2, "Eminovici");
        jdbc.getAllAuthors();
    }

    public void testingAddingPersonsToBand() {
        Person per3 = new Person("harry", "potter");
        Author auth2 = new Author("Robert", "Gruia", "Moldova");
        Band nirvana = new Band("Nirvana");
        nirvana.addPersonToBand(per3);
        ClientService clientService = new ClientService();
        nirvana.addPersonToBand(clientService.findClientById(4));
        nirvana.addPersonToBand(auth2);
        System.out.println("Nirvana members:  " + nirvana.getListOfPersons());
    }
    public void testingUpdateFunctions() {
        Client client1 = new Client("ana", "maria", "soseaua mea","ana@ana", "0766543987");
        Client client2 = new Client("maria", "razvan", "soseaua noastra","noi2@ana", "0766543563");
        ClientService clientService = new ClientService();
        System.out.println("Before updating name and address");
        printListOfClients();
        clientService.updateClientLastName("BLABLA", client1);
        clientService.updateClientAddress("OLTULUI", client2);
        System.out.println("After updating name and address");
        printListOfClients();
    }

    public void testingClientOperations() {
        testingClientFind(6);
        testingClientDelete(6);
        testingClientFind(6);
    }

    public void testingClientFind(int id) {
        ClientService clientServiceTest = new ClientService();
        System.out.println("Client with id " + id + ": " + clientServiceTest.findClientById(id));
    }

    public void testingClientDelete(int id) {
        ClientService clientServiceTest = new ClientService();
        printListOfClients();
        System.out.println("Deleting client with id " + id + ": ");
        clientServiceTest.deleteClientById(id);
        printListOfClients();
    }

    public void printListOfClients() {
        System.out.println("List of clients: " + Client.getListOfClients());
    }


    public List<Order> findOrdersOfClient(String lastName, String firstName){
        Client client = Client.findClientByName(lastName,firstName);
        for(int o=0; o<client.getPastOrders().size(); o++){
            return client.getPastOrders();
        }
        return null;
    }
}
