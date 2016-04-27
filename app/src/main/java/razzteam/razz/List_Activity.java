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

    public static List<Restaurant> myRestaurants = new ArrayList<Restaurant>();
    int index = 0;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //populateRestaurantList();
        //populateListView();


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
        populateListView();

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
        //--------------------------------------------------
        myRestaurants.get(0).setClean((float)5);
        myRestaurants.get(0).setAmbiance((float)3);
        myRestaurants.get(0).setFanciness((float)4);
        myRestaurants.get(0).setFlavour((float)2);
        myRestaurants.get(0).setStaff((float) 5);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Froyo", "Dessert", "Aurora, CO", "Frozen yogurt with fun toppings"));
        //--------------------------------------------------
        myRestaurants.get(1).setClean((float) 5);
        myRestaurants.get(1).setAmbiance((float) 5);
        myRestaurants.get(1).setFanciness((float) 4);
        myRestaurants.get(1).setFlavour((float) 1);
        myRestaurants.get(1).setStaff((float) 3);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Stubens", "Diner", "Arvada, CO", "Revamped diner"));
        //--------------------------------------------------
        myRestaurants.get(2).setClean((float) 5);
        myRestaurants.get(2).setAmbiance((float) 4);
        myRestaurants.get(2).setFanciness((float) 1);
        myRestaurants.get(2).setFlavour((float) 2);
        myRestaurants.get(2).setStaff((float) 5);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("3 Margaritas", "Mexican", "Golden, CO", "Sit-down Mexican food"));
        //--------------------------------------------------
        myRestaurants.get(3).setClean((float) 3);
        myRestaurants.get(3).setAmbiance((float) 3);
        myRestaurants.get(3).setFanciness((float) 3);
        myRestaurants.get(3).setFlavour((float) 3);
        myRestaurants.get(3).setStaff((float) 3);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Jimmy John's", "Sandwhich", "Castle Pines, CO", "Easy sandwich shop"));
        //--------------------------------------------------
        myRestaurants.get(4).setClean((float) 4);
        myRestaurants.get(4).setAmbiance((float) 4);
        myRestaurants.get(4).setFanciness((float) 3);
        myRestaurants.get(4).setFlavour((float) 1);
        myRestaurants.get(4).setStaff((float) 2);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Olive Garden", "Sit-down", "Dever, CO", "Family dining"));
        //--------------------------------------------------
        myRestaurants.get(5).setClean((float) 5);
        myRestaurants.get(5).setAmbiance((float) 5);
        myRestaurants.get(5).setFanciness((float) 5);
        myRestaurants.get(5).setFlavour((float) 5);
        myRestaurants.get(5).setStaff((float) 5);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Fuzzy's", "Tex Mex", "Dever, CO", "Tex Mex with a lot of booze"));
        //--------------------------------------------------
        myRestaurants.get(6).setClean((float) 4);
        myRestaurants.get(6).setAmbiance((float) 4);
        myRestaurants.get(6).setFanciness((float) 4);
        myRestaurants.get(6).setFlavour((float) 4);
        myRestaurants.get(6).setStaff((float) 4);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Mcdonalds", "Fast food", "Dever, CO", "Burgers and fast food"));
        //--------------------------------------------------
        myRestaurants.get(7).setClean((float) 3);
        myRestaurants.get(7).setAmbiance((float) 3);
        myRestaurants.get(7).setFanciness((float) 3);
        myRestaurants.get(7).setFlavour((float) 3);
        myRestaurants.get(7).setStaff((float) 3);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Pizza Hut", "Pizza", "Dever, CO", "Pizza and salad bar"));
        //--------------------------------------------------
        myRestaurants.get(8).setClean((float) 2);
        myRestaurants.get(8).setAmbiance((float) 2);
        myRestaurants.get(8).setFanciness((float) 2);
        myRestaurants.get(8).setFlavour((float) 2);
        myRestaurants.get(8).setStaff((float) 2);
        //---------------------------------------------------
        myRestaurants.add(new Restaurant("Starbucks", "CoffeeShop", "Dever, CO", "Gormet coffee at expensive prices"));
        //--------------------------------------------------
        myRestaurants.get(9).setClean((float)1);
        myRestaurants.get(9).setAmbiance((float)1);
        myRestaurants.get(9).setFanciness((float)1);
        myRestaurants.get(9).setFlavour((float)1);
        myRestaurants.get(9).setStaff((float)1);
        //---------------------------------------------------
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
