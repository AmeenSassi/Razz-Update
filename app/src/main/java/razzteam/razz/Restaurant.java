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
    private RatingBar Clean; // change the name of the rating to our desired name.
    private RatingBar Ambiance; //
    private RatingBar Fancy;
    private RatingBar Flavour;
    private RatingBar Staff;


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

    public void setStarRating(RatingBar star, float num) {
        star.setRating(num);
    }

    public float getStarRating(RatingBar star) {
        return star.getRating();
    }

}
