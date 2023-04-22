package Service;

import Model.*;

import java.util.Date;
import java.util.List;

public interface ProductInterface {
    List<Product> listProductsOrderedByPrice();
    List<Client> showClientsWhoOrderedProduct(String Title);
    List<Vinyl> showTheMostSoldVinyls();
    List<Book> showTheMostSoldBooks();
    List<DVD> showTheMostSoldDvds();
    Product findProductByTitle(String title);
    void deleteProductByName(String title);

    void printClientsJustIdAndName(List<Client> listToPrint);

}
