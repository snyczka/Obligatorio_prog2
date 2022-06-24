package entities;

import adt.tad.ArrayListOb;
import adt.tad.LinkedListOb;
import adt.tad.ListOb;
import adt.tad.SimpleNode;

public class Beer {

    private long id;
    private String name;
    private double abv;
    private ListOb<Review> reviews;
    private Style type;

    public Beer(long bId, String bName, double bAbv, Style btype){
        this.id = bId;
        this.name = bName;
        this.abv = bAbv;
        this.type = btype;
        this.reviews = new ArrayListOb<Review>(Review.class);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public Style getType() {
        return type;
    }

    public void setType(Style type) {
        this.type = type;
    }
}
