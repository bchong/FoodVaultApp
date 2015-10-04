package com.foodvault.foodvault;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        DatabaseHandler db = new DatabaseHandler(this);
        db.addRecipe(new Recipe(1, "Enchiladas", "https://allrecipes.com", "40", "flour", "4",
                "Great Recipe"));
        Intent myIntent = getIntent(); // gets the previously created intent
        String idString = myIntent.getStringExtra("ID");
        int ID = Integer.parseInt(idString);
        Recipe thisRecipe = db.getRecipe(ID);

        TextView recipeName = (TextView) findViewById(R.id.textView1);
        recipeName.setText(thisRecipe.getName());
        TextView recipeUrl = (TextView) findViewById(R.id.textView2);
        recipeUrl.setText(thisRecipe.getUrl());
        TextView recipePrepTime = (TextView) findViewById(R.id.textView3);
        recipePrepTime.setText(thisRecipe.getPrepTime()+" min");
        TextView recipeIngredients = (TextView) findViewById(R.id.textView4);
        recipeIngredients.setText(thisRecipe.getIngredients());
        TextView recipeRating = (TextView) findViewById(R.id.textView5);
        recipeRating.setText(thisRecipe.getRating());

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        float rating = Float.parseFloat(thisRecipe.getRating());
        ratingBar.setRating(rating);

        TextView recipeComments = (TextView) findViewById(R.id.textView6);
        recipeComments.setText(thisRecipe.getComments());
    }
}
