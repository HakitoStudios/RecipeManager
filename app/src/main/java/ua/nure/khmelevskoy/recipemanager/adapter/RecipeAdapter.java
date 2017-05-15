package ua.nure.khmelevskoy.recipemanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.nure.khmelevskoy.recipemanager.R;
import ua.nure.khmelevskoy.recipemanager.db.RecipeDbModel;

public class RecipeAdapter extends RecyclerView.Adapter {

    private final List<RecipeDbModel> recipes = new ArrayList<>();

    public void swapData(List<RecipeDbModel> recipes) {
        this.recipes.clear();
        this.recipes.addAll(recipes);
        this.recipes.addAll(recipes);
        this.recipes.addAll(recipes);
        this.recipes.addAll(recipes);
        this.recipes.addAll(recipes);
        this.recipes.addAll(recipes);
        this.recipes.addAll(recipes);
        this.recipes.addAll(recipes);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecipeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recipe, null, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecipeViewHolder) holder).bind(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recipe_title_text_view)
        TextView recipeTitle;

        @BindView(R.id.duration_text_view)
        TextView durationTextView;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(RecipeDbModel recipe) {
            recipeTitle.setText(recipe.getTitle());
            durationTextView.setText(DateUtils.formatElapsedTime(recipe.getDuration()));
        }
    }
}
