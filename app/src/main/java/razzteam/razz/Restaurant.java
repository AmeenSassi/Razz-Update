package razzteam.razz;

import android.widget.RatingBar;

import java.util.ArrayList;

/**
 * Created by Ameen on 4/5/2016.
 */
public class Restaurant {
    private String name;
    private String type;
    private String address;

    private String description;
    private int numOfReviews;
    private ArrayList<RateReviews> ratingList = new ArrayList<RateReviews>();


    Restaurant(){

    };

    public ArrayList<RateReviews> getRatingList() {
        return ratingList;
    }

    public void setRatingList(ArrayList<RateReviews> ratingList) {
        this.ratingList = ratingList;
    }

    public Restaurant(String name, String type, String address, String description) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.description = description;
    }

    public void setName(String n){
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setType(String n){ type = n; }

    public String getType() {
        return type;
    }

    public void setAddress(String n){ address = n; }

    public String getAddress() {
        return address;
    }

    public void setDescription(String d){
        description = d;
    }

    public String getDescription(){
        return name;
    }

    public void setClean(float num) {
        int i = ratingList.size();
        ratingList.get(i).setClean(num);
    }

    public void setAmbiance(float num) {
        int i = ratingList.size();
        ratingList.get(i).setAmbiance(num);
    }

    public void setFanciness(float num) {
        int i = ratingList.size();
        ratingList.get(i).setFanciness(num);
    }

    public void setFlavour(float num) {
        int i = ratingList.size();
        ratingList.get(i).setFlavour(num);
    }

    public void setStaff(float num) {
        int i = ratingList.size();
        ratingList.get(i).setStaff(num);
    }



    public float getClean(int i) {
        return ratingList.get(i).getClean();
    }

    public float getAmbiance(int i) {
        return ratingList.get(i).getAmbiance();
    }

    public float getFanciness(int i) {
        return ratingList.get(i).getFanciness();
    }

    public float getFlavour(int i) {
        return ratingList.get(i).getFlavour();
    }

    public float getStaff(int i) {
        return ratingList.get(i).getStaff();
    }

}
