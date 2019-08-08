package com.popular.backingapp.ui.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * The class generate the IngredientsRemoteViewsFactory
 */
public class WidgetService extends RemoteViewsService {

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new IngredientsRemoteViewsFactory(this);
    }
}
