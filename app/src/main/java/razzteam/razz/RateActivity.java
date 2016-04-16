package razzteam.razz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;

public class RateActivity extends AppCompatActivity {

    private TextView name;
    private RatingBar cleanliness;
    private RatingBar ambiance;
    private RatingBar fanciness;
    private RatingBar flvr;
    private RatingBar staff;
    private Button rate;

    public Restaurant toy;
    public RateReviews list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        name = (TextView) findViewById(R.id.Restaurant_Name);
        cleanliness = (RatingBar) findViewById(R.id.cleanRatingBar);
        ambiance = (RatingBar) findViewById(R.id.ambRatingBar);
        fanciness = (RatingBar) findViewById(R.id.fancyRatingBar);
        flvr = (RatingBar) findViewById(R.id.flavourRatingBar);
        staff = (RatingBar) findViewById(R.id.staffRatingBar);
        rate = (Button) findViewById(R.id.rateButton);

        toy = new Restaurant("Olive Garden", "aurora", "Colorado", "yay");


        name.setText(toy.getName());

        rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                toy.setClean(cleanliness.getRating());
                toy.setAmbiance(ambiance.getRating());
                toy.setFanciness(fanciness.getRating());
                toy.setFlavour(flvr.getRating());
                toy.setStaff(staff.getRating());
            }
        });
    }
}
