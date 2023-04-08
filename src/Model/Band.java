package Model;

import java.util.List;

public class Band {
    private String bandName;

    public Band(String bandName) {
        this.bandName = bandName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    private List<Person> listOfPersons;
}
