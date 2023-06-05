import Service.*;

public class Main {
    public static void main(String[] args) {
        AuditService auditService = AuditService.getInstance();
//        PersonFunctionality personService = new PersonFunctionality();
//        ProductFunctionality productService = new ProductFunctionality();
//        OrderFunctionality orderFunctionality = new OrderFunctionality();

//        personService.testingPersonFunctionality();
//        productService.testingProductFunctionality();
//        orderFunctionality.testingOrderFunctionality();
//        productService.testingReviewing();


//        JDBC_BOOK jdbc_book = new JDBC_BOOK();
//        jdbc_book.closeConnection();
//
//        JDBC_AUTHOR jdbc_author = new JDBC_AUTHOR();
//        jdbc_author.closeConnection();
//
//        JDBC_VINYL jdbc_vinyl = new JDBC_VINYL();
//        jdbc_vinyl.closeConnection();
//
//        JDBC_REVIEW jdbc_review = new JDBC_REVIEW();
//        jdbc_review.closeConnection();
//
//        JDBC_PRODUCT jdbc_product = new JDBC_PRODUCT();
//        jdbc_product.closeConnection();

        InteractiveMenu.start();


    }
}