package razzteam.razz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class Add_Restaurant extends AppCompatActivity {
    private String rest_name = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void button_to_rate_screen(View view)
    {
//        TextView toChange = (TextView) findViewById(R.id.add_rest_label);
//        toChange.setText(rest_name);

        EditText rName = (EditText) findViewById(R.id.editText_rest_name);
        EditText rType = (EditText) findViewById(R.id.editText_rest_type);
        EditText rAdd = (EditText) findViewById(R.id.editText_rest_address);
        EditText rDescription = (EditText) findViewById(R.id.editText_rest_description);
        //don't have a getter for average here because there is no average before thins is rated

        Restaurant nRest = new Restaurant(rName.getText().toString(), rType.getText().toString(), rAdd.getText().toString(), rDescription.getText().toString());

        //NEED TO SEND PARCELABLE HERE
        Intent resultIntent = new Intent(Add_Restaurant.this, RateActivity.class);
        resultIntent.putExtra("RestaurantExtra", nRest);

        startActivity(resultIntent);
    }

}
