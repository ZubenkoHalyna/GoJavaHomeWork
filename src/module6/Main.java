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
        User[] users = new User[9];
        createUsers(users);
        Object nextObjInMemory = new Object();
        testUserUtils(users, nextObjInMemory);
    }

    private static void createUsers(User[] users) {
        users[0] = new User(1, "Mary", "White", 5000, 1000);
        users[1] = new User(2, "", "", 5000, 1000);
        users[3] = new User(4, "John", "Green", 5000, 3000);
        users[4] = users[3];
        users[5] = new User(5, "Mark", "Black", 5000, 1000);
        users[6] = new User(5, "Mark", "Black", 5000, 1000);
        users[7] = new User(6, "", "Brown", 4000, 1000);
        users[8] = new User(7, "Paul", "", 3000, 1000);
    }

    private static void testUserUtils(User[] users, Object nextObjInMemory) {
        System.out.println("Initial users: \n");
        printUsersArray(users, nextObjInMemory);
        System.out.println("Ids: " + Arrays.toString(UserUtils.getUsersId(users)));
        System.out.println("Not empty users: " + Arrays.toString(UserUtils.deleteEmptyUsers(users)));
        System.out.println("Unique users: " + Arrays.toString(UserUtils.uniqueUsers(users)));
        System.out.println("Unique objects: " + Arrays.toString(UserUtils.uniqueObjects(users)));
        System.out.println("Unique not empty users: " + Arrays.toString(UserUtils.deleteEmptyUsers(UserUtils.uniqueUsers(users))));
        System.out.println("Salary was payed to users: " + Arrays.toString(UserUtils.paySalaryToUsers(users)));
        System.out.println("Users, which have balance = 6000: " + Arrays.toString(UserUtils.usersWithConditionalBalance(users, 6000)));
        System.out.println("\nUsers after transactions executing: ");
        printUsersArray(users, nextObjInMemory);
    }


    private static void printUsersArray(User[] users, Object nextObjInMemory) {
        int count = 0;
        System.out.format("%2s%11s%10s%5s%10s%10s%20s%20s%n", "№", "FirstName", "LastName", "Id", "Balance", "Salary",
                "AddressInMemory","OffsetInMemory");

        for (int i=0;i<users.length; i++) {
            if (users[i] != null) {
                long addressInMemory = UnsafeUtil.getAddressInMemory(users[i]);
                long nextObjaddressInMemory=0;
                        for (int j=i+1; j<=users.length;j++) {
                            if (j==users.length){
                                nextObjaddressInMemory=UnsafeUtil.getAddressInMemory(nextObjInMemory);
                                break;
                            }
                            if (users[j]!=null)
                            {
                                nextObjaddressInMemory=UnsafeUtil.getAddressInMemory(users[j]);
                                break;
                            }
                        }
                long offset = nextObjaddressInMemory-addressInMemory;
                System.out.format("%2d%11s%10s%5s%10s%10s%20s%20s%n", ++count, users[i].getFirstName(),
                        users[i].getLastName(), users[i].getId(), users[i].getBalance(), users[i].getSalary(),
                        addressInMemory,offset);
            }
            else {
                System.out.format("%2d%11s%n", ++count, "null");
            }
        }
        System.out.println();
    }
}
