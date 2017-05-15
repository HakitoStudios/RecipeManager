package ua.nure.khmelevskoy.recipemanager.repository;

import java.util.List;

public interface CRUDRepository<T> {
    void delete(T item);
    void update(T item);
    List<T> getAll();
}
