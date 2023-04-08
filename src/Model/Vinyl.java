package Model;

import Model.Type;
import Model.Product;

import java.util.*;

public class Vinyl extends Product {
    private Band band;
    private Type type;

    public Vinyl(int id, String title, String description, double price, Band band, Type type) {
        super(id, title, description, price);
        this.band = band;
        this.type = type;
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
}
