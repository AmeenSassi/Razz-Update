package razzteam.razz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

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

        Intent inIntent = getIntent();
        Restaurant myRestaurant = (Restaurant) inIntent.getParcelableExtra("Restaurant");
        ArrayList<RateReviews> rating = (ArrayList) inIntent.getParcelableExtra("Rating");
        myRestaurant.setRatingList(rating);

        name = (TextView) findViewById(R.id.Restaurant_name);
        address = (TextView) findViewById(R.id.Address_text);
        type = (TextView) findViewById(R.id.rest_type_text);


        name.setText(myRestaurant.getName());
        address.setText(myRestaurant.getAddress());
        type.setText(myRestaurant.getType());

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }
<<<<<<< HEAD
=======

    public void tyler(View view)
    {
        //setContentView(R.layout.content_view_restaurant);

        Intent startNewActivity = new Intent(this, ListActivity.class);
        startActivity(startNewActivity);
    }

>>>>>>> 27ac7bc9d274d1170d90fc3cffd853048fce2275
}
