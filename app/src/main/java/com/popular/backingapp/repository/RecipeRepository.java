package com.popular.backingapp.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.popular.backingapp.data.network.ConnectionHelper;
import com.popular.backingapp.data.remote.recipes.db.SelectRecipesAsyncTask;
import com.popular.backingapp.ui.model.Recipe;

import java.util.List;

public class RecipeRepository {
    private Application application;


    public RecipeRepository(@NonNull Application application) {
        this.application = application;
    }

    /**
     * Finds the recipes from the external recipe database.
     *
     * @param recipeListMutableLiveData contains all found recipe information
     */
    public void selectRecipes(MutableLiveData<List<Recipe>> recipeListMutableLiveData) {
        new SelectRecipesAsyncTask(recipeListMutableLiveData).execute();
    }


    /**
     * Checks if there is an Internet connection.
     *
     * @return internet connection exists
     */
    public boolean isInternetConnection() {
        return ConnectionHelper.getInstance().isInternetConnection(application);
    }
}
