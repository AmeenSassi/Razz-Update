package razzteam.razz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Restaurant> myRestaurants = new ArrayList<Restaurant>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        populateRestaurantList();
    }

    private void populateRestaurantList() {
        myRestaurants.add(new Restaurant("Taco Bell", "Colorado", "Denver", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Froyo", "Colorado", "Denver", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Stubens", "Colorado", "Denver", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Colorado", "Denver", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Colorado", "Denver", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Colorado", "Denver", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Colorado", "Denver", "Cheap Mexican food"));
    }
}
