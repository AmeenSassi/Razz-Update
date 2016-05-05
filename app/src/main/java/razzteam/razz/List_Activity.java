package razzteam.razz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    public static List<Restaurant> myNewRestaurants = new ArrayList<Restaurant>();
    public static List<Restaurant> myRestaurants = new ArrayList<Restaurant>();
    int index = 0;
    ListView list;
    boolean FirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabs = (FloatingActionButton) findViewById(R.id.fab);
        fabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(List_Activity.this, Add_Restaurant.class);
                startActivity(intent);
            }
        });

        //so myRestaurants doesn't have duplicates
        myRestaurants.clear();
        //populating restaurant list so functionality can be clearly seen
        populateRestaurantList();

        //adding the new restaurant that was created in prior activities (if there are any)
        Restaurant nRest;
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            nRest = extras.getParcelable("RestaurantExtra");
            myNewRestaurants.add(nRest);
        }

        myRestaurants.addAll(myNewRestaurants);

        Restaurant tempRes = new Restaurant("RESTAURANT", "n/a", "n/a", "n/a");
        myRestaurants.add(tempRes);
        populateListView();
    }

    public void populateRestaurantList() {

        Restaurant tempRes = new Restaurant("Froyo", "Dessert", "Aurora, CO", "Frozen yogurt with fun toppings");
        tempRes.setClean((float) 4);
        tempRes.setAmbiance((float) 3);
        tempRes.setFanciness((float) 1);
        tempRes.setFlavour((float) 3);
        tempRes.setStaff((float) 2);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Taco Bell", "Mexican", "Denver, CO", "Cheap Mexican fast food");
        tempRes.setClean((float) 2);
        tempRes.setAmbiance((float) 1);
        tempRes.setFanciness((float) 1);
        tempRes.setFlavour((float) 2);
        tempRes.setStaff((float) 1);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Stubens", "Diner", "Arvada, CO", "Revamped diner");
        tempRes.setClean((float) 4);
        tempRes.setAmbiance((float) 4);
        tempRes.setFanciness((float) 3);
        tempRes.setFlavour((float) 4);
        tempRes.setStaff((float) 5);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Jimmy John's", "Sandwich", "Castle Pines, CO", "Easy $$ sandwhich shop");
        tempRes.setClean((float) 4);
        tempRes.setAmbiance((float) 2);
        tempRes.setFanciness((float) 2);
        tempRes.setFlavour((float) 3);
        tempRes.setStaff((float) 1);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Olive Garden", "Sit-down", "Dever, CO", "Family dining with bar");
        tempRes.setClean((float) 5);
        tempRes.setAmbiance((float) 4);
        tempRes.setFanciness((float) 4);
        tempRes.setFlavour((float) 4);
        tempRes.setStaff((float) 3);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("3 Margaritas", "Mexican", "Golden, CO", "Sit-down Mexican food");
        tempRes.setClean((float) 2);
        tempRes.setAmbiance((float) 2);
        tempRes.setFanciness((float) 3);
        tempRes.setFlavour((float) 3);
        tempRes.setStaff((float) 4);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Fuzzy's", "Tex Mex", "Dever, CO", "Tex Mex with a lot of booze");
        tempRes.setClean((float) 4);
        tempRes.setAmbiance((float) 3);
        tempRes.setFanciness((float) 2);
        tempRes.setFlavour((float) 3);
        tempRes.setStaff((float) 4);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Mcdonalds", "Fast food", "Denver, CO", "Burgers and fast food");
        tempRes.setClean((float) 2);
        tempRes.setAmbiance((float) 1);
        tempRes.setFanciness((float) 1);
        tempRes.setFlavour((float) 2);
        tempRes.setStaff((float) 1);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Pizza Hut", "Pizza", "Dever, CO", "Pizza and salad bar");
        tempRes.setClean((float) 3);
        tempRes.setAmbiance((float) 2);
        tempRes.setFanciness((float) 2);
        tempRes.setFlavour((float) 3);
        tempRes.setStaff((float) 2);
        myRestaurants.add(tempRes);

        tempRes = new Restaurant("Starbucks", "CoffeeShop", "Dever, CO", "Gormet coffee at expensive prices");
        tempRes.setClean((float) 5);
        tempRes.setAmbiance((float) 4);
        tempRes.setFanciness((float) 2);
        tempRes.setFlavour((float) 4);
        tempRes.setStaff((float) 4);
        myRestaurants.add(tempRes);

    }

    //rendering the list
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
