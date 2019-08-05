package com.popular.backingapp.ui.model;


/**
 * Ingredient Model for the detailed representation of the ingredient information in the surface.
 */
public class Ingredient {

    private String quantity;

    private String measure;

    private String ingredient;

    public String getQuantity() {
        return quantity;
    }

    public Ingredient(String quantity, String measure, String ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }


    public String getMeasure() {
        return measure;
    }


    public String getIngredient() {
        return ingredient;
    }

}
