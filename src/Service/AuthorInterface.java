package Service;

import Model.Author;

import java.util.List;

public interface AuthorInterface {
    List<Author> findAuthorsFromCountry(String country);
    void deleteAuthorById(int id);
    void deleteAuthorByName(String firstName, String lastName);

}
