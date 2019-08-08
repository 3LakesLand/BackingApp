package com.popular.backingapp.ui.model;


import java.util.List;

/**
 * Recipe Model for the detailed representation of the receipe information in the surface.
 */
public class Recipe {

    private String id;

    private String name;

    private List<Ingredient> ingredients;

    private List<Step> steps;

    private String servings;

    public Recipe(String id, String name, List<Ingredient> ingredients, List<Step> steps, String servings) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public String getServings() {
        return servings;
    }

}
