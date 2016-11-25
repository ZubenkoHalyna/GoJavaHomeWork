package module5.dao;

import module5.Room;
import module5.Selector;

import java.util.ArrayList;

/**
 * Created by g.zubenko on 23.11.2016.
 */
public interface Dao {
    Room save(Room room);
    boolean delete(Room room);
    Room update(Room room);
    Room findById(long id);
    Room[] getAll();
    Room[] select(Selector<Room> s);
}
