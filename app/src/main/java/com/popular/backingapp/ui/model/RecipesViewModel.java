package com.popular.backingapp.ui.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.popular.backingapp.repository.RecipeRepository;

import java.util.List;

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

    public void selectMovieReview() {
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
