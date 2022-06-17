package entities;

import adt.tad.SimpleNode;

public class Beer {

    private long id;
    private String name;
    private double abv;
    private SimpleNode<Review> reviews;

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

    public SimpleNode<Review> getReviews() {
        return reviews;
    }

    public void setReviews(SimpleNode<Review> reviews) {
        this.reviews = reviews;
    }
}
