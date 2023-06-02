import Service.*;

public class Main {
    public static void main(String[] args) {
        PersonFunctionality personService = new PersonFunctionality();
        ProductFunctionality productService = new ProductFunctionality();
        OrderFunctionality orderFunctionality = new OrderFunctionality();

        personService.testingPersonFunctionality();
        productService.testingProductFunctionality();
        orderFunctionality.testingOrderFunctionality();


        JDBC_BOOK jdbc_book = new JDBC_BOOK();
        jdbc_book.closeConnection();

        JDBC_AUTHOR jdbc_author = new JDBC_AUTHOR();
        jdbc_author.closeConnection();


    }
}