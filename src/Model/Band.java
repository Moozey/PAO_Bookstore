package Model;

import java.util.ArrayList;
import java.util.List;

public class Band {
    private String bandName;
    private List<Person> listOfPersons = new ArrayList<Person>();
    private List<Band> listOfBands = new ArrayList<Band>();

    public Band(String bandName) {
        this.bandName = bandName;
//        this.listOfPersons = new ArrayList<Person>();
        addBandToList(this);
    }
    private void addBandToList(Band band){
        this.listOfBands.add(band);
    }
    public List<Band> getListOfBands() {
        return listOfBands;
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
    public void setListOfPersons(List<Person> listOfPersons) {
        this.listOfPersons = listOfPersons;
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
