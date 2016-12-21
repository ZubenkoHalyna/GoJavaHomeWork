package module8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by g.zubenko on 21.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        List<User> listOfMen = new ArrayList<>();
        listOfMen.add(new User("Mr. Black"));
        listOfMen.add(new User("Mr. Green"));
        listOfMen.add(new User("Mr. Brown"));
        List<User> listOfWomen = new ArrayList<>();
        listOfWomen.add(new User("Mrs. Black"));
        listOfWomen.add(new User("Mrs. Green"));
        listOfWomen.add(new User("Mrs. Brown"));

        module7.Task_1_3.Main.printCollection("List of men",listOfMen);
        module7.Task_1_3.Main.printCollection("List of women",listOfWomen);

        System.out.println("\nTest 1: adding");
        System.out.println("Adding all men ...");
        dao.saveAll(listOfMen);
        System.out.println("Adding Mrs. Black ...");
        dao.save(listOfWomen.get(0));

        module7.Task_1_3.Main.printCollection("All users after adding", dao.getAll());

        System.out.println("\nTest 2: deleting");
        System.out.println("Deleting all women ...");
        dao.deleteAll(listOfWomen);
        System.out.println("Deleting Mr. Black ...");
        dao.delete(listOfMen.get(0));

        module7.Task_1_3.Main.printCollection("All users after deleting", dao.getAll());

        System.out.println("\nTest 3: getting by id");
        System.out.println("Mr. Green was gotten by Id: "+ dao.getById(listOfMen.get(1).getId()));
    }
}
