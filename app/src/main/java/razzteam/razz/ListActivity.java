package razzteam.razz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Restaurant> myRestaurants = new ArrayList<Restaurant>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        populateRestaurantList();
        populateListView();
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
    private void populateListView(){
        ArrayAdapter<Restaurant> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.restaurantListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Restaurant> {
        public MyListAdapter() {
            super(ListActivity.this, R.layout.activity_list, myRestaurants);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            //make sure we have a view to work with
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.activity_list, parent, false);
            }

            //Find the car to work with
            Restaurant currentRestaurant = myRestaurants.get(position);

            //Fill in the view
            TextView Nametxt = (TextView) findViewById(R.id.NameText);
            Nametxt.setText(currentRestaurant.getName());

            TextView Citytxt = (TextView) findViewById(R.id.CityText);
            Nametxt.setText(currentRestaurant.getName());

            TextView Statetxt = (TextView) findViewById(R.id.StateText);
            Nametxt.setText(currentRestaurant.getName());


            return itemView;
        }
    }
}
