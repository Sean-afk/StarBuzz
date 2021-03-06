package com.example.starbuzz;

import androidx.dynamicanimation.animation.SpringAnimation;

public class Drink {
    private String name,description;
    private int imageResourceId;

    public static final Drink[] drinks = {
            new Drink("Latte","A couple of espresso shots with steamed milk",R.drawable.latte),
            new Drink("Cappuccino","Espresso, hot milk, and a steamed milk foam",R.drawable.cappuccino),
            new Drink("Filter","Highest quality beans roasted and brewed fresh",R.drawable.filter),
    };

    public Drink(String name, String description, int imageResourceId) {     //The Drink constructor//
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

 //These are getters and setters for the private variables.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String toString(){
        return this.name;  //The String representation of a Drink is its name.
    }
}
