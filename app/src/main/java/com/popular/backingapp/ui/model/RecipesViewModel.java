package com.popular.backingapp.ui.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.popular.backingapp.repository.RecipeRepository;

import java.util.List;

/**
 * The model contains all the data for the selected recipes with ingredients and recipe steps.
 * Because there is a separation between surfaces and database recipe data,
 * copies of the data are located here (via MutableLiveData).
 * The data is made available through the Recipe Repository.
 */
public class RecipesViewModel extends AndroidViewModel {
    private MutableLiveData<List<Recipe>> recipeListMutableLiveData;
    private RecipeRepository recipeRepository;


    /**
     * Constructor
     *
     * @param application needed for check internet connection
     */
    public RecipesViewModel(@NonNull Application application) {
        super(application);
        recipeRepository = new RecipeRepository(application);
        recipeListMutableLiveData = new MutableLiveData<>();
    }

    /**
     * The method selects recipes with ingredients and recipe steps.
     */
    public void selectRecipes() {
        recipeRepository.selectRecipes(recipeListMutableLiveData);
    }


    /**
     * Checks if there is an Internet connection.
     *
     * @return internet connection exists
     */
    public boolean isInternetConnection() {
        return recipeRepository.isInternetConnection();
    }


    public MutableLiveData<List<Recipe>> getRecipeListMutableLiveData() {
        return recipeListMutableLiveData;
    }
}
