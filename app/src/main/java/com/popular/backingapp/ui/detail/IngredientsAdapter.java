package com.popular.backingapp.ui.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.Ingredient;
import com.popular.backingapp.ui.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.MyViewHolder> {

    private List<Ingredient> ingredientList;

    public IngredientsAdapter() {
        ingredientList = new ArrayList<>();
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_ingredient_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(ingredientList.get(position));

    }

    @Override
    public int getItemCount() {
        return ingredientList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView ingredientTextView;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredientTextView = itemView.findViewById(R.id.ingredient_tv);
        }

        void bind(Ingredient ingredient) {
            final String text =
                    ingredient.getQuantity() + " " +
                    ingredient.getMeasure() + " " +
                    ingredient.getIngredient();

            ingredientTextView.setText(text);
        }

    }
}
