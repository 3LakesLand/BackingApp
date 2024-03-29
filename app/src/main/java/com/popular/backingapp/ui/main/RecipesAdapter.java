package com.popular.backingapp.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.popular.backingapp.R;
import com.popular.backingapp.ui.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * The adapter allows the loading and display the recipes.
 */
public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.MyViewHolder> {

    private List<Recipe> recipeList;
    private OnRecipeListener onRecipeListener;

    /**
     * Constructor
     *
     * @param onRecipeListener for selecting the recipe
     */
    RecipesAdapter(OnRecipeListener onRecipeListener) {
        this.onRecipeListener = onRecipeListener;
        recipeList = new ArrayList<>();
    }

    void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_grid_recipe_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    /**
     * The View Holder binds the recipe data object.
     *
     * @param holder   current view holder
     * @param position in the adapter
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(recipeList.get(position));

    }

    /**
     * Count of all recipe objects.
     *
     * @return count
     */
    @Override
    public int getItemCount() {
        return recipeList.size();
    }


    /**
     * Listener for selecting the recipe from the recipe overview list page.
     */
    public interface OnRecipeListener {
        void onRecipeClick(Recipe recipe);
    }

    /**
     * The ViewHolder contains the recipe name and the cake image.
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView recipeTextView;
        private ImageView cakeImageView;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeTextView = itemView.findViewById(R.id.recipe_tv);
            cakeImageView = itemView.findViewById(R.id.cake_iv);
            itemView.setOnClickListener(this);
        }

        void bind(Recipe recipe) {
            recipeTextView.setText(recipe.getName());
            cakeImageView.setImageResource(R.drawable.baseline_cake_black_24);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Recipe recipe = recipeList.get(position);
            onRecipeListener.onRecipeClick(recipe);
        }
    }
}
