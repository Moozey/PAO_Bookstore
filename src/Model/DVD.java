package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class DVD extends Product {
    private Band band;
    private Type type;
    private static List<DVD> listOfDVDs = new ArrayList<DVD>();

    public DVD(String title, String description, double price, Band band, Type type) {
        super(title, description, price);
        this.band = band;
        this.type = type;
        addDVDtoList(this);
    }
    public void addDVDtoList(DVD dvd){
        this.listOfDVDs.add(dvd);
    }

    public static List<DVD> getListOfDVDs() {
        return listOfDVDs;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "band=" + band +
                ", type=" + type +
                '}';
    }

}
