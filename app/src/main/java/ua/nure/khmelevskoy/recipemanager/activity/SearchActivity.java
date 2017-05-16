package ua.nure.khmelevskoy.recipemanager.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ua.nure.khmelevskoy.recipemanager.R;
import ua.nure.khmelevskoy.recipemanager.adapter.RecipeAdapter;
import ua.nure.khmelevskoy.recipemanager.db.Recipe;
import ua.nure.khmelevskoy.recipemanager.facade.RecipeFacade;
import ua.nure.khmelevskoy.recipemanager.repository.RecipeRepository;
import ua.nure.khmelevskoy.recipemanager.repository.RecipeRepositoryImpl;

public class SearchActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeClickListener {

    @BindView(R.id.search_view)
    SearchView searchView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    RecipeAdapter adapter;

    RecipeRepository recipeRepository;
    RecipeFacade recipeFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        recipeRepository = new RecipeRepositoryImpl();
        recipeFacade = new RecipeFacade(recipeRepository);

        adapter = new RecipeAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search();
                return false;
            }
        });
    }

    private void search() {
        adapter.swapData(recipeFacade.find(searchView.getQuery().toString()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        search();
    }

    @OnClick(R.id.add_recipe_button)
    void onAddRecipeClick() {
        startActivity(RecipeActivity.newIntent(this, null));
    }

    @Override
    public void onRecipeClick(Recipe recipe) {
        startActivity(RecipeActivity.newIntent(this, recipe.getId()));
    }
}
