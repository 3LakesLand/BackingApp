package com.popular.backingapp.data.remote.recipes.db;


import com.popular.backingapp.util.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The singleton class ApiClient creates a retrofit object with a given recipes URL.
 */
class ApiClient {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Utils.RECIPES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    /**
     * Private constructor
     */
    private ApiClient() {
    }

    /**
     * Get the singleton retrofit object.
     *
     * @return retrofit object
     */
    static Retrofit getInstance() {
        return retrofit;
    }


}