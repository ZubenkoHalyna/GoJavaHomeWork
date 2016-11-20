package module4;

import java.util.ArrayList;

/**
 * Created by g.zubenko on 16.11.2016.
 */
public class Transaction {
    private boolean isCanceled;
    private TransactionType type;
    private User userFrom;
    private User userTo;
    private double amount;
    private double balanceUserFromBefore;
    private double balanceUserFromAfter;
    private double balanceUserToBefore;
    private double balanceUserToAfter;

    public Transaction(boolean isCanceled, TransactionType type, User userFrom, double amount,
                       double balanceUserFromBefore, double balanceUserFromAfter) {
        this.isCanceled = isCanceled;
        this.type = type;
        this.userFrom = userFrom;
        this.amount = amount;
        this.balanceUserFromBefore = balanceUserFromBefore;
        this.balanceUserFromAfter = balanceUserFromAfter;
    }

    public Transaction(boolean isCanceled, TransactionType type, User userFrom, User userTo, double amount,
                       double balanceUserFromBefore, double balanceUserToBefore, double balanceUserFromAfter,
                       double balanceUserToAfter) {
        this.isCanceled = isCanceled;
        this.type = type;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.balanceUserFromBefore = balanceUserFromBefore;
        this.balanceUserFromAfter = balanceUserFromAfter;
        this.balanceUserToBefore = balanceUserToBefore;
        this.balanceUserToAfter = balanceUserToAfter;
    }

    @Override
    public String toString() {
        return "Try to" + type.getComment() + amount + " " + userFrom.getBank().getCurrency() + type.getPreposition() +
                userFrom + "'s account" + ((userTo == null) ? "" : " to " + userTo + "'s account") + "...\n" +

                "Bank from = " + userFrom.getBank().bankDescription() + "\n" +
                ((userTo == null) ? "" : "Bank to = " + userTo.getBank().bankDescription() + "\n") +
                "Transaction was" + ((isCanceled) ? "n't" : "") + " executed successfully.\n" +
                userFrom + "'s balance before transaction = " + balanceUserFromBefore + " " + userFrom.getBank().getCurrency() + "\n" +
                userFrom + "'s balance after transaction = " + balanceUserFromAfter + " " + userFrom.getBank().getCurrency() + "\n" +
                ((userTo == null) ? "" : userTo + "'s balance before transaction = " + balanceUserToBefore + " " + userTo.getBank().getCurrency() + "\n" +
                        userTo + "'s balance after transaction = " + balanceUserToAfter + " " + userTo.getBank().getCurrency() + "\n");
    }

    public String[] getToStringArray() {
        char ch = '\n';
        int numberOfChar = 0;
        String searchString = toString();
        int lastPosition = 0;

        do {
            lastPosition = searchString.indexOf(ch, lastPosition+1);
            if (lastPosition > 0) numberOfChar++;
        }
        while (lastPosition > 0);

        String[] list = new String[16];

        int index = 0;
        lastPosition =0;
        while (index!=numberOfChar-1){
            int newPosition = searchString.indexOf(ch, lastPosition+1);
            list[index] = searchString.substring((lastPosition == 0) ? 0 : lastPosition + 1, newPosition);
            lastPosition = newPosition;
            index++;
        }
        list[index] = searchString.substring(lastPosition+1, searchString.length()-1);

        return list;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalanceUserFromBefore(double balanceUserFromBefore) {
        this.balanceUserFromBefore = balanceUserFromBefore;
    }

    public void setBalanceUserFromAfter(double balanceUserFromAfter) {
        this.balanceUserFromAfter = balanceUserFromAfter;
    }

    public void setBalanceUserToBefore(double balanceUserToBefore) {
        this.balanceUserToBefore = balanceUserToBefore;
    }

    public void setBalanceUserToAfter(double balanceUserToAfter) {
        this.balanceUserToAfter = balanceUserToAfter;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public TransactionType getType() {
        return type;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceUserFromBefore() {
        return balanceUserFromBefore;
    }

    public double getBalanceUserFromAfter() {
        return balanceUserFromAfter;
    }

    public double getBalanceUserToBefore() {
        return balanceUserToBefore;
    }

    public double getBalanceUserToAfter() {
        return balanceUserToAfter;
    }
}
