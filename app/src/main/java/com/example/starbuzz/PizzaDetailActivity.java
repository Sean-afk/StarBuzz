package com.example.starbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.starbuzz.Models.Pizzas;

public class PizzaDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PIZZA_ID = "pizzaId"; //We’ll use this constant to pass the ID of the pizza as extra information in the intent.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //Set the toolbar as the activity's app bar
        setSupportActionBar(findViewById(R.id.tool_bar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Enable the Up button.

        //Display details of the pizza
        int pizzaId = (Integer) getIntent().getExtras().get(EXTRA_PIZZA_ID);
        String pizzaName = Pizzas.pizzas[pizzaId].getName();
        TextView textView = findViewById(R.id.pizza_text);
        textView.setText(pizzaName);
        int pizzaImage = Pizzas.pizzas[pizzaId].getImageResourceID();
        ImageView imageView = findViewById(R.id.pizza_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,pizzaImage));
        imageView.setContentDescription(pizzaName);


    }
}