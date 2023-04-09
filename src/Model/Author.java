package Model;

public class Author extends Person {
    private String country;

    public Author(String firstName, String lastName, String country) {
        super(firstName, lastName);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Author{" +
                super.toString() +
                "; country='" + country + '\'' +
                '}';
    }
}
