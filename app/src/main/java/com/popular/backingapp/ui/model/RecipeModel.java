package com.popular.backingapp.ui.model;

public class RecipeModel {
    private static final RecipeModel ourInstance = new RecipeModel();

    public static RecipeModel getInstance() {
        return ourInstance;
    }

    private Recipe currentSelectedRecipe;
    private Step currentSelectedStep;

    private RecipeModel() {
    }

    public void setCurrentSelectedRecipe(Recipe recipe) {
        this.currentSelectedRecipe = recipe;
    }

    public Recipe getCurrentSelectedRecipe() {
        return currentSelectedRecipe;
    }

    public void setCurrentSelectedStep(Step step) {
        this.currentSelectedStep = step;
    }

    public Step getCurrentSelectedStep() {
        return currentSelectedStep;
    }
}
