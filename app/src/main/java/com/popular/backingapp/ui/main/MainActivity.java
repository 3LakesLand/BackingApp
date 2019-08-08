package com.popular.backingapp.ui.main;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.detail.DetailActivity;
import com.popular.backingapp.ui.model.Recipe;
import com.popular.backingapp.ui.model.RecipeModel;
import com.popular.backingapp.ui.model.RecipesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The class loads all recipes with their ingredients and recipe steps and
 * represents the found recipe names.
 */
public class MainActivity extends AppCompatActivity implements RecipesAdapter.OnRecipeListener {

    private static final String COLON = ": ";

    @BindView(R.id.recipes_rv)
    RecyclerView recyclerView;

    @BindView(R.id.no_internet_found_tv)
    TextView noInternetFoundView;


    //for ButterKnife framework
    private Unbinder unbinder;


    /**
     * The method load all recipe data.
     *
     * @param savedInstanceState If non-null, this Activity is being re-constructed
     *                           from a previous saved state as given here
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recipes_activity);

        //bind the RecyclerView and the TextViews
        unbinder = ButterKnife.bind(this);

        //Set "recipes"-name in the toolbar
        if (getSupportActionBar() != null) {
            String actionBarText = getString(R.string.appwidget_text) + COLON +
                    getString(R.string.recipes_text);
            getSupportActionBar().setTitle(actionBarText);
        }

        loadRecipes();

    }

    /**
     * Load and Presentation of the recipes
     */
    private void loadRecipes() {
        final RecipesAdapter recipesAdapter = new RecipesAdapter(this);
        recyclerView.setAdapter(recipesAdapter);

        final RecipesViewModel recipesViewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);

        recipesViewModel.getRecipeListMutableLiveData().observe(this, recipes -> {
            recipesAdapter.setRecipeList(recipes);
            recipesAdapter.notifyDataSetChanged();
        });

        checkInternetAndSelectRecipes();
    }

    /**
     * The method loads the recipe data when there is an Internet connection.
     */
    private void checkInternetAndSelectRecipes() {
        final RecipesViewModel recipesViewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);
        if (recipesViewModel.isInternetConnection()) {
            noInternetFoundView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recipesViewModel.selectRecipes();
        } else {
            noInternetFoundView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    /**
     * When the view is destroyed, the binder is reset.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onRecipeClick(Recipe recipe) {
        RecipeModel.getInstance().setCurrentSelectedRecipe(recipe);

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        startActivity(intent);

    }

}
