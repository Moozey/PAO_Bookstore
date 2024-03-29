package Model;

import Model.Type;
import Model.Product;
import Service.AuditService;

import java.util.*;

public class Vinyl extends Product {
    private Band band;
    private Type type;

    private static List<Vinyl> listOfVinyls = new ArrayList<Vinyl>();
    private static AuditService auditService = AuditService.getInstance();

    public Vinyl(String title, String description, double price, Band band, Type type) {
        super(title, description, price);
        this.band = band;
        this.type = type;
        addVinylToList(this);
    }

    public void addVinylToList(Vinyl vinyl){
        auditService.write("Add vinyl to list");
        this.listOfVinyls.add(vinyl);
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

    public List<Vinyl> getListOfVinyls() {
        return listOfVinyls;
    }

    @Override
    public String toString() {
        return "Vinyl{" +
                "band=" + band +
                ", type=" + type +
                '}';
    }
}
