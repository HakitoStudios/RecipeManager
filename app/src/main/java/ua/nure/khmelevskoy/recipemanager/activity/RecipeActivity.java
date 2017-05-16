package ua.nure.khmelevskoy.recipemanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.nure.khmelevskoy.recipemanager.R;
import ua.nure.khmelevskoy.recipemanager.db.Recipe;
import ua.nure.khmelevskoy.recipemanager.repository.RecipeRepository;
import ua.nure.khmelevskoy.recipemanager.repository.RecipeRepositoryImpl;

public class RecipeActivity extends AppCompatActivity {

    private static final String RECIPE_ID_ARG = "RECIPE_ID_ARG";

    private static final long EMPTY_ID = -1;

    @BindView(R.id.title_edit_text)
    EditText titleEditText;

    @BindView(R.id.duration_edit_text)
    EditText durationEditText;

    @BindView(R.id.ingredients_edit_text)
    EditText ingredientsEditText;

    RecipeRepository recipeRepository;

    long recipeId;

    public static Intent newIntent(Context context, Long recipeId) {
        Intent intent = new Intent(context, RecipeActivity.class);
        intent.putExtra(RECIPE_ID_ARG, recipeId == null ? EMPTY_ID : recipeId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

        recipeRepository = new RecipeRepositoryImpl();

        recipeId = getIntent().getLongExtra(RECIPE_ID_ARG, EMPTY_ID);
        if (recipeId != EMPTY_ID) {
            showRecipe(recipeRepository.findById(recipeId));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recipe_menu, menu);
        menu.findItem(R.id.delete).setVisible(recipeId != EMPTY_ID);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        long duration = 0;
        try {
            duration = Long.valueOf(durationEditText.getText().toString());
        } catch (NumberFormatException e) {
            //failed
        }
        Recipe recipe = new Recipe(titleEditText.getText().toString(),
                duration,
                ingredientsEditText.getText().toString());
        if (recipeId == EMPTY_ID) {
            recipeRepository.update(recipe);
        } else {
            recipe.setId(recipeId);

        }
        if (item.getItemId() == R.id.done) {
            recipeRepository.update(recipe);
            finish();
        } else if (item.getItemId() == R.id.delete) {
            recipeRepository.delete(recipe);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecipe(Recipe recipe) {
        titleEditText.setText(recipe.getTitle());
        durationEditText.setText(String.valueOf(recipe.getDuration()));
        ingredientsEditText.setText(recipe.getIngredients());
    }
}
