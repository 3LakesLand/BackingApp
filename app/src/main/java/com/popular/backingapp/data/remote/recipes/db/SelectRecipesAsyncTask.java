package com.popular.backingapp.data.remote.recipes.db;

import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.popular.backingapp.data.remote.recipes.db.model.IngredientEntity;
import com.popular.backingapp.data.remote.recipes.db.model.RecipeEntity;
import com.popular.backingapp.data.remote.recipes.db.model.StepEntity;
import com.popular.backingapp.ui.model.Ingredient;
import com.popular.backingapp.ui.model.Recipe;
import com.popular.backingapp.ui.model.Step;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SelectRecipesAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = SelectRecipesAsyncTask.class.getSimpleName();

    private MutableLiveData<List<Recipe>> recipeListMutableLiveData;

    public SelectRecipesAsyncTask(MutableLiveData<List<Recipe>> recipeListMutableLiveData) {
        this.recipeListMutableLiveData = recipeListMutableLiveData;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        ApiRecipesDB apiRecipesDB = ApiClient.getInstance().create(ApiRecipesDB.class);

        Call<List<RecipeEntity>> call = apiRecipesDB.getRecipesRequest();

        try {
            Response<List<RecipeEntity>> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                List<RecipeEntity> recipeEntityList = response.body();

                List<Recipe> recipeList = getRecipeList(recipeEntityList);
                recipeListMutableLiveData.postValue(recipeList);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
        }

        return null;
    }

    private List<Recipe> getRecipeList(List<RecipeEntity> recipeEntityList) {
        List<Recipe> recipeList = new ArrayList<>();
        for (RecipeEntity recipeEntity : recipeEntityList) {
            List<Ingredient> ingredientList = new ArrayList<>();
            for (IngredientEntity ingredientEntity : recipeEntity.getIngredients()) {
                Ingredient ingredient = new Ingredient(
                        ingredientEntity.getQuantity(),
                        ingredientEntity.getMeasure(),
                        ingredientEntity.getIngredient());
                ingredientList.add(ingredient);
            }
            List<Step> stepList = new ArrayList<>();
            for (StepEntity stepEntity : recipeEntity.getSteps()) {
                Step step = new Step(
                        stepEntity.getId(),
                        stepEntity.getShortDescription(),
                        stepEntity.getDescription(),
                        stepEntity.getVideoURL(),
                        stepEntity.getThumbnailURL());
                stepList.add(step);
            }
            Recipe recipe = new Recipe(
                    recipeEntity.getId(),
                    recipeEntity.getName(),
                    ingredientList,
                    stepList,
                    recipeEntity.getServings());
            recipeList.add(recipe);
        }
        return recipeList;

    }
}
