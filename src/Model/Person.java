package Model;

import Service.JDBC_CLIENT;
import Service.JDBC_PRODUCT;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int id;
    private static int nextId = JDBC_CLIENT.getMaxIdClient() + 1;
    private String firstName;
    private String lastName;
    private static List<Person> listOfPersons = new ArrayList<Person>();

    public Person(String firstName, String lastName) {
        this.id = nextId;
        nextId++;
        this.firstName = firstName;
        this.lastName = lastName;
        addPersonToList(this);
    }
    private void addPersonToList(Person person) {
        this.listOfPersons.add(person);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static List<Person> getListOfPersons() {
        return listOfPersons;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
