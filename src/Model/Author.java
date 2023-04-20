package Model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private String country;
    private static List<Author> listOfAuthors = new ArrayList<Author>();

    public Author(String firstName, String lastName, String country) {
        super(firstName, lastName);
        this.country = country;
        addAuthorToList(this);
    }
    private void addAuthorToList(Author author) {
        this.listOfAuthors.add(author);
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static List<Author> getListOfAuthors() {
        return listOfAuthors;
    }


    @Override
    public String toString() {
        return "Author{" +
                super.toString() +
                "; country='" + country + '\'' +
                '}';
    }
}
