package ua.nure.khmelevskoy.recipemanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.nure.khmelevskoy.recipemanager.DurationUtil;
import ua.nure.khmelevskoy.recipemanager.R;
import ua.nure.khmelevskoy.recipemanager.db.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter {

    private final List<Recipe> recipes = new ArrayList<>();

    private OnRecipeClickListener onRecipeClickListener;

    public RecipeAdapter(OnRecipeClickListener onRecipeClickListener) {
        this.onRecipeClickListener = onRecipeClickListener;
    }

    public void swapData(List<Recipe> recipes) {
        this.recipes.clear();
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

    public interface OnRecipeClickListener {
        void onRecipeClick(Recipe recipe);
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

        public void bind(Recipe recipe) {
            recipeTitle.setText(recipe.getTitle());
            durationTextView.setText(DurationUtil.formatDuration(recipe.getDuration()));
        }

        @OnClick(R.id.card_view)
        void onRecipeClick() {
            onRecipeClickListener.onRecipeClick(recipes.get(getAdapterPosition()));
        }
    }
}
