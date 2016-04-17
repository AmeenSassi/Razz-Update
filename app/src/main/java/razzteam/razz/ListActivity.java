package razzteam.razz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public List<Restaurant> myRestaurants = new ArrayList<Restaurant>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        populateRestaurantList();
        populateListView();
    }

    public void sendMessage(View view){ //should go to the view_restaurant of this specific restaurant
        Intent startNewActivity = new Intent(this, view_restaurant.class);
        startActivity(startNewActivity);
    }

    public void populateRestaurantList() {
        myRestaurants.add(new Restaurant("Taco Bell1", "Mexican", "Dever, CO", "Cheap Mexican food", 5));
        myRestaurants.add(new Restaurant("Froyo", "Mexican", "Aurora, CO", "Frozen yogurt", 3));
        myRestaurants.add(new Restaurant("Stubens", "Diner", "Arvada, CO", "Revamped diner", 2));
        myRestaurants.add(new Restaurant("Taco Bell2", "Mexican", "Golden, CO", "Cheap Mexican food", 1));
        myRestaurants.add(new Restaurant("Jimmy John's", "Sandwhich", "Castle Pines, CO", "Sandwich shop", 5));
        myRestaurants.add(new Restaurant("Olive Garden", "Mexican", "Dever, CO", "Family dining", 4));
        myRestaurants.add(new Restaurant("Fuzzy's", "Tex Mex", "Dever, CO", "Tex Mex", 3));
        myRestaurants.add(new Restaurant("Taco Bell3", "Mexican", "Dever, CO", "Cheap Mexican food", 2));
        myRestaurants.add(new Restaurant("Taco Bell4", "Mexican", "Dever, CO", "Cheap Mexican food", 3));
        myRestaurants.add(new Restaurant("Taco Bell5", "Mexican", "Dever, CO", "Cheap Mexican food", 1));
    }
    private void populateListView(){
        ArrayAdapter<Restaurant> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.restaurantListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Restaurant> {
        public MyListAdapter() {
            super(ListActivity.this, R.layout.itemlayout, myRestaurants);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            //make sure we have a view to work with
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.itemlayout, parent, false);
            }

            //Find the car to work with
            Restaurant currentRestaurant = myRestaurants.get(position);

            //Fill in the view
            TextView Nametxt = (TextView) findViewById(R.id.NameText);
            Nametxt.setText(currentRestaurant.getName());

            TextView Addresstxt = (TextView) findViewById(R.id.AddressText);
            Addresstxt.setText(currentRestaurant.getAddress());

            TextView Descriptiontxt = (TextView) findViewById(R.id.DescriptionText);
            Descriptiontxt.setText(currentRestaurant.getDescription());

            //RatingBar Ratingtxt = (RatingBar) findViewById(R.id.ratingBarView);
            //Ratingtxt.setRating(currentRestaurant.getAverage());

            return itemView;
        }
    }
}
