package ua.nure.khmelevskoy.recipemanager.facade;

import java.util.ArrayList;
import java.util.List;

import ua.nure.khmelevskoy.recipemanager.db.Recipe;
import ua.nure.khmelevskoy.recipemanager.repository.RecipeRepository;

public class RecipeFacade {

    private static final String DELIMITERS = " |\\.|;|,";

    private final RecipeRepository recipeRepository;

    public RecipeFacade(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAll() {
        return recipeRepository.getAll();
    }

    private boolean containstAll(String s, String[] strings) {
        for (String string : strings) {
            if (!s.contains(string)) {
                return false;
            }
        }
        return true;
    }

    public List<Recipe> find(String query) {
        query = query.toLowerCase().trim();
        if (query.isEmpty()) {
            return getAll();
        }
        List<Recipe> res = new ArrayList<>();
        for (Recipe recipe : getAll()) {
            if (containstAll(query, recipe.getIngredients().toLowerCase().split(DELIMITERS))) {
                res.add(recipe);
            }
        }
        return res;
    }
}
