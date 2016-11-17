package module4;

/**
 * Created by g.zubenko on 16.11.2016.
 */

public class BankSystem {
    public Transaction withdrawOfUser(User user, int amount)
    {
        boolean isAllowed = canWithdrawOfUser(user, amount);
        double balanceBuf = user.getBalance();
        if (isAllowed){
            withdrawOfUserWithoutCheck(user,amount);
        }
        Transaction t = new Transaction(!isAllowed,TransactionType.WITHDRAWAL,user,amount,balanceBuf,user.getBalance());
        return t;
    }

    private void withdrawOfUserWithoutCheck(User user, int amount)
    {
        user.setBalance(user.getBalance() - getTotalAmount(user, amount));
    }

    private double getTotalAmount(User user, int amount)
    {
        return amount + amount*user.getBank().getCommission(amount)/100.0;
    }

    public Transaction fundUser(User user, int amount){
        boolean isAllowed = canFundToUser(user, amount);
        double balanceBuf = user.getBalance();
        if (isAllowed){
            fundUserWithoutCheck(user, amount);
        }
        Transaction t = new Transaction(!isAllowed,TransactionType.FUNDING,user,amount,balanceBuf,user.getBalance());
        return t;
    }

    private void fundUserWithoutCheck(User user, int amount)
    {
        user.setBalance(user.getBalance() + amount);
    }

    public Transaction transferMoney(User fromUser, User toUser, int amount){
        boolean isAllowed = canTransferMoney(fromUser,toUser, amount);
        double fromUserBalanceBuf = fromUser.getBalance();
        double toUserBalanceBuf = toUser.getBalance();
        if (isAllowed){
            withdrawOfUserWithoutCheck(fromUser,amount);
            fundUserWithoutCheck(toUser,amount);
        }
        Transaction t = new Transaction(!isAllowed,TransactionType.TRANSFERING,fromUser,toUser,amount,fromUserBalanceBuf,toUserBalanceBuf,fromUser.getBalance(),toUser.getBalance());

        return t;
    }

    public Transaction paySalary(User user){
        Transaction t = fundUser(user, user.getSalary());
        t.setType(TransactionType.PAYMENT);

        return t;
    }

    private boolean canWithdrawOfUser(User user, int amount)
    {
        return user.getBank().getLimitOfWithdrawal()>=amount &&
                getTotalAmount(user, amount)<=user.getBalance();
    }

    private boolean canFundToUser(User user, int amount)
    {
        return user.getBank().getLimitOfFunding()>=amount;
    }

    private boolean canTransferMoney(User fromUser, User toUser, int amount)
    {
        return canWithdrawOfUser(fromUser, amount) && canFundToUser(toUser,
                amount) && fromUser.getBank().getCurrency()==toUser.getBank().getCurrency();
    }
}
