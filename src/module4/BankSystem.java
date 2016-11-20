package module4;

/**
 * Created by g.zubenko on 20.11.2016.
 */
public interface BankSystem {
    Transaction withdrawOfUser(User user, int amount);
    Transaction fundUser(User user, int amount);
    Transaction transferMoney(User fromUser, User toUser, int amount);
    Transaction paySalary(User user);
}
