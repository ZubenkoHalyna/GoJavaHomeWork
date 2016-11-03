package module2;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Администратор on 03.11.16.
 */
public class Task3 {
    final static private BigDecimal COMMISSION_RATE = new BigDecimal(5);

    /* The array "balances" used as initial value. The array "balances" is a input data according to the task,
     * but it can't be used in calculations because of it's type.
     * Current values save in array "currentBalances"*/
    static private int[] balances = {1200, 250, 2000, 500, 3200};
    static private BigDecimal[] currentBalances;

    static private String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

    public static void main(String[] args)
    {
        currentBalances = new BigDecimal[balances.length];
        for(int i=0;i<balances.length; i++)
            //Because of int type of array "balances" use of WorkWithBigDecimal.createExactValue() is needless
            currentBalances[i] = new BigDecimal(balances[i]);

        String ownerName = "Ann";
        double withdrawal = 100.4;
        withdrawMoney(ownerName, withdrawal);

        ownerName = "Oww";
        withdrawal = 490;
        withdrawMoney(ownerName, withdrawal);
    }

    public static void withdrawMoney(String ownerName,double withdrawal)
    {
        int ownerNumber = -1;
        for(int i=0; i<ownerNames.length; i++)
            if (ownerNames[i]==ownerName) ownerNumber = i;

        if (ownerNumber==-1)
        {
            System.out.println(ownerName+" is unregistered");
            return;
        }

        BigDecimal exactWithdrawal = WorkWithBigDecimal.createExactValue(withdrawal);
        BigDecimal commission = exactWithdrawal.multiply(COMMISSION_RATE).divide(new BigDecimal(100),15,BigDecimal.ROUND_HALF_UP);
        BigDecimal withdrawAmount = exactWithdrawal.add(commission);

        if (currentBalances[ownerNumber].compareTo(withdrawAmount)<0)
            System.out.println(ownerName+" NO");
        else {
            currentBalances[ownerNumber]=currentBalances[ownerNumber].subtract(withdrawAmount);
            System.out.println(ownerName + " " + withdrawal + " " + currentBalances[ownerNumber].doubleValue());
        }
    }
}
