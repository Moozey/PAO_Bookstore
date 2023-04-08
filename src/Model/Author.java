package Model;

public class Author extends Person {
    private Person person;
    private String country;

    public Author(int id, String firstName, String lastName, Person person, String country) {
        super(id, firstName, lastName);
        this.person = person;
        this.country = country;
    }
}
