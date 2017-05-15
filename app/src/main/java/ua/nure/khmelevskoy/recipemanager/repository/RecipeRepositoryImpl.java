package ua.nure.khmelevskoy.recipemanager.repository;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import ua.nure.khmelevskoy.recipemanager.db.RecipeDbModel;

class RecipeRepositoryImpl implements RecipeRepository {
    @Override
    public void delete(RecipeDbModel item) {
        item.delete();
    }

    @Override
    public void update(RecipeDbModel item) {
        item.save();
    }

    @Override
    public List<RecipeDbModel> getAll() {
        return new Select().from(RecipeDbModel.class).queryList();
    }
}
