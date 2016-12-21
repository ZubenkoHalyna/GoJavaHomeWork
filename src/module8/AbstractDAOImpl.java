package module8;

import java.util.List;

/**
 * Created by g.zubenko on 21.12.2016.
 */
public abstract class AbstractDAOImpl<T extends HasIdentification> implements AbstractDAO<T> {

    @Override
    public void saveAll(List<T> items) {
        for (T item : items) {
            save(item);
        }
    }

    @Override
    public void delete(T item) {
        deleteById(item.getId());
    }

    @Override
    public void deleteAll(List<T> items) {
        for (T item : items) {
            deleteById(item.getId());
        }
    }
}
