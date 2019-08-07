package com.popular.backingapp;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.popular.backingapp.ui.model.Ingredient;
import com.popular.backingapp.ui.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {

    private List<Ingredient> ingredients;
    private Context context;


    public WidgetDataProvider(Context context) {
        this.context = context;

    }

    @Override
    public void onCreate() {
        ingredients = new ArrayList<>();
    }

    // called when RemoteViewsFactory is first created and when notifyWidgetViewDataChanged is called
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

    // true if items in list won't change
    @Override
    public boolean hasStableIds() {
        return false;
    }

}
