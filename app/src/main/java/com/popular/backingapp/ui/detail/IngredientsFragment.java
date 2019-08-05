package com.popular.backingapp.ui.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.RecipeModel;
import com.popular.backingapp.ui.model.RecipesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class IngredientsFragment extends Fragment {
    //for ButterKnife framework
    private Unbinder unbinder;
    @BindView(R.id.ingredients_rv)
    RecyclerView ingredientsRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View rootView = inflater.inflate(R.layout.detail_ingredients_fragment, container, false);

        //bind
        unbinder = ButterKnife.bind(this, rootView);

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
