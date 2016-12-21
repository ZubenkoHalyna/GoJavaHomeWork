package module8;

import java.util.List;

interface AbstractDAO<T> {
    T getById(long id);
    List<T> getAll();
    T save(T item);
    void saveAll(List<T> items);
    void delete(T item);
    void deleteById(long id);
    void deleteAll(List<T> items);
}
