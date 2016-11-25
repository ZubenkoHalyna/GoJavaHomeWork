package module5.api;

import module5.Room;

/**
 * Created by g.zubenko on 23.11.2016.
 */
public interface Api {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();

    static Api[] getAllSearchApis()
    {
        Api[] apis = new Api[3];
        apis[0] = new BookingComAPI();
        apis[1] = new GoogleAPI();
        apis[2] = new TripAdvisorAPI();
        return apis;
    }
}
