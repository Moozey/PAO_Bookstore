package Service;

import Model.*;

import java.util.Date;
import java.util.List;

public interface ProductInterface {
    List<Product> listProductsOrderedByPrice();
    List<Client> showClientsWhoOrderedProduct();
    List<Vinyl> showTheMostSoldVinyls();
    List<Book> showTheMostSoldBooks();
    List<DVD> showTheMostSoldDvds();
    Product findProductByTitle(String title);
    void deleteProductByName(String title);

}
