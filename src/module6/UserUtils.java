package module6;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * Created by g.zubenko on 05.12.2016.
 */
public final class UserUtils {
    private UserUtils() {
    }

    public static User[] uniqueUsers(User[] users) {
        return uniqueUsers(users, (User u1, User u2) -> u1.equals(u2));
    }

    public static User[] uniqueObjects(User[] users) {
        return uniqueUsers(users, (User u1, User u2) -> u1==u2);
    }

    // The method was used differently in uniqueUsers(User[] users) and in paySalaryToUsers(User[] users)
    private static User[] uniqueUsers(User[] users, BiPredicate<User, User> uniqueRule) {
        User[] buffArray = new User[users.length];

        int numberOfUniqueUsers = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                boolean currentItemIIsUnique = true;
                for (int j = i + 1; j < users.length; j++) {
                    if (uniqueRule.test(users[i], users[j])) {
                        currentItemIIsUnique = false;
                        break;
                    }
                }
                if (currentItemIIsUnique) {
                    buffArray[numberOfUniqueUsers] = users[i];
                    numberOfUniqueUsers++;
                }
            }
        }

        User[] res = Arrays.copyOfRange(buffArray, 0, numberOfUniqueUsers);
        return res;
    }

    public final static User[] paySalaryToUsers(User[] users) {
        // If there is two equal objects, the method invokes paySalary of each object.
        // But if one object appear in users several times, the method invokes paySalary only once
        User[] uniqueUsers = uniqueObjects(users);

        for (User item : uniqueUsers) {
            item.paySalary();
        }
        return uniqueUsers;
    }

    public static User[] usersWithConditionalBalance(User[] users, int balance) {
        User[] res;
        res = selectNotEmptyUsers(uniqueUsers(users), (User u) -> u.getBalance() == balance);
        return res;
    }

    public static final long[] getUsersId(User[] users) {
        long[] ids = new long[users.length];

        for (int i = 0; i < users.length; i++) {
            ids[i] = (users[i] == null) ? -1 : users[i].getId();
        }
        return ids;
    }

    public static final User[] deleteEmptyUsers(User[] users) {
        User[] res;
        res = selectNotEmptyUsers(users, (u) -> !u.isAnonymous());
        return res;
    }

    public static final User[] selectNotEmptyUsers(User[] users, Predicate<User> selector) {
        int numberOfUsers = 0;
        User[] bufArray = new User[users.length];

        for (User item : users) {
            if (item != null && selector.test(item)) {
                bufArray[numberOfUsers] = item;
                numberOfUsers++;
            }
        }

        User[] res = Arrays.copyOfRange(bufArray, 0, numberOfUsers);
        return res;
    }
}
