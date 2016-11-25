package module5.api;

import module5.Room;
import module5.Selector;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by g.zubenko on 25.11.2016.
 */
class RoomSearchProvider {
    static public Room[] findRooms(Room[] rooms, int price, int persons, String city, String hotel) {
        Selector<Room> s = getSelector(price, persons, city, hotel);

        ArrayList<Room> list = new ArrayList<Room>();

        for (Room item : rooms) {
            if (s.check(item)) {
                list.add(item);
            }
        }

        Room[] res = new Room[list.size()];
        list.toArray(res);
        return res;
    }

    static public Selector<Room> getSelector(int price, int persons, String city, String hotel){
        Selector<Room> s = (Room r) -> {return (r.getPrice()==price || price==0) &&
                (r.getPersons()==persons || persons==0) &&
                (r.getCityName().equals(city) || city==null || city.length()==0) &&
                (r.getHotelName().equals(hotel) || hotel==null || hotel.length()==0);
        };

        return s;
    }
}
