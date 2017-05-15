package ua.nure.khmelevskoy.recipemanager.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = RecipeDatabase.NAME, version = RecipeDatabase.VERSION)
public class RecipeDatabase {
    public static final String NAME = "RECIPE_DATABASE";
    public static final int VERSION = 1;
}
