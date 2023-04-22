package Service;

import Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Override
    public List<Vinyl> showTheMostSoldVinyls() {
        return null;
    }

    @Override
    public List<Book> showTheMostSoldBooks() {
        return null;
    }

    @Override
    public List<DVD> showTheMostSoldDvds() {
        return null;
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
}

