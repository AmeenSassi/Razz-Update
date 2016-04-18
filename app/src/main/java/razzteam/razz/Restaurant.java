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
    private int average;

    private String description;
    private int numOfReviews;
    private ArrayList<RateReviews> ratingList = new ArrayList<RateReviews>();


    Restaurant(){

    };

    Restaurant(Parcel in){
        this.name = in.readString();
        this.type = in.readString();
        this.address = in.readString();
        this.description = in.readString();
        this.numOfReviews = in.readInt();
        this.ratingList = new ArrayList<RateReviews>();
        in.readTypedList(ratingList, RateReviews.CREATOR);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(address);
        dest.writeString(description);
        dest.writeInt(numOfReviews);
        dest.writeTypedList(ratingList);
    }


    public int describeContents() {
        return 0;
    }

    static final Parcelable.Creator<Restaurant> CREATOR
            = new Parcelable.Creator<Restaurant>() {


        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

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
        this.average = average;
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

    public int getAverage() {return average;}

    public int setAverage(int i) { return average;}

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
