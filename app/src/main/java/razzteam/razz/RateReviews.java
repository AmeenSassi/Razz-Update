package razzteam.razz;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RatingBar;

import java.io.Serializable;

/**
 * Created by Ameen on 4/12/2016.
 */
public class RateReviews implements Parcelable{
    private RatingBar Clean; // change the name of the rating to our desired name.
    private RatingBar Ambiance; //
    private RatingBar Fancy;
    private RatingBar Flavour;
    private RatingBar Staff;

    RateReviews(Parcel in) {
        this.Clean.setRating(in.readFloat());
        this.Ambiance.setRating(in.readFloat());
        this.Fancy.setRating(in.readFloat());
        this.Flavour.setRating(in.readFloat());
        this.Staff.setRating(in.readFloat());
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(getClean());
        dest.writeFloat(getAmbiance());
        dest.writeFloat(getFanciness());
        dest.writeFloat(getFlavour());
        dest.writeFloat(getStaff());
    }

    static final Parcelable.Creator<RateReviews> CREATOR
            = new Parcelable.Creator<RateReviews>() {

        public RateReviews createFromParcel(Parcel in) {
            return new RateReviews(in);
        }

        public RateReviews[] newArray(int size) {
            return new RateReviews[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void setClean(float num) {
        Clean.setRating(num);
    }

    public void setAmbiance(float num) {
        Ambiance.setRating(num);
    }

    public void setFanciness(float num) {
        Fancy.setRating(num);
    }

    public void setFlavour(float num) {
        Flavour.setRating(num);
    }

    public void setStaff(float num) {
        Staff.setRating(num);
    }

    public float getClean() {
        return Clean.getRating();
    }

    public float getAmbiance() {
        return Ambiance.getRating();
    }

    public float getFanciness() {
        return Fancy.getRating();
    }

    public float getFlavour() {
        return Flavour.getRating();
    }

    public float getStaff() {
        return Staff.getRating();
    }
}
