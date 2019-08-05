package com.popular.backingapp.data.remote.recipes.db;

import com.popular.backingapp.data.remote.recipes.db.model.RecipeEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRecipesDB {


    /**
     * All recipes data from the RecipesDB.
     * @return Recipes data
     */
    @GET("baking.json")
    Call<List<RecipeEntity>> getRecipesRequest();
}
