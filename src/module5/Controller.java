package module5;

import module5.api.Api;
import module5.dao.Dao;
import module5.dao.DaoImpl;

import java.util.*;

/**
 * Created by g.zubenko on 23.11.2016.
 */
public class Controller {
    Api apis[] = Api.getAllSearchApis();
    Dao dao = new DaoImpl();

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        ArrayList<Room> list = new ArrayList<Room>();
        for (Api item : apis) {
            for (Room r : item.findRooms(price, persons, city, hotel)) {
                if (!isListContainsRoom(list, r))
                    list.add(r);
            }
        }

        list.sort((a, b) -> a.compareTo(b));
        Room[] array = new Room[list.size()];
        list.toArray(array);
        return array;
    }

    public Room[] check(Api api1, Api api2) {
        Room[] list1 = api1.getAll();
        Room[] list2 = api2.getAll();

        ArrayList<Room> set = new ArrayList<Room>();
        for (Room item1 : list1) {
            for (Room item2 : list2) {
                if (compareRooms(item1, item2)) {
                    set.add(item1);
                    break;
                }
            }
        }

        Room[] array = new Room[set.size()];
        set.toArray(array);
        return array;
    }

    public Room save(Room room) {
        if (!isArrayContainsRoom(dao.getAll(),room)) {
            return dao.save(room);
        }
        return null;
    }

    public boolean save(Room[] rooms) {
        for (Room room : rooms)
            save(room);
        return true;
    }

    public boolean delete(Room room) {
        return dao.delete(room);
    }

    public Room update(Room room) {
        return dao.update(room);
    }

    public Room findById(long id) {
        return dao.findById(id);
    }

    public Room[] getAll() {
        return dao.getAll();
    }

    public Room[] selectByCity(String cityName) {
        return dao.select((Room r)->{return cityName.equals(r.getCityName());});
    }

    public Api[] getApis() {
        return apis;
    }

    private boolean isListContainsRoom(Collection<Room> list, Room room) {
        for (Room r : list) {
            if (compareRooms(r, room))
                return true;
        }
        return false;
    }

    private boolean isArrayContainsRoom(Room[] array, Room room) {
        for (Room r : array) {
            if (compareRooms(r, room))
                return true;
        }
        return false;
    }

    private boolean compareRooms(Room room1, Room room2) {
        return room1.getPrice() == room2.getPrice() &&
                room1.getPersons() == room2.getPersons() &&
                room1.getCityName().equals(room2.getCityName()) &&
                room1.getHotelName().equals(room2.getHotelName());
    }
}
