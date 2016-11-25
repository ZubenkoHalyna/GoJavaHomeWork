package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by g.zubenko on 23.11.2016.
 */
public class Main {
    static Controller c;

    public static void main(String[] args) throws IOException {
        c = new Controller();

        System.out.println("API TEST:\n---------------------------------------------------------------------------");
        requestRoomsTest();
        System.out.println();
        checkTest();

        System.out.println();
        SaveAllRoomsToDB();
        System.out.println("DAO TEST:\n---------------------------------------------------------------------------");
        daoTest();
    }

    private static void daoTest() throws IOException {
        System.out.println("Rooms in DB:");
        printRoomsDescriptionList(c.getAll());
        System.out.println();

        String cityName = new String("Kiev");
        System.out.println("Available rooms in "+cityName+":");
        printArayOfRooms(c.selectByCity(cityName));
    }

    private static void SaveAllRoomsToDB() {
        c.save(c.requestRooms(0, 0, null, null));
    }

    private static void requestRoomsTest() {
        System.out.println("Kiev rooms for 2 persons: ");
        printRoomsDescriptionList(c.requestRooms(0, 2, "Kiev", null));
        System.out.println("Kiev rooms for 2 persons, prise 1000 and hotel \"Hilton\":");
        printRoomsDescriptionList(c.requestRooms(1000, 2, "Kiev", "Hilton"));
        System.out.println("All different rooms:");
        printRoomsDescriptionList(c.requestRooms(0, 0, null, null));
    }

    private static void checkTest() {
        for (int i = 0; i < c.getApis().length; i++) {
            int secondNumber = (i + 1) % c.getApis().length;
            System.out.println("Rooms are found both in " + c.apis[i].getClass().getSimpleName() +
                    " and in " + c.apis[secondNumber].getClass().getSimpleName() + ": ");
            printRoomsDescriptionList(c.check(c.apis[i], c.apis[secondNumber]));
        }
    }

    static void printRoomsDescriptionList(Room[] rooms) {
        int count = 0;
        for (Room item : rooms) {
            System.out.format("%2d%s%n", ++count, ". " + item.roomDescription());
        }
    }

    static void printArayOfRooms(Room[] rooms) {
        int count = 0;
        for (Room item : rooms) {
            System.out.format("%2d%s%n", ++count, ". " + item);
        }
    }
}
