package module6;

import java.util.Arrays;

/**
 * Created by g.zubenko on 05.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Test №1\n---------------------------------------------------");
        module2.Task1.main(args);
        System.out.println("\nTest №2\n---------------------------------------------------");
        User[] users = new User[5];

        users[0] = new User(1, "Zubenko", "Galina", 5000, 1000);
        users[1] = new User(2, "", "", 5000, 1000);
        users[3] = new User(4, "Zubenko", "Olga", 5000, 3000);
        users[4] = new User(5, "Zubenko", "Andrey", 5000, 1000);

        printUsersArray(users);
        System.out.println("List of not empty users: " + Arrays.toString(UserUtils.deleteEmptyUsers(users)));
        System.out.println("List of ids: " + Arrays.toString(UserUtils.getUsersId(users)));
        System.out.println("Salary was payed to users: " + Arrays.toString(UserUtils.paySalaryToUsers(users)));
        System.out.println("List of unique users: " + Arrays.toString(UserUtils.uniqueUsers(users)));
        System.out.println("List of users, which have balance = 1000: " + Arrays.toString(UserUtils.usersWithContitionalBalance(users, 6000)));
    }

    private static void printUsersArray(User[] users) {
        System.out.println("Initial list of users: ");
        int count = 0;
        for (User item : users) {
            System.out.format("%2d%s%n", ++count, ". " + UserUtils.userDescription(item));
        }
        System.out.println();
    }
}
