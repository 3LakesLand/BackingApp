package com.popular.backingapp.ui.main;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.detail.DetailActivity;
import com.popular.backingapp.ui.model.Recipe;
import com.popular.backingapp.ui.model.RecipeModel;
import com.popular.backingapp.ui.model.RecipesViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements RecipesAdapter.OnRecipeListener {

    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;

    //for ButterKnife framework
    private Unbinder unbinder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recipes_activity);

        //bind the RecyclerView and the TextViews
        unbinder = ButterKnife.bind(this);

        loadRecipes();

    }

    private void loadRecipes() {
        final RecipesAdapter recipesAdapter= new RecipesAdapter(this);
        recyclerView.setAdapter(recipesAdapter);

        final RecipesViewModel recipesViewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);

        recipesViewModel.getRecipeListMutableLiveData().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                recipesAdapter.setRecipeList(recipes);
                recipesAdapter.notifyDataSetChanged();
            }
        });

        checkInternetAndSelectRecipes();
    }

    private void checkInternetAndSelectRecipes() {
        final RecipesViewModel recipesViewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);
        if (recipesViewModel.isInternetConnection()) {
            recipesViewModel.selectMovieReview();
        } else {
            //ToDo: No Internet
            Toast.makeText(this, "No Internet", Toast.LENGTH_LONG).show();
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
