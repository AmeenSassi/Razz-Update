package razzteam.razz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
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

        Restaurant restaurant = new Restaurant();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            restaurant = extras.getParcelable("RestaurantExtra");
        }


        TextView NameTxt = (TextView) findViewById(R.id.Restaurant_name);
        NameTxt.setText(restaurant.getName());

        TextView AddressTxt = (TextView) findViewById(R.id.Address_text);
        AddressTxt.setText(restaurant.getAddress());

        TextView DescriptionTxt = (TextView) findViewById(R.id.rest_type_text);
        DescriptionTxt.setText(restaurant.getDescription());



    }



    public void tyler(View view)
    {
        Intent startNewActivity = new Intent(this, List_Activity.class);
        startActivity(startNewActivity);
    }

}
