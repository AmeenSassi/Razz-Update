package razzteam.razz;

import android.widget.RatingBar;

/**
 * Created by Ameen on 4/12/2016.
 */
public class RateReviews {
    private RatingBar Clean; // change the name of the rating to our desired name.
    private RatingBar Ambiance; //
    private RatingBar Fancy;
    private RatingBar Flavour;
    private RatingBar Staff;

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
