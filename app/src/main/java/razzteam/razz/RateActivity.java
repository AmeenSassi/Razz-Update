package razzteam.razz;

import android.content.Intent;
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


//            String restName = restData.getString("newRestName");
//            String restType = restData.getString("newRestType");
//            String restAddress = restData.getString("newRestAddress");
//            String restDescription = restData.getString("newRestDescription");
//            int restAverage = restData.getInt("newRestAverage");


            //  NEED TO RECEIVE PARCELABLE HERE

            toy = new Restaurant();
            Bundle extras = getIntent().getExtras();
            if(extras != null){
                toy = extras.getParcelable("RestaurantExtra");
            }





            name = (TextView) findViewById(R.id.Restaurant_Name);
            cleanliness = (RatingBar) findViewById(R.id.cleanRatingBar);
            ambiance = (RatingBar) findViewById(R.id.ambRatingBar);
            fanciness = (RatingBar) findViewById(R.id.fancyRatingBar);
            flvr = (RatingBar) findViewById(R.id.flavourRatingBar);
            staff = (RatingBar) findViewById(R.id.staffRatingBar);
            rate = (Button) findViewById(R.id.rateButton);



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

    public void rateButton(View view)
    {

        //I think this is all the necessary fields to set
        toy.setStaff(staff.getRating());
        toy.setClean(cleanliness.getRating());
        toy.setAmbiance(ambiance.getRating());
        toy.setFanciness(fanciness.getRating());
        toy.setFlavour(flvr.getRating());
        toy.setStaff(staff.getRating());


        Intent resultIntent = new Intent(RateActivity.this, List_Activity.class);
        resultIntent.putExtra("RestaurantExtra", toy);

        startActivity(resultIntent);
    }
}
