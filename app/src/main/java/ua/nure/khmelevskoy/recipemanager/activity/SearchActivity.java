package ua.nure.khmelevskoy.recipemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.nure.khmelevskoy.recipemanager.R;
import ua.nure.khmelevskoy.recipemanager.adapter.RecipeAdapter;
import ua.nure.khmelevskoy.recipemanager.db.RecipeDbModel;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.search_view)
    SearchView searchView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        adapter = new RecipeAdapter();

        adapter.swapData(Arrays.asList(new RecipeDbModel("first", 45676, null),
                new RecipeDbModel("second", 365676, null)));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.add_recipe_button)
    void onAddRecipeClick() {
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }
}
