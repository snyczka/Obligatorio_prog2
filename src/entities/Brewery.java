package entities;

import adt.tad.SimpleNode;

public class Brewery {
    private long id;
    private String name;
    private SimpleNode<Review> reviews;
    private SimpleNode<Beer> beers;

    public SimpleNode<Beer> getBeers() {
        return beers;
    }

    public void setBeers(SimpleNode<Beer> beers) {
        this.beers = beers;
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

    public SimpleNode<Review> getReviews() {
        return reviews;
    }

    public void setReviews(SimpleNode<Review> reviews) {
        this.reviews = reviews;
    }
}
