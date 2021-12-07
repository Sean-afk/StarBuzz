package com.example.starbuzz.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starbuzz.Adapters.CaptionedImageAdapter;
import com.example.starbuzz.Models.Pizzas;
import com.example.starbuzz.PizzaDetailActivity;
import com.example.starbuzz.R;


public class PizzaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);

        String[] pizzaNames = new String[Pizzas.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Pizzas.pizzas[i].getName();
        }

        //Add the pizza names to an array of Strings, and the pizza images to an array of ints.

        int[] pizzaImages = new int[Pizzas.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizzas.pizzas[i].getImageResourceID();
        }

        CaptionedImageAdapter adapter = new CaptionedImageAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(gridLayoutManager);

        adapter.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position);
                startActivity(intent);
       //This implements the Listener onClick() method. It starts PizzaDetailActivity, passing it the ID of the pizza the user chose.
            }
        });

        return pizzaRecycler;
    }
}