package module4;

/**
 * Created by g.zubenko on 17.11.2016.
 */
@FunctionalInterface
public interface BankSystemFunctionalInterface{
    Transaction ExecuteTransaction(User uFrom, User uTo, int amount);
}
