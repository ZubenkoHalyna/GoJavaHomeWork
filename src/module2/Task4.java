package module2;

/**
 * Created by Администратор on 03.11.16.
 */
public class Task4 {
    /* Array "balances" has type int[] according to the task. Variable "withdrawal" has type double also according to
     * the task. So I decided not to save current values in array balances. The array "balances" used only as initial
     * value. Current values save in array "currentBalances" */
    static private int[] balances = {1200, 250, 2000, 500, 3200};
    static private double[] currentBalances;

    static private String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

    public static void main(String[] args) {
        currentBalances = new double[balances.length];
        for(int i=0;i<balances.length; i++)
            currentBalances[i] = balances[i];

        String ownerName = "Oww";
        double withdrawal = 100;
        fundMoney(ownerName,withdrawal);
    }

    public static void fundMoney(String ownerName,double withdrawal)
    {
        int ownerNumber = -1;
        for(int i=0; i<ownerNames.length; i++)
            if (ownerNames[i]==ownerName) ownerNumber = i;

        if (ownerNumber==-1)
            System.out.println(ownerName+" is unregistered");
        else
        {
            currentBalances[ownerNumber]+=withdrawal;
            //Output data should be int according to the task example, so type conversion is used
            System.out.println(ownerName+" "+ (int)currentBalances[ownerNumber]);
        }

    }
}
