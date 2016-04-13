package razzteam.razz;

import android.widget.RatingBar;

import java.util.ArrayList;

/**
 * Created by Ameen on 4/5/2016.
 */
public class Restaurant {
    private String name;
    private String city;
    private String state;
    private String description;
    private int numOfReviews;
    private ArrayList<RatingList> ratingList = new ArrayList<RatingList>();


    Restaurant(){

    };

    public Restaurant(String name, String city, String state, String description) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.description = description;
    }

    public void setName(String n){
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setCity(String c){
        city = c;
    }

    public String getCity(){
        return city;
    }

    public void setState(String s){
        state = s;
    }

    public String getState(){
        return state;
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
