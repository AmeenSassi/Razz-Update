package razzteam.razz;

import android.widget.RatingBar;
/**
 * Created by Ameen on 4/5/2016.
 */
public class Restaurant {
    private String name;
    private String city;
    private String state;
    private String description;
    public RatingList ratingList;


    Restaurant(){

    };

    Restaurant(String n, String c, String s, String d){
        name = n;
        city = c;
        state = s;
        description = d;

    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
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
        ratingList.setClean(num);
    }

    public void setAmbiance(float num) {
        ratingList.setAmbiance(num);
    }

    public void setFanciness(float num) {
        ratingList.setFanciness(num);
    }

    public void setFlavour(float num) {
        ratingList.setFlavour(num);
    }

    public void setStaff(float num) {
        ratingList.setStaff(num);
    }



    public float getClean() {
        return ratingList.getClean();
    }

    public float getAmbiance() {
        return ratingList.getAmbiance();
    }

    public float getFanciness() {
        return ratingList.getFanciness();
    }

    public float getFlavour() {
        return ratingList.getFlavour();
    }

    public float getStaff() {
        return ratingList.getStaff();
    }

}
