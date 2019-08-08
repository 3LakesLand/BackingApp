package com.popular.backingapp.ui.model;

/**
 * The singleton class has the current recipe and the current step.
 */
public class RecipeModel {
    private static final RecipeModel ourInstance = new RecipeModel();
    private Recipe currentSelectedRecipe;
    private Step currentSelectedStep;
    private RecipeModel() {
    }

    public static RecipeModel getInstance() {
        return ourInstance;
    }

    public Recipe getCurrentSelectedRecipe() {
        return currentSelectedRecipe;
    }

    public void setCurrentSelectedRecipe(Recipe recipe) {
        this.currentSelectedRecipe = recipe;
    }

    public Step getCurrentSelectedStep() {
        return currentSelectedStep;
    }

    public void setCurrentSelectedStep(Step step) {
        this.currentSelectedStep = step;
    }
}
