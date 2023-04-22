package Service;

import Model.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ProductInterface {
    List<Product> listProductsOrderedByPrice();
    List<Client> showClientsWhoOrderedProduct(String Title);
    Map<String, Integer> showTheMostSoldVinyls();
    List<Book> showTheMostSoldBooks();
    List<DVD> showTheMostSoldDvds();
    Product findProductByTitle(String title);
    void deleteProductByName(String title);

    void printClientsJustIdAndName(List<Client> listToPrint);
    void printListOfProductsOnlyIdAndTitle();

}
