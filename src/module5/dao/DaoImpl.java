package module5.dao;

import module5.Room;
import module5.Selector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by g.zubenko on 23.11.2016.
 */
public class DaoImpl implements Dao {
    HashMap<Long, Room> rooms = new HashMap<Long,Room>();

    @Override
    public Room save(Room room) {
        rooms.put(room.getId(),room);
        return room;
    }

    @Override
    public boolean delete(Room room) {
        boolean isAllowed = rooms.containsValue(room);
        if (isAllowed) {
            rooms.remove(room.getId());
        }
        return isAllowed;
    }

    @Override
    public Room update(Room room) {
        boolean isAllowed = rooms.containsKey(room.getId());
        if (isAllowed) {
            save(room);
        }
        return (isAllowed)?room:null;
    }

    @Override
    public Room findById(long id) {
        return rooms.get(id);
    }

    @Override
    public Room[] getAll() {
        Room[] res = new Room[rooms.size()];
        rooms.values().toArray(res);
        return res;
    }

    @Override
    public Room[] select(Selector<Room> s) {
        TreeSet<Room> list = rooms.values().stream().filter(s::check).collect(Collectors.toCollection(TreeSet::new));
        Room[] res = new Room[list.size()];
        list.toArray(res);
        return res;
    }
}
