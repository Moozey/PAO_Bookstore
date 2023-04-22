package Service;

import Model.*;

import java.util.*;

import static Model.Product.findProductByName;
import static Model.Product.getListOfProducts;

public class ProductService implements ProductInterface{
    @Override
    public List<Product> listProductsOrderedByPrice() {
        List<Product> listOfOrderedProduct = new ArrayList<>(getListOfProducts());
        System.out.println("Before sorting " + listOfOrderedProduct);
        Collections.sort(listOfOrderedProduct);
        System.out.println("After sorting " + listOfOrderedProduct);
        return null;
    }
    @Override
    public List<Client> showClientsWhoOrderedProduct(String productName) {
        List<Client> listOfClients = Client.getListOfClients();
        List<Client> listOfClientsWhoOrderedProduct = new ArrayList<>();
        for(int c=0; c < listOfClients.size(); c++) {
            List<Order> listOfOrders = listOfClients.get(c).getPastOrders();
            for (int o = 0; o < listOfOrders.size(); o++) {
                List<Product> listOfProducts = listOfOrders.get(o).getListOfProductsForThisOrder();
                if(listOfProducts.contains(findProductByName(productName)))
                    listOfClientsWhoOrderedProduct.add(listOfClients.get(c));
            }
        }
        return listOfClientsWhoOrderedProduct;
    }

//    trec prin toti clientii, dupa trec prin fiecare pastOrder al clientului curent
//    si verific daca are in pastOrder produse de tipul "vinil";
//    daca are, adaug vinilurile intr-o lista de showTheMostVinyls si
//    contorizez cate viniluri din fiecare vinil au fost vandute si le ord descrescator
    @Override
    public Map<String, Integer> showTheMostSoldVinyls() {
        System.out.println("//////////");
        Map<String, Integer>  listOfTheMostSoldVinyls = new HashMap<String, Integer>();
        for(int clientId=0; clientId<Client.getListOfClients().size(); clientId++)
        {
            Client currentClient = Client.getListOfClients().get(clientId);
            for(int orderId=0; orderId<currentClient.getPastOrders().size(); orderId++)
            {
                Order currentOrder = currentClient.getPastOrders().get(orderId);
                for(int productId=0; productId<currentOrder.getListOfProductsForThisOrder().size(); productId++){
                    Product currentProduct = currentOrder.getListOfProductsForThisOrder().get(productId);
                    if(currentProduct instanceof Vinyl) {
                        if(listOfTheMostSoldVinyls.containsKey(currentProduct.getTitle()))
                            listOfTheMostSoldVinyls.put(currentProduct.getTitle(), listOfTheMostSoldVinyls.get(currentProduct.getTitle())+1);
                        else
                            listOfTheMostSoldVinyls.put(currentProduct.getTitle(), 1);
                    }
                }
            }

        }
        return listOfTheMostSoldVinyls;
    }

    @Override
    public Map<String, Integer> showTheMostSoldBooks() {
        System.out.println("//////////");
        Map<String, Integer>  listOfTheMostSoldBooks = new HashMap<String, Integer>();
        for(int clientId=0; clientId<Client.getListOfClients().size(); clientId++)
        {
            Client currentClient = Client.getListOfClients().get(clientId);
            for(int orderId=0; orderId<currentClient.getPastOrders().size(); orderId++)
            {
                Order currentOrder = currentClient.getPastOrders().get(orderId);
                for(int productId=0; productId<currentOrder.getListOfProductsForThisOrder().size(); productId++){
                    Product currentProduct = currentOrder.getListOfProductsForThisOrder().get(productId);
                    if(currentProduct instanceof Book) {
                        if(listOfTheMostSoldBooks.containsKey(currentProduct.getTitle()))
                            listOfTheMostSoldBooks.put(currentProduct.getTitle(), listOfTheMostSoldBooks.get(currentProduct.getTitle())+1);
                        else
                            listOfTheMostSoldBooks.put(currentProduct.getTitle(), 1);
                    }
                }
            }

        }
        return listOfTheMostSoldBooks;
    }

    @Override
    public Map<String, Integer> showTheMostSoldDvds() {
        System.out.println("//////////");
        Map<String, Integer>  listOfTheMostSoldDvds = new HashMap<String, Integer>();
        for(int clientId=0; clientId<Client.getListOfClients().size(); clientId++)
        {
            Client currentClient = Client.getListOfClients().get(clientId);
            for(int orderId=0; orderId<currentClient.getPastOrders().size(); orderId++)
            {
                Order currentOrder = currentClient.getPastOrders().get(orderId);
                for(int productId=0; productId<currentOrder.getListOfProductsForThisOrder().size(); productId++){
                    Product currentProduct = currentOrder.getListOfProductsForThisOrder().get(productId);
                    if(currentProduct instanceof DVD) {
                        if(listOfTheMostSoldDvds.containsKey(currentProduct.getTitle()))
                            listOfTheMostSoldDvds.put(currentProduct.getTitle(), listOfTheMostSoldDvds.get(currentProduct.getTitle())+1);
                        else
                            listOfTheMostSoldDvds.put(currentProduct.getTitle(), 1);
                    }
                }
            }

        }
        return listOfTheMostSoldDvds;
    }

    @Override
    public Product findProductByTitle(String title) {
        for (int p = 0; p< getListOfProducts().size(); p++){
            if(getListOfProducts().get(p).getTitle() == title)
                return getListOfProducts().get(p);
        }
        return null;
    }
    @Override
    public void deleteProductByName(String title) {
        for (int p = 0; p< getListOfProducts().size(); p++){
            if(getListOfProducts().get(p).getTitle() == title)
                getListOfProducts().remove(p);
        }

    }
    @Override
    public void printClientsJustIdAndName(List<Client> listToPrint) {
        for (int idClient = 0; idClient < listToPrint.size(); idClient++) {
            Client currentClient = listToPrint.get(idClient);
            System.out.print(currentClient.printIdFirstNameLastName());
        }
        System.out.println();
    }

    @Override
    public void printListOfProductsOnlyIdAndTitle() {
        List<Product> productList = Product.getListOfProducts();
        for(int productId=0; productId<productList.size(); productId++ ){
            Product currentProduct = productList.get(productId);
            System.out.print(currentProduct.printIdAndTitle());
        }
        System.out.println();
    }


}

