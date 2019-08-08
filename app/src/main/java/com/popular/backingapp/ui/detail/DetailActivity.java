package com.popular.backingapp.ui.detail;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.popular.backingapp.IngredientsWidgetProvider;
import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.RecipeModel;

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

            //Set recipe name in the toolbar
            if (getSupportActionBar() != null) {
                String actionBarText = getString(R.string.appwidget_text) + ": " +
                        RecipeModel.getInstance().getCurrentSelectedRecipe().getName();
                getSupportActionBar().setTitle(actionBarText);
            }

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getApplicationContext());
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(getApplicationContext(), IngredientsWidgetProvider.class));
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.widget_ingredients_lv);
            IngredientsWidgetProvider.updateRecipeWidget(getApplicationContext(), appWidgetManager, appWidgetIds, RecipeModel.getInstance().getCurrentSelectedRecipe().getName());
        }



    }


}
