package com.popular.backingapp.ui.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.RecipeModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The class shows the ingredients of a recipe.
 */
public class IngredientsFragment extends Fragment {
    @BindView(R.id.ingredients_rv)
    RecyclerView ingredientsRecyclerView;
    @BindView(R.id.heading_ingredients_tv)
    TextView headingIngredientsView;
    //for ButterKnife framework
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View rootView = inflater.inflate(R.layout.detail_ingredients_fragment, container, false);

        //bind
        unbinder = ButterKnife.bind(this, rootView);

        final StringBuilder stringBuilder = new StringBuilder()
                .append(getString(R.string.ingredients))
                .append(getString(R.string.servings_start))
                .append(RecipeModel.getInstance().getCurrentSelectedRecipe().getServings())
                .append(getString(R.string.servings_end));


        headingIngredientsView.setText(stringBuilder.toString());

        IngredientsAdapter ingredientsAdapter = new IngredientsAdapter();
        ingredientsRecyclerView.setAdapter(ingredientsAdapter);

        ingredientsAdapter.setIngredientList(RecipeModel.getInstance().getCurrentSelectedRecipe().getIngredients());
        ingredientsAdapter.notifyDataSetChanged();

        return rootView;

    }

    /**
     * When the view is destroyed, the binder is reset.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
