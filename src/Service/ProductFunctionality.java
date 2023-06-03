package Service;

import Model.*;

import java.util.Date;

public class ProductFunctionality {
    public void testingProductFunctionality() {
        testingProductInitialization();
        testingOrderInitialization();
        testingOrderOperations();
        testingProductOperations();
        testingProductFind("bread");
        testingOrderingProductsByPrice();
        testingVinylsInitialization();
        testingBooksInitialization();
    }
    public void testingProductInitialization(){
        Product p1 = new Product("bread", "a white product that we no longer eat", 3.99);
        Product p2 = new Product( "creion", "tool to draw with", 1.05);
        System.out.println("List of products:" + Product.getListOfProducts());

        JDBC_PRODUCT jdbc_product = new JDBC_PRODUCT();
        Product p3 = new Product( "pillow", "very soft", 105.99);
        jdbc_product.createProduct(p1);
        jdbc_product.createProduct(p2);
        jdbc_product.createProduct(p3);
//        jdbc_product.deleteProduct(p3);
//        jdbc_product.updateProduct(p3, 200);
        jdbc_product.getAllProducts();
    }

    public void testingOrderInitialization(){
        Order order1 = new Order(new Date());
        Order order2 = new Order(new Date());
        System.out.println("List of orders:" + Order.getListOfOrders());
    }
    public void testingOrderOperations(){
        Client client = new Client("Ionut", "Voinea", "soseaua Colentina","ionut@ana", "0766743987");
        Product product = new Product("Sweet Alabama", "O melodie frumoasa", 25.78);
        Order order = new Order(new Date());
        order.addProductToThisOrder(product);
        client.setShoppingCart(order);
        System.out.println("Client after shopping cart added: " + client);
    }
    public void testingProductOperations(){
        Product p3 = new Product("Vaslind spre ceruri", "Carte de povesti", 25);
        System.out.println("List of products:  " + Product.getListOfProducts());
        ProductService productServiceTest = new ProductService();
        productServiceTest.deleteProductByName("Vaslind spre ceruri");
        System.out.println("List of products after delete:  " + Product.getListOfProducts());
    }
    public void testingProductFind(String title){
        ProductService productServiceTest = new ProductService();
        System.out.println("Product with title " + title + ": " + productServiceTest.findProductByTitle(title));
    }
    public void testingOrderingProductsByPrice(){
        ProductService productServiceTest = new ProductService();
        productServiceTest.listProductsOrderedByPrice();
    }
    public void testingVinylsInitialization(){
        Band nirvana = Band.findBandByName("Nirvana");
        Band MJ = new Band("MichaelJackson");
        Band Simplu = new Band("Simplu");
        Type years70 = new Type("70's");
        Type popMusic = new Type("Pop Music");
        Vinyl vinylOfNirvana = new Vinyl("Nevermind", "Very nice album", 140, nirvana, years70);
        Vinyl vinylOfMJ = new Vinyl("Thriller", "Very good album", 150, MJ, years70);

        JDBC_VINYL jdbc_vinyl = new JDBC_VINYL();
        Vinyl vinylOfSmiley = new Vinyl("Acasa", "Aparut in 2009", 25, Simplu, popMusic);
        jdbc_vinyl.createVinyl(vinylOfSmiley);
//        jdbc_vinyl.deleteVinyl(vinylOfSmiley);
        jdbc_vinyl.updateVinyl(vinylOfSmiley, 200);
        jdbc_vinyl.getAllVinyls();
    }
    public void testingBooksInitialization(){
        Author author1 = new Author("Margaret", "Mitchell", "Georgia");
        Author author2 = new Author("Mihai", "Eminescu", "Romania");
        Type novel = new Type("novel");
        Type poem = new Type("poem");
        Book book1 = new Book("Pe aripile vantului", "am citit cartea", 25, author1, novel,300);
        Book book2 = new Book("Poezii de Mihai Eminescu", "Multe poezii", 35, author2, poem,150);

        JDBC_BOOK jdbc = new JDBC_BOOK();
        Book book3 = new Book("Pe aripile vantului", "Am citit cartea", 25, author1, novel,300);
        Book book4 = new Book("Pe aripile vantului2", "Nu am citit cartea", 35, author1, novel,350);
//        jdbc.createBook(book4);
//        jdbc.deleteBook(book4);
//        jdbc.updateBook(book4, 100);
        jdbc.getAllBooks();
    }

    public void testingReviewing(){
        Client client1 = new Client("Alma", "Ionescu", "soseaua virtutii","alma@yahoo.com", "0766933987");
        Product product1 = new Product("Sweet Alabama", "O melodie frumoasa", 25.78);

        JDBC_REVIEW jdbc_review = new JDBC_REVIEW();
        Review review1 = new Review(10, "Imi place super mult", client1.getId(), product1.getId() );
        jdbc_review.createReview(review1, product1.getId());
//        jdbc_review.deleteReview(review1);
        jdbc_review.updateReview(review1, "Wowow, asta e super nice!");
        jdbc_review.getAllReviews();
    }

}
