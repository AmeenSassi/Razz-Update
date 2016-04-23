package razzteam.razz;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ameen on 4/5/2016.
 */
public class Restaurant implements Parcelable {

    private String name;
    private String type;
    private String address;
    private int listPosition;

    private String description;
    private int numOfReviews;
    private ArrayList<RateReviews> ratingList = new ArrayList<RateReviews>();


    Restaurant(){

    };

    public Restaurant(Parcel in){
        this.name = in.readString();
        this.type = in.readString();
        this.address = in.readString();
        this.description = in.readString();
        this.numOfReviews = in.readInt();
        this.ratingList = new ArrayList<RateReviews>();
        // in.readTypedList(ratingList, RateReviews.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(address);
        dest.writeString(description);
        dest.writeInt(numOfReviews);
        dest.writeTypedList(ratingList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {

        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public ArrayList<RateReviews> getRatingList() {
        return ratingList;
    }

    public void setRatingList(ArrayList<RateReviews> ratingList) {
        this.ratingList = ratingList;
    }

    Restaurant(String name, String type, String address, String description, int average) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.description = description;
        this.listPosition = average;
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
        return description;
    }

    public int getListPosition() {return listPosition;}

    public int setListPosition(int i) { return listPosition;}

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

    public float ambianceAVG(){
        float average = 0;
        for(int i = 0; i < ratingList.size(); i++)
        {
            average += ratingList.get(i).getAmbiance();
        }
        average = average/(ratingList.size());

        return average;
    }

    public float cleanAVG(){
        float average = 0;
        for(int i = 0; i < ratingList.size(); i++)
        {
            average += ratingList.get(i).getClean();
        }
        average = average/(ratingList.size());

        return average;
    }

    public float fancyAVG(){
        float average = 0;
        for(int i = 0; i < ratingList.size(); i++)
        {
            average += ratingList.get(i).getFanciness();
        }
        average = average/(ratingList.size());

        return average;
    }

    public float flavorAVG(){
        float average = 0;
        for(int i = 0; i < ratingList.size(); i++)
        {
            average += ratingList.get(i).getFlavour();
        }
        average = average/(ratingList.size());

        return average;
    }

    public float staffAVG(){
        float average = 0;
        for(int i = 0; i < ratingList.size(); i++)
        {
            average += ratingList.get(i).getStaff();
        }
        average = average/(ratingList.size());

        return average;
    }



}
