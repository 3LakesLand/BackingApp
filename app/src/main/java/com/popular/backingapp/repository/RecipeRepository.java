package com.popular.backingapp.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.popular.backingapp.data.network.ConnectionHelper;
import com.popular.backingapp.data.remote.recipes.db.SelectRecipesAsyncTask;
import com.popular.backingapp.ui.model.Recipe;

import java.util.List;

/**
 * The recipe repository class split the surface and the recipe database (Separation of Concerns).
 * The surface calls the display data only from the repository. The repository organizes data delivery and storage.
 * To prevent the dependency between DB data (external and internal) with the surface, the live data is copied (via MutableLiveData).
 */
public class RecipeRepository {
    private Application application;

    /**
     * Constructor
     *
     * @param application needed for check the internet connection
     */
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
