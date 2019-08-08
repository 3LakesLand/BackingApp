package com.popular.backingapp.data.remote.recipes.db;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.popular.backingapp.ui.model.Recipe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.List;

public class SelectRecipesAsyncTaskTest {

    private final MutableLiveData<List<Recipe>> recipeListMutableLiveData = new MutableLiveData<>();

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void getRecipeList() {
        SelectRecipesAsyncTask selectRecipesAsyncTask = new SelectRecipesAsyncTask(recipeListMutableLiveData);
        selectRecipesAsyncTask.doInBackground();
    }


    @Test
    public void testRecipeList() {
        List<Recipe> recipeList = recipeListMutableLiveData.getValue();
        Assert.assertNotNull(recipeList);

    }
}
