package razzteam.razz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class List_Activity extends AppCompatActivity  {

    public List<Restaurant> myRestaurants = new ArrayList<Restaurant>();
    int index = 0;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        populateRestaurantList();
        populateListView();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(List_Activity.this, Add_Restaurant.class);
                startActivity(intent);
            }
        });

        Restaurant nRest = new Restaurant();
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            nRest = extras.getParcelable("RestaurantExtra");
            myRestaurants.add(nRest);
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        index = list.getFirstVisiblePosition();
    }

    @Override
    public void onResume(){
        super.onResume();
        if(list != null){
            if(list.getCount() > index){
                list.setSelectionFromTop(index, 0);
            }
            else{
                list.setSelectionFromTop(0,0);
            }
        }
    }


    public void populateRestaurantList() {
        myRestaurants.add(new Restaurant("Taco Bell", "Mexican", "Dever, CO", "Cheap Mexican fast food"));
        myRestaurants.add(new Restaurant("Froyo", "Dessert", "Aurora, CO", "Frozen yogurt with fun toppings"));
        myRestaurants.add(new Restaurant("Stubens", "Diner", "Arvada, CO", "Revamped diner"));
        myRestaurants.add(new Restaurant("3 Margaritas", "Mexican", "Golden, CO", "Sit-down Mexican food"));
        myRestaurants.add(new Restaurant("Jimmy John's", "Sandwhich", "Castle Pines, CO", "Easy sandwich shop"));
        myRestaurants.add(new Restaurant("Olive Garden", "Sit-down", "Dever, CO", "Family dining"));
        myRestaurants.add(new Restaurant("Fuzzy's", "Tex Mex", "Dever, CO", "Tex Mex with a lot of booze"));
        myRestaurants.add(new Restaurant("Mcdonalds", "Fast food", "Dever, CO", "Burgers and fast food"));
        myRestaurants.add(new Restaurant("Pizza Hut", "Pizza", "Dever, CO", "Pizza and salad bar"));
        myRestaurants.add(new Restaurant("Starbucks", "CoffeeShop", "Dever, CO", "Gormet coffee at expensive prices"));
    }
    private void populateListView(){
        ArrayAdapter<Restaurant> adapter = new MyListAdapter();
        list = (ListView) findViewById(R.id.restaurantListView);
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

            //Find the restaurant to work with
            Restaurant currentRestaurant = myRestaurants.get(position);

            //set the tag/position of the button
            Button viewButton = (Button) findViewById(R.id.buttonToView);
            viewButton.setTag(position);
            viewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) { //STARTS THE VIEW RESTAURANT ACTIVITY BY BUTTON PRESS
                    int position = (Integer) arg0.getTag();
                    Intent resultIntent = new Intent(List_Activity.this, view_restaurant.class);
                    resultIntent.putExtra("RestaurantExtra", myRestaurants.get(position));

                    startActivity(resultIntent);
                }
            });

            //Fill in the view
            TextView Nametxt = (TextView) findViewById(R.id.NameText);
            Nametxt.setText(currentRestaurant.getName());

            TextView Addresstxt = (TextView) findViewById(R.id.AddressText);
            Addresstxt.setText(currentRestaurant.getAddress());

            TextView Typetxt = (TextView) findViewById(R.id.TypeText);
            Typetxt.setText(currentRestaurant.getType());

            RatingBar Ratingtxt = (RatingBar) findViewById(R.id.ratingBar);
            Ratingtxt.setRating(currentRestaurant.getAverage());

            return itemView;
        }
    }
}
