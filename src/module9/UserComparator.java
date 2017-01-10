package module9;

import java.util.Comparator;
import java.util.function.ToIntBiFunction;

/**
 * Created by g.zubenko on 11.12.2016.
 */
public class UserComparator implements Comparator<User> {
    private final ToIntBiFunction<User, User> compareRule;

    public UserComparator(ToIntBiFunction<User, User> compareRule) {
        this.compareRule = compareRule;
    }

    @Override
    public int compare(User u1, User u2) {
        return compareRule.applyAsInt(u1,u2);
    }
}

