package module5.api;

import module5.Room;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by g.zubenko on 23.11.2016.
 */
public class BookingComAPI implements Api {
    private Room[] rooms = new Room[5];

    public BookingComAPI() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(2016, Calendar.SEPTEMBER,1);
        rooms[0]= new Room(IdProvider.getNewId(), 1100,2,calendar.getTime(),"Hilton","Kiev");
        calendar.set(2016,Calendar.OCTOBER,1);
        rooms[1]= new Room(IdProvider.getNewId(), 1100,2,calendar.getTime(),"Bristol","Kiev");
        calendar.set(2016,Calendar.NOVEMBER,1);
        rooms[2]= new Room(IdProvider.getNewId(), 2500,2,calendar.getTime(),"Aurora Premier Hotel","Kharkiv");
        calendar.set(2016,Calendar.DECEMBER,1);
        rooms[3]= new Room(IdProvider.getNewId(), 3200,3,calendar.getTime(),"Nobilis","Lviv");
        calendar.set(2016,Calendar.JANUARY,1);
        rooms[4]= new Room(IdProvider.getNewId(), 5000,3,calendar.getTime(),"Hilton","Boston");
    }

    @Override
    public Room[] getAll() {
        Room[] r = new Room[rooms.length];
        System.arraycopy(rooms,0,r,0,rooms.length);
        return r;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        return RoomSearchProvider.findRooms(rooms,price,persons,city,hotel);
    }
}
