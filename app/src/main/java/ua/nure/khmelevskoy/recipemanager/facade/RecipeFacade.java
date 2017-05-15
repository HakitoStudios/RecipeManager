package ua.nure.khmelevskoy.recipemanager.facade;

import java.util.ArrayList;
import java.util.List;

import ua.nure.khmelevskoy.recipemanager.db.RecipeDbModel;
import ua.nure.khmelevskoy.recipemanager.repository.RecipeRepository;

public class RecipeFacade {
    private final RecipeRepository recipeRepository;

    public RecipeFacade(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void add(RecipeDbModel model){
        recipeRepository.update(model);
    }

    public List<RecipeDbModel> getAll(){
        return recipeRepository.getAll();
    }

    public List<RecipeDbModel> find(String query){

        List<RecipeDbModel> res = new ArrayList<>();
        for (RecipeDbModel recipe : getAll()) {
            if(true){
                res.add(recipe);
            }
        }
        return res;
    }
}
