package module2;

/**
 * Created by Администратор on 01.11.16.
 */
public class Task2 {

    final static private int COMMISSION_RATE = 5;

    public static void main(String[] args)
    {
        int balance = 100;
        int withdrawal = 10;

        withdrawMoney(balance,withdrawal);

        balance = 100;
        withdrawal = 99;

        withdrawMoney(balance,withdrawal);
    }

    public static void withdrawMoney(int balance,int withdrawal)
    {
        double commission = COMMISSION_RATE / 100.0 * withdrawal;
        double withdrawAmount = withdrawal + commission;

        if (withdrawAmount > balance)
            System.out.println("NO");
        else {
            System.out.println("OK " + commission + " " + (balance - withdrawAmount));
        }
    }
}
