import Service.*;

public class Main {
    public static void main(String[] args) {
        PersonFunctionality personService = new PersonFunctionality();
        ProductFunctionality productService = new ProductFunctionality();
        personService.testingPersonFunctionality();
        productService.testingProductFunctionality();
    }
}