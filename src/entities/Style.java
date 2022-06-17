package entities;

import adt.tad.SimpleNode;

public class Style {

    private String name;
    private SimpleNode<Beer> beers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleNode<Beer> getBeers() {
        return beers;
    }

    public void setBeers(SimpleNode<Beer> beers) {
        this.beers = beers;
    }
}
