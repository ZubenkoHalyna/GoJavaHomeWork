package module6;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Created by g.zubenko on 05.12.2016.
 */
public final class UserUtils {
    /*;
    * ;*/
    private UserUtils(){}

    public static User[] uniqueUsers(User[] users) {
        User[] notEmptyUsers = deleteEmptyUsers(users);
        User[] buffArray = new User[notEmptyUsers.length];

        int numberOfUniqueUsers = 0;
        for (int i = 0; i < notEmptyUsers.length; i++) {
            boolean currentItemIIsUnique = true;
            for (int j = i + 1; j < notEmptyUsers.length; j++) {
                if (notEmptyUsers[i]!=null && ! notEmptyUsers[i].isEmpty() && notEmptyUsers[i].equals(notEmptyUsers[j])) {
                    currentItemIIsUnique = false;
                }
            }
            if (currentItemIIsUnique) {
                buffArray[numberOfUniqueUsers] = notEmptyUsers[i];
                numberOfUniqueUsers++;
            }
        }

        User[] res = Arrays.copyOfRange(buffArray, 0, numberOfUniqueUsers);
        return res;
    }

    public static User[] usersWithContitionalBalance(User[] users, int balance) {
        User[] res;
        res = selectUsers(users, (User u) -> u.getBalance()==balance);
        return res;
    }

    public final static User[] paySalaryToUsers(User[] users) {
        User[] notEmptyUsers = deleteEmptyUsers(users);

        for (User item : notEmptyUsers) {
                item.paySalary();
        }
        return notEmptyUsers;
    }

    public static final long[] getUsersId(User[] users) {
        long[] ids = new long[users.length];

        for (int i = 0; i < users.length; i++) {
            ids[i] = (users[i]==null)?-1:users[i].getId();
        }
        return ids;
    }

    public static final User[] deleteEmptyUsers(User[] users) {
        User[] res;
        res = selectUsers(users, (User u) -> !u.isEmpty());
        return res;
    }

    public static final User[] selectUsers(User[] users, Predicate<User> selector) {
        int numberOfUsers = 0;
        User[] bufArray = new User[users.length];

        for (User item : users) {
            if (item!=null && selector.test(item)) {
                bufArray[numberOfUsers] = item;
                numberOfUsers++;
            }
        }

        User[] res = Arrays.copyOfRange(bufArray, 0, numberOfUsers);
        return res;
    }

    public static String userDescription(User user) {
        return (user==null)?"":user.toString()+"(id = "+user.getId()+", balance = "+user.getBalance()+")";
    }
}
