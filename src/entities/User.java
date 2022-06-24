package entities;

import adt.tad.SimpleNode;

public class User {

    private String username;

    private int reviews;

    public User(String name){
        this.username = name;
        this.reviews = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
}
