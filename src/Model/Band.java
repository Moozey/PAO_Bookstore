package Model;

import Service.AuditService;

import java.util.ArrayList;
import java.util.List;

public class Band {
    private int id;
    private static int nextId = 1;
    private String bandName;
    private List<Person> bandMembers = new ArrayList<Person>();
    private static List<Band> listOfBands = new ArrayList();
    private static AuditService auditService = AuditService.getInstance();

    public Band(String bandName) {
        this.id = nextId;
        nextId++;
        this.bandName = bandName;
//        this.listOfPersons = new ArrayList<Person>();
        addBandToList(this);
    }
    private void addBandToList(Band band){
        auditService.write("Add band to list");
        this.listOfBands.add(band);
    }

    public int getId() {
        return id;
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
        return bandMembers;
    }
    public void setListOfPersons(List<Person> listOfPersons) {
        this.bandMembers = listOfPersons;
    }
    public void addPersonToBand(Person personToBeAdded) {
        auditService.write("Add person to band");
        this.bandMembers.add(personToBeAdded);
    }
    public static Band findBandByName(String name) {
        auditService.write("Find band by name");
        for (int i = 0; i < listOfBands.size(); i++) {
            if (listOfBands.get(i).getBandName() == name)
                return listOfBands.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Band{" +
                "bandName='" + bandName + '\'' +
                ", listOfPersons=" + bandMembers +
                '}';
    }
}
