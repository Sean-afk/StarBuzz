package com.example.starbuzz.Models;

import com.example.starbuzz.R;

public class Pizzas {
    private String name;
    private int imageResourceID;

    private Pizzas(String name, int imageResourceID) {
        this.name = name;
        this.imageResourceID = imageResourceID;
    }

    public static final Pizzas[] pizzas={
            new Pizzas("Diavolo", R.drawable.diavolo),
            new Pizzas("Funghi",R.drawable.funghi)
    };

    public String getName() {
        return name;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

}
