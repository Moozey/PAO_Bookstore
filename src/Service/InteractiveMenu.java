package Service;

import Model.Author;
import Model.Book;
import Model.Product;
import Model.Review;

import java.util.Scanner;

public class InteractiveMenu  {
    private static JDBC_PRODUCT jdbcProduct = new JDBC_PRODUCT();;
    private static JDBC_AUTHOR jdbcAuthor = new JDBC_AUTHOR();
    private static JDBC_REVIEW jdbcReview = new JDBC_REVIEW();
    private static JDBC_BOOK jdbcBook = new JDBC_BOOK();

    public static void start(){
        Scanner scanner =  new Scanner(System.in);

        while(true){
            System.out.println("Hello there! What do you want to do today? Choose from the next options and write just the number: ");
            System.out.println("1. See/Modify some products.");
            System.out.println("2. See/Modify some books.");
            System.out.println("3. See/Modify some authors.");
            System.out.println("4. See/Modify some reviews.");
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
            if(choice.equals("2")){
                while(true){
                    System.out.println("Cool! Now you will see the menu. Choose what do you want to do next:");
                    System.out.println("----- MENU -----");
                    System.out.println("1. Get all books.");
                    System.out.println("2. Create a book");
                    System.out.println("3. Delete a book");
                    System.out.println("4. Update book price");
                    System.out.println("9. Go to main menu.");
                    System.out.print("Enter your choice (1-5): ");
                    String choiceBook = scanner.nextLine();
                    if(choiceBook.equals("1")){
                        jdbcBook.getAllBooks();

                    }
                    if(choiceBook.equals("2")){
                        System.out.println("Specify the book info:");
                        System.out.println("What is the book title?");
                        String bookTitle = scanner.nextLine();
                        System.out.println("What is the book description?");
                        String bookDescription = scanner.nextLine();
                        System.out.println("What is the book price?");
                        double bookPrice = Double.parseDouble(scanner.nextLine());

                        System.out.println("What is the author's LAST NAME of the book?");
                        String bookAuthorLastName = scanner.nextLine();
                        System.out.println("What is the author's FIRST NAME of the book?");
                        String bookAuthorFirstName = scanner.nextLine();
                        int authorId = JDBC_AUTHOR.getAuthorIdByNames(bookAuthorLastName, bookAuthorFirstName);
                        System.out.println("What is the type?");
                        String typeName = scanner.nextLine();
                        int typeId = JDBC_TYPE.getTypeIdByNames(typeName);

                        System.out.println("What is the number of pages?");
                        int bookPages = scanner.nextInt();
                        // only do it if the author actually exists
                        // if it doesn't exist, the function wil lreturn 0
                        if (authorId != 0 && typeId != 0) {
                            Book b = new Book(bookTitle, bookDescription, bookPrice, authorId, typeId, bookPages);
                            int bookId = b.getId();
                            jdbcBook.createBook(bookId, bookTitle, bookDescription, bookPrice, authorId, typeId, bookPages);
                            jdbcProduct.createProduct(b);
                        }

                    }
                    if(choiceBook.equals("3")){
                        System.out.println("What is the book title that you want to delete?");
                        String deleteBookTitle = scanner.nextLine();
                        jdbcBook.deleteBook(deleteBookTitle);
                        jdbcProduct.deleteProduct(deleteBookTitle);
                    }
                    if(choiceBook.equals("4")){
                        System.out.println("What is the product title that you want to update?");
                        String bookTitle = scanner.nextLine();
                        System.out.println("You can update only the price of the book. Enter the new price:");
                        double updateBookPrice = Double.parseDouble(scanner.nextLine());
                        jdbcBook.updateBook(bookTitle, updateBookPrice);
                        jdbcProduct.updateProduct(bookTitle, updateBookPrice);
                    }
                    if(choiceBook.equals("9")){
                        break;
                    }
                    System.out.println("Do you want to do another action to products? [y/n]");
                    String choiceActionBook = scanner.nextLine();
                    if(choiceActionBook.equals("n"))
                        break;

                }
            }

            if(choice.equals("3")){
                while(true){
                    System.out.println("Cool! Now you will see the menu. Choose what do you want to do next:");
                    System.out.println("----- MENU -----");
                    System.out.println("1. Get all authors.");
                    System.out.println("2. Create an author");
                    System.out.println("3. Delete an author");
                    System.out.println("4. Update author's last name");
                    System.out.println("9. Go to main menu.");
                    System.out.print("Enter your choice (1-5): ");
                    String choiceAuthor= scanner.nextLine();
                    if(choiceAuthor.equals("1")){
                        jdbcAuthor.getAllAuthors();

                    }
                    if(choiceAuthor.equals("2")){
                        System.out.println("Specify the author's info:");
                        System.out.println("What is the author's LAST NAME?");
                        String lastName = scanner.nextLine();
                        System.out.println("What is the author's FIRST NAME?");
                        String firstName = scanner.nextLine();
                        System.out.println("What is the author's country?");
                        String country = scanner.nextLine();

                        Author a = new Author(firstName, lastName, country);
                        jdbcAuthor.createAuthor(a);

                    }
                    if(choiceAuthor.equals("3")){
                        System.out.println("What is the author's LAST NAME that you want to delete?");
                        String deleteAuthorLastName = scanner.nextLine();
                        System.out.println("What is the author's FIRST NAME that you want to delete?");
                        String deleteAuthorFirstName = scanner.nextLine();
                        jdbcAuthor.deleteAuthor(deleteAuthorLastName, deleteAuthorFirstName);
                    }
                    if(choiceAuthor.equals("4")){
                        System.out.println("What is the author's LAST NAME that you want to update?");
                        String authorLastName = scanner.nextLine();
                        System.out.println("What is the author's FIRST NAME that you want to update?");
                        String authorFirstName = scanner.nextLine();
                        System.out.println("You can update only the LAST name of the author. Enter the new last name:");
                        String newLastName = scanner.nextLine();
                        jdbcAuthor.updateAuthor(authorLastName, authorFirstName, newLastName);
                    }
                    if(choiceAuthor.equals("9")){
                        break;
                    }
                    System.out.println("Do you want to do another action to products? [y/n]");
                    String choiceActionAuthor = scanner.nextLine();
                    if(choiceActionAuthor.equals("n"))
                        break;

                }
            }


            if(choice.equals("4")){
                while(true){
                    System.out.println("Cool! Now you will see the menu. Choose what do you want to do next:");
                    System.out.println("----- MENU -----");
                    System.out.println("1. Get all reviews.");
                    System.out.println("2. Create a review");
                    System.out.println("3. Delete a review");
                    System.out.println("4. Update a review");
                    System.out.println("9. Go to main menu.");
                    System.out.print("Enter your choice (1-5): ");
                    String choiceReview= scanner.nextLine();
                    if(choiceReview.equals("1")){
                        jdbcReview.getAllReviews();

                    }
                    if(choiceReview.equals("2")){
                        System.out.println("Specify the review's details:");
                        System.out.println("What is the rating?");
                        int rating = Integer.parseInt(scanner.nextLine());
                        System.out.println("What is the description of this review?");
                        String description = scanner.nextLine();
                        System.out.println("What is your last name?");
                        String clientLastName = scanner.nextLine();
                        System.out.println("What is your first name?");
                        String clientFirstName = scanner.nextLine();
                        int clientId = JDBC_CLIENT.getClientIdByNames(clientLastName, clientFirstName);

                        System.out.println("What is the product name?");
                        String productName = scanner.nextLine();
                        int productId = JDBC_PRODUCT.getProductIdByNames(productName);

                        Review r = new Review(rating, description, clientId, productId);
                        jdbcReview.createReview(r, productId);

                    }
                    if(choiceReview.equals("3")){
                        System.out.println("You can not delete the review. It helps us to improve our products.");

                    }
                    if(choiceReview.equals("4")){
                        System.out.println("What is the actual description? (Please note that de description should be exactly the same!)");
                        String reviewDescription = scanner.nextLine();
                        System.out.println("Enter the new description of the product:");
                        String newDescription = scanner.nextLine();
                        jdbcReview.updateReview(reviewDescription, newDescription);
                    }
                    if(choiceReview.equals("9")){
                        break;
                    }
                    System.out.println("Do you want to do another action to products? [y/n]");
                    String choiceActionAuthor = scanner.nextLine();
                    if(choiceActionAuthor.equals("n"))
                        break;

                }
            }



            if(choice.equals("9")){
                break;
            }
        }
    }
}

