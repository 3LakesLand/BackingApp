package com.popular.backingapp.ui.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * The adapter allows the loading and display of the ingredients.
 */
public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.MyViewHolder> {

    private static final String SPACE = " ";
    private List<Ingredient> ingredientList;


    /**
     * Constructor
     */
    IngredientsAdapter() {
        ingredientList = new ArrayList<>();
    }

    void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * The method creates a View Holder object.
     *
     * @param viewGroup contains the application context
     * @param viewType  - not used
     * @return new View Holder object
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_ingredient_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    /**
     * The View Holder binds the ingredient data object.
     *
     * @param holder   current view holder
     * @param position in the adapter
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(ingredientList.get(position));

    }

    /**
     * Count of all ingredient objects.
     *
     * @return count
     */
    @Override
    public int getItemCount() {
        return ingredientList.size();
    }


    /**
     * The ViewHolder contains the ingredient with quantity, measure and content.
     */
    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView ingredientTextView;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientTextView = itemView.findViewById(R.id.ingredient_tv);
        }

        void bind(Ingredient ingredient) {
            final String text =
                    ingredient.getQuantity() + SPACE +
                            ingredient.getMeasure() + SPACE +
                            ingredient.getIngredient();

            ingredientTextView.setText(text);
        }

    }
}
