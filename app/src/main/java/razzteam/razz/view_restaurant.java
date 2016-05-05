package razzteam.razz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class view_restaurant extends AppCompatActivity {

    private TextView name;
    private TextView address;
    private TextView type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //We retrieve an object in an intent here
        Restaurant restaurant = new Restaurant();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            restaurant = extras.getParcelable("RestaurantExtra");
        }


        //setting the text fields here so the information displayed is correct
        TextView NameTxt = (TextView) findViewById(R.id.Restaurant_name);
        NameTxt.setText(restaurant.getName());

        TextView AddressTxt = (TextView) findViewById(R.id.Address_text);
        AddressTxt.setText(restaurant.getAddress());

        TextView DescriptionTxt = (TextView) findViewById(R.id.rest_type_text);
        DescriptionTxt.setText(restaurant.getDescription());

        RatingBar cBar = (RatingBar) findViewById(R.id.clean_bar);
        cBar.setRating(restaurant.getClean(0));

        RatingBar aBar = (RatingBar) findViewById(R.id.ambianceBar);
        aBar.setRating(restaurant.getAmbiance(0));

        RatingBar flBar = (RatingBar) findViewById(R.id.flavourBar);
        flBar.setRating(restaurant.getFlavour(0));

        RatingBar fBar = (RatingBar) findViewById(R.id.fancyBar);
        fBar.setRating(restaurant.getFanciness(0));

        RatingBar sBar = (RatingBar) findViewById(R.id.staffBar);
        sBar.setRating(restaurant.getStaff(0));

    }


    //goes back to list screen from the view screen
    public void backButton_view(View view)
    {
        Intent startNewActivity = new Intent(this, List_Activity.class);
        startActivity(startNewActivity);
    }

}
