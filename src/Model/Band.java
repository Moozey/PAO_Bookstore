package Model;

import java.util.ArrayList;
import java.util.List;

public class Band {
    private String bandName;
    private List<Person> listOfPersons;

    public Band(String bandName) {
        this.bandName = bandName;
        this.listOfPersons = new ArrayList<Person>();
    }

    public String getBandName() {
        return bandName;
    }
    public void setBandName(String bandName) {
        this.bandName = bandName;
    }
    public List<Person> getListOfPersons() {
        return listOfPersons;
    }

    public void addPersonToBand(Person personToBeAdded) {
        this.listOfPersons.add(personToBeAdded);
    }

    @Override
    public String toString() {
        return "Band{" +
                "bandName='" + bandName + '\'' +
                ", listOfPersons=" + listOfPersons +
                '}';
    }
}
