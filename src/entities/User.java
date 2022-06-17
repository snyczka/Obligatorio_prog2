package entities;

import adt.tad.SimpleNode;

public class User {

    private String username;
    private SimpleNode<Review> reviews;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SimpleNode<Review> getReviews() {
        return reviews;
    }

    public void setReviews(SimpleNode<Review> reviews) {
        this.reviews = reviews;
    }
}
