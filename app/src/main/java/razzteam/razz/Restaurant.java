package razzteam.razz;

import android.os.Parcel;
import android.os.Parcelable;
//import android.widget.RatingBar;
import java.util.ArrayList;
//import java.util.Random;

/**
 * Created by Ameen on 4/5/2016.
 */
public class Restaurant implements Parcelable {

    private String name;
    private String type;
    private String address;

    private String description;
    private int numOfReviews;
    private float[] clean = new float[100];
    private int cleanUsed;
    private float[] ambiance = new float[100];
    private int ambianceUsed;
    private float[] flavour = new float[100];
    private int flavourUsed;
    private float[] fancy = new float[100];
    private int fancyUsed;
    private float[] staff = new float[100];
    private int staffUsed;

    private float average;
    //private RateReviews review = new RateReviews();
    //private ArrayList<RateReviews> ratingList = new ArrayList<RateReviews>();

    Restaurant(){

    };

    public Restaurant(Parcel in){
        this.name = in.readString();
        this.type = in.readString();
        this.address = in.readString();
        this.description = in.readString();
        this.numOfReviews = in.readInt();
        this.clean = new float[100];
        in.readFloatArray(clean);
        this.ambiance = new float[100];
        in.readFloatArray(ambiance);
        this.flavour = new float[100];
        in.readFloatArray(flavour);
        this.fancy = new float[100];
        in.readFloatArray(fancy);
        this.staff = new float[100];
        in.readFloatArray(staff);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(address);
        dest.writeString(description);
        dest.writeInt(numOfReviews);
        dest.writeFloatArray(clean);
        dest.writeFloatArray(ambiance);
        dest.writeFloatArray(flavour);
        dest.writeFloatArray(fancy);
        dest.writeFloatArray(staff);

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

    /*public ArrayList<RateReviews> getRatingList() {
        return ratingList;
    }

    public void setRatingList(ArrayList<RateReviews> ratingList) {
        this.ratingList = ratingList;
    }
    */

    Restaurant(String name, String type, String address, String description) {
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
        return description;
    }


    public void setClean(Float num) {
        int i = cleanUsed;
        cleanUsed++;
        clean[i] = num;
    }

    public void setAmbiance(float num) {
        int i = ambianceUsed;
        ambianceUsed++;
        ambiance[i] = num;
    }

    public void setFanciness(float num) {
        int i = fancyUsed;
        fancyUsed++;
        fancy[i] = num;
    }

    public void setFlavour(float num) {
        int i = flavourUsed;
        flavourUsed++;
        flavour[i] = num;
    }

    public void setStaff(float num) {
        int i = staffUsed;
        staffUsed++;
        staff[i] = num;
    }



    public float getClean(int i) {
        return clean[i];
    }

    public float getAmbiance(int i) {
        return ambiance[i];
    }

    public float getFanciness(int i) {
        return fancy[i];
    }

    public float getFlavour(int i) {
        return flavour[i];
    }

    public float getStaff(int i) {
        return staff[i];
    }

    public float ambianceAVG(){
        float average = 0;
        for(int i = 0; i < ambianceUsed; i++)
        {
            average += ambiance[i];
        }
        average = average/(ambianceUsed);

        return average;
    }

    public float cleanAVG(){
        float average = 0;
        for(int i = 0; i < cleanUsed; i++)
        {
            average += clean[i];
        }
        average = average/(cleanUsed);

        return average;
    }

    public float fancyAVG(){
        float average = 0;
        for(int i = 0; i < fancyUsed; i++)
        {
            average += fancy[i];
        }
        average = average/(fancyUsed);

        return average;
    }

    public float flavorAVG(){
        float average = 0;
        for(int i = 0; i < flavourUsed; i++)
        {
            average += flavour[i];
        }
        average = average/(flavourUsed);

        return average;
    }

    public float staffAVG(){
        float average = 0;
        for(int i = 0; i < staffUsed; i++)
        {
            average += staff[i];
        }
        average = average/(staffUsed);

        return average;
    }

    public float getAverage(){
        return average;
    }

    public void setAverage(){
        float cleanAVG = this.cleanAVG();
        float ambianceAVG = this.ambianceAVG();
        float fancyAVG = this.fancyAVG();
        float flavorAVG = this.flavorAVG();
        float staffAVG = this.staffAVG();

        average = cleanAVG + ambianceAVG + fancyAVG + flavorAVG + staffAVG;
        average = average/5;
    }


}
