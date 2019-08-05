package com.popular.backingapp.ui.detail;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.popular.backingapp.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_recipe_activity);


        if (savedInstanceState == null) {
            IngredientsFragment ingredientsFragment = new IngredientsFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.ingredients_fl, ingredientsFragment)
                    .commit();

            StepsFragment stepsFragment = new StepsFragment();

            fragmentManager.beginTransaction()
                    .add(R.id.steps_fl, stepsFragment)
                    .commit();
        }

    }


}
