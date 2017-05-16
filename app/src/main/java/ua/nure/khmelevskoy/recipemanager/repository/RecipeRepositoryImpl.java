package ua.nure.khmelevskoy.recipemanager.repository;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ua.nure.khmelevskoy.recipemanager.db.Recipe;
import ua.nure.khmelevskoy.recipemanager.db.Recipe_Table;

public class RecipeRepositoryImpl implements RecipeRepository {
    @Override
    public void delete(Recipe item) {
        item.delete();
    }

    @Override
    public void update(Recipe item) {
        item.save();
    }

    @Override
    public List<Recipe> getAll() {
        return new Select().from(Recipe.class).queryList();
    }

    @Override
    public Recipe findById(long id) {
        return new Select().from(Recipe.class).where(Recipe_Table.id.is(id)).querySingle();
    }
}
