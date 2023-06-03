package Service;

import Model.Author;
import Model.Client;

import java.util.ArrayList;
import java.util.List;

public class AuthorService implements AuthorInterface{

    @Override
    public List<Author> findAuthorsFromCountry(String country) {
        List<Author> listOfAuthorsFromCountry = new ArrayList<>();
        for( int authorId = 0; authorId < Author.getListOfAuthors().size(); authorId++){
            if(Author.getListOfAuthors().get(authorId).getCountry() == country )
                listOfAuthorsFromCountry.add(Author.getListOfAuthors().get(authorId));
        }
        return listOfAuthorsFromCountry;
    }

    @Override
    public void deleteAuthorById(int id) {
        for (int authorId = 0; authorId < Author.getListOfAuthors().size(); authorId++) {
            if(Author.getListOfAuthors().get(authorId).getId() == id)
                Author.getListOfAuthors().remove(authorId);
        }
    }

    @Override
    public void deleteAuthorByName(String firstName, String lastName) {
        for (int authorId = 0; authorId < Author.getListOfAuthors().size(); authorId++){
            if(Author.getListOfAuthors().get(authorId).getFirstName() == firstName && Author.getListOfAuthors().get(authorId).getLastName() == lastName)
                Author.getListOfAuthors().remove(authorId);
        }
    }

}
