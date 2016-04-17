package razzteam.razz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class List_Activity extends ListActivity {

    public List<Restaurant> myRestaurants = new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        populateRestaurantList();
        populateListView();
    }

    //****The OnListItemClick function with putExtra stuff
    @Override
    protected void onListItemClick(ListView list, View v, int position, long id) {
        Restaurant item = (Restaurant) getListAdapter().getItem(position);
        ArrayList<RateReviews> itemRating = item.getRatingList();
        Intent toViewActivity = new Intent(this, view_restaurant.class);
        toViewActivity.putExtra("Restaurant", item);
        toViewActivity.putExtra("Rating", itemRating);
    }
    //*********************************************************

    /*public void sendMessage(View view){ //should go to the view_restaurant of this specific restaurant
        Intent toViewActivity = new Intent(this, view_restaurant.class);
    }*/

    public void populateRestaurantList() {
        myRestaurants.add(new Restaurant("Taco Bell", "Mexican", "Dever, CO", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Froyo", "Mexican", "Dever, CO", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Stubens", "Mexican", "Dever, CO", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Mexican", "Dever, CO", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Mexican", "Dever, CO", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Mexican", "Dever, CO", "Cheap Mexican food"));
        myRestaurants.add(new Restaurant("Taco Bell", "Mexican", "Dever, CO", "Cheap Mexican food"));
    }
    private void populateListView(){
        ArrayAdapter<Restaurant> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.restaurantListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Restaurant> {
        public MyListAdapter() {
            super(List_Activity.this, R.layout.itemlayout, myRestaurants);
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

            return itemView;
        }
    }
}
