package com.popular.backingapp.ui.widget;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.popular.backingapp.ui.model.Ingredient;
import com.popular.backingapp.ui.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The factory class fills the RemoteView with up-to-date ingredient.
 */
public class IngredientsRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private List<Ingredient> ingredients;
    private Context context;


    IngredientsRemoteViewsFactory(Context context) {
        this.context = context;

    }

    @Override
    public void onCreate() {
        ingredients = new ArrayList<>();
    }

    /**
     * The methods was called when RemoteViewsFactory is first created
     * and when notifyWidgetViewDataChanged is called.
     */
    @Override
    public void onDataSetChanged() {
        ingredients = RecipeModel.getInstance().getCurrentSelectedRecipe().getIngredients();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return ingredients.size();
    }

    /**
     * Method populates the ingredient in the RemoteView ingredient list.
     *
     * @param position of ingredient
     * @return remoteView with all ingredients of the recipe
     */
    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), android.R.layout.simple_list_item_1);
        remoteViews.setTextViewText(android.R.id.text1, ingredients.get(position).getIngredient());
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Because the content changes depending on the recipe selection, this method must always return false.
     *
     * @return always false
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

}
