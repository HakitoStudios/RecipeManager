package ua.nure.khmelevskoy.recipemanager.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = RecipeDatabase.class)
public class RecipeDbModel extends BaseModel{
    @Column
    @PrimaryKey
    Long id;

    @Column
    String title;

    @Column
    long duration;

    @Column
    String ingredients;

    public RecipeDbModel(String title, long duration, String ingredients) {
        this.title = title;
        this.duration = duration;
        this.ingredients = ingredients;
    }

    public RecipeDbModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
