package razzteam.razz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;

public class Razz extends AppCompatActivity {

    private TextView name;
    private RatingBar clean;
    private RatingBar amb;
    private RatingBar fancy;
    private RatingBar flvr;
    private RatingBar staff;
    private Button rate;

    public Restaurant toy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razz);

        name = (TextView) findViewById(R.id.Restaurant_Name);
        clean = (RatingBar) findViewById(R.id.cleanRatingBar);
        amb =  (RatingBar) findViewById(R.id.ambRatingBar);
        fancy = (RatingBar) findViewById(R.id.fancyRatingBar);
        flvr = (RatingBar) findViewById(R.id.flavourRatingBar);
        staff = (RatingBar) findViewById(R.id.staffRatingBar);
        rate = (Button) findViewById(R.id.rateButton);

        toy = new Restaurant("Olive Garden", "aurora", "Colorado", "yay");

        name.setText(toy.getName());


    }

    //rate.setOnClickListener(new View.OnClickListener() {
    //    public void onClick(View v) {
            
    //    }
    //});
}
