package entities;

import java.util.Date;

public class Review {

    private long id;
    private Date date;
    private double overallScore;
    private double aromaScore;
    private double appearanceScore;
    private double flavourScore;
    private Brewery business;
    private User taster;

    public Review(long revId, Date revDate, double oScore, double arScore,
                  double apScore, double fScore, Brewery revBr, User revT){
        this.id = revId;
        this.date = revDate;
        this.overallScore = oScore;
        this.aromaScore = arScore;
        this.appearanceScore = apScore;
        this.flavourScore = fScore;
        this.business = revBr;
        this.taster = revT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public double getAromaScore() {
        return aromaScore;
    }

    public void setAromaScore(double aromaScore) {
        this.aromaScore = aromaScore;
    }

    public double getAppearanceScore() {
        return appearanceScore;
    }

    public void setAppearanceScore(double appearanceScore) {
        this.appearanceScore = appearanceScore;
    }

    public double getFlavourScore() {
        return flavourScore;
    }

    public void setFlavourScore(double flavourScore) {
        this.flavourScore = flavourScore;
    }

    public Brewery getBusiness() {
        return business;
    }

    public void setBusiness(Brewery business) {
        this.business = business;
    }

    public User getTaster() {
        return taster;
    }

    public void setTaster(User taster) {
        this.taster = taster;
    }
}
