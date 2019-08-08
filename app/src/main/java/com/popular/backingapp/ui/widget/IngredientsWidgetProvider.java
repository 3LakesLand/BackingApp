package com.popular.backingapp.ui.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.popular.backingapp.R;

/**
 * Implementation of App Widget functionality.
 */
public class IngredientsWidgetProvider extends AppWidgetProvider {

    /**
     * The method creates a remote view and assigns it a layout that captures the cake image,
     * the current recipe name, and its ingredient list.
     *
     * @param context          context
     * @param appWidgetManager update the widget
     * @param appWidgetIds     ids of all live widgets
     * @param recipeName       current recipe name
     */
    public static void updateRecipeWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds, String recipeName) {
        //There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.ingredients_widget);

            Intent intent = new Intent(context, WidgetService.class);
            views.setRemoteAdapter(R.id.widget_ingredients_lv, intent);

            views.setTextViewText(R.id.last_viewed_ingredients_tv, recipeName);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onEnabled(Context context) {
    }

    @Override
    public void onDisabled(Context context) {
    }
}

