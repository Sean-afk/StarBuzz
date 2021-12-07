package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    private TextView name, description;
    private ImageView imageView;

    public static final String EXTRA_DRINKID = "drinkId";  //Add EXTRA_DRINKID as a constant.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        imageView = findViewById(R.id.photo);

        int drinkId = (int) getIntent().getExtras().get(EXTRA_DRINKID); ////Get the drink from the intent
        Drink drink = Drink.drinks[drinkId];  //Use the drinkId to get details of the drink the user chose.



        name.setText(drink.getName());  //Populate the drink name
        description.setText(drink.getDescription());   //Populate the drink description
        imageView.setImageResource(drink.getImageResourceId());   //Populate the drink image
        imageView.setContentDescription(drink.getName());
    }
}
