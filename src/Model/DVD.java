package Model;

import java.util.Collections;
import java.util.Set;

public class DVD extends Product {
    private Band band;
    private Type type;

    public DVD(String title, String description, double price, Band band, Type type) {
        super(title, description, price);
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
