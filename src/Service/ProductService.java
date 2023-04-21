package Service;

import Model.*;

import java.util.List;

public class ProductService implements ProductInterface{

    @Override
    public List<Product> listProductsOrderedByPrice() {
        return null;
    }

    @Override
    public List<Client> showClientsWhoOrderedProduct() {
        return null;
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
        for (int p=0; p<Product.getListOfProducts().size(); p++){
            if(Product.getListOfProducts().get(p).getTitle() == title)
                return Product.getListOfProducts().get(p);
        }
        return null;
    }
    @Override
    public void deleteProductByName(String title) {
        for (int p=0; p<Product.getListOfProducts().size(); p++){
            if(Product.getListOfProducts().get(p).getTitle() == title)
                Product.getListOfProducts().remove(p);
        }

    }
}

