package Service;

import Model.Product;

import java.util.Scanner;

public class InteractiveMenu  {
    private static JDBC_PRODUCT jdbcProduct = new JDBC_PRODUCT();;
//    private static JDBC_AUTHOR jdbcAuthor;
//    private static JDBC_VINYL jdbcVinyl;
//    private static JDBC_REVIEW jdbcReview;
//    private static JDBC_BOOK jdbcBook;

    public static void start(){
        Scanner scanner =  new Scanner(System.in);

        while(true){
            System.out.println("Hello there! What do you want to do today? Choose from the next options and write just the number: ");
            System.out.println("1. See/Modify some products.");
            System.out.println("9. Exit");
            String choice = scanner.nextLine();
            if(choice.equals("1")){
                while(true){
                    System.out.println("Cool! Now you will see the menu. Choose what do you want to do next:");
                    System.out.println("----- MENU -----");
                    System.out.println("1. Get all products.");
                    System.out.println("2. Create a product");
                    System.out.println("3. Delete a product");
                    System.out.println("4. Update product price");
                    System.out.println("9. Go to main menu.");
                    System.out.print("Enter your choice (1-5): ");
                    String choiceProduct = scanner.nextLine();
                    if(choiceProduct.equals("1")){
                        jdbcProduct.getAllProducts();

                    }
                    if(choiceProduct.equals("2")){
                        System.out.println("Specify the product info:");
                        System.out.println("What is the product title?");
                        String productTitle = scanner.nextLine();
                        System.out.println("What is the product description?");
                        String productDescription = scanner.nextLine();
                        System.out.println("What is the product price?");
                        double productPrice = Double.parseDouble(scanner.nextLine());
                        Product p = new Product(productTitle, productDescription, productPrice);
                        jdbcProduct.createProduct(p);

                    }
                    if(choiceProduct.equals("3")){
                        System.out.println("What is the product title that you want to delete?");
                        String deleteProductTitle = scanner.nextLine();
                        jdbcProduct.deleteProduct(deleteProductTitle);
                    }
                    if(choiceProduct.equals("4")){
                        System.out.println("What is the product title that you want to update?");
                        String productTitle = scanner.nextLine();
                        System.out.println("You can update only the price of the product. Enter the new price:");
                        double updateProductPrice = Double.parseDouble(scanner.nextLine());
                        jdbcProduct.updateProduct(productTitle, updateProductPrice);
                    }
                    if(choiceProduct.equals("9")){
                        break;
                    }
                    System.out.println("Do you want to do another action to products? [y/n]");
                    String choiceActionProduct = scanner.nextLine();
                    if(choiceActionProduct.equals("n"))
                        break;

                }
            }


            if(choice.equals("9")){
                break;
            }
        }
    }
}

