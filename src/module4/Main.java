package module4;

import java.util.*;

/**
 * Created by g.zubenko on 13.11.2016.
 */
public class Main {
    private static final int MAX_OPERATIONS_AMOUNT = 3000;

    public static void main(String[] args) {
        setConstants();

        Bank[] banks = createBanks();
        User[] users = createUsers(banks);

        printListOfObjects(banks);
        printListOfObjects(users);
        System.out.println();

        BankSystem bankSystem = new BankSystemImpl();
        Transaction[][] tr = executeTransactions(users, bankSystem);
        printTransactions(tr);
    }

    private static Transaction[][] executeTransactions(User[] userArray, BankSystem bankSystem) {
        Random r = new Random();
        Transaction[][] tr = new Transaction[4][userArray.length];

        for (int i = 0; i < userArray.length; i++) {
            tr[0][i] = bankSystem.withdrawOfUser(userArray[i], r.nextInt(MAX_OPERATIONS_AMOUNT));
            tr[1][i] = bankSystem.fundUser(userArray[i], r.nextInt(MAX_OPERATIONS_AMOUNT));
            tr[2][i] = bankSystem.paySalary(userArray[i]);
            User randomUser = userArray[(i + 1) % userArray.length];
            tr[3][i] = bankSystem.transferMoney(userArray[i], randomUser, r.nextInt(MAX_OPERATIONS_AMOUNT));
        }
        return tr;
    }

    private static void printTransactions(Transaction[][] t) {
        String[][][] stringArray = new String[t.length][t[0].length][16];
        int lineLength = 0;
        int[] maxLength = new int[t.length];
        int maxLengthOfUserName = 0;

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                stringArray[i][j] = t[i][j].getToStringArray();
                for (int k = 0; k < 16; k++)
                    if (stringArray[i][j][k] != null && maxLength[i] < stringArray[i][j][k].length())
                        maxLength[i] = stringArray[i][j][k].length();

            }
            if (maxLengthOfUserName < t[i][0].getUserFrom().toString().length())
                maxLengthOfUserName = t[i][0].getUserFrom().toString().length();
            lineLength+=maxLength[i];
        }

        System.out.format("%-" + maxLengthOfUserName + "s", "");
        for (int i = 0; i < t.length; i++)
            System.out.format("%-2s%-" + maxLength[i] + "s", "|", TransactionType.values()[i]);
        System.out.println();
        for (int i = 0; i < lineLength+2*t.length+maxLengthOfUserName; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < t[0].length; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.format("%-" + maxLengthOfUserName + "s", (j == 8) ? t[0][i].getUserFrom() : "");
                for (int k = 0; k < t.length; k++) {
                    System.out.format("%-2s%-" + maxLength[k] + "s", "|", (stringArray[k][i][j] == null) ? "" : stringArray[k][i][j]);
                }
                System.out.println();
            }
            for (int n = 0; n < lineLength+2*t.length+maxLengthOfUserName; n++)
                System.out.print("-");
            System.out.println();
        }
    }

    private static User[] createUsers(Bank[] banks) {
        User[] users = new User[6];
        users[0] = new User(getNewId(), "Bill", 10000, 24, "The best company", 1000, banks[0]);
        users[1] = new User(getNewId(), "Paul", 1000, 24, "Good company", 1000, banks[1]);
        users[2] = new User(getNewId(), "John", 5000, 24, "Good company", 1000, banks[2]);
        users[3] = new User(getNewId(), "Mary", 100, 24, "Bad company", 1000, banks[3]);
        users[4] = new User(getNewId(), "Mark", 0, 24, "Bad company", 1000, banks[4]);
        users[5] = new User(getNewId(), "Alex", 7000, 24, "Good company", 1000, banks[5]);
        return users;
    }

    private static Bank[] createBanks() {
        Bank[] banks = new Bank[6];
        banks[0] = new USBank(getNewId(), Currency.EUR, 1000, 1000, 4, 10000000000L);
        banks[1] = new USBank(getNewId(), Currency.USD, 2000, 1500, 3, 220000000000L);
        banks[2] = new EUBank(getNewId(), Currency.USD, 3000, 2500, 2, 500000000000L);
        banks[3] = new EUBank(getNewId(), Currency.EUR, 4000, 3500, 1, 1000000000000L);
        banks[4] = new ChinaBank(getNewId(), Currency.USD, 100, 200, 5, 10000000L);
        banks[5] = new ChinaBank(getNewId(), Currency.EUR, 50, 150, 6, 1000000L);
        return banks;
    }

    private static void setConstants() {
        USBank.setLimitOfWithdrawalUSD(1000);
        USBank.setLimitOfWithdrawalEUR(1200);
        USBank.setLimitOfFundingUSD(10000);
        USBank.setLimitOfFundingEUR(2147483647);
        USBank.setMonthlyRateUSD(1);
        USBank.setMonthlyRateEUR(2);
        USBank.setCommissionIfUsdAndUpTo1000(5);
        USBank.setCommissionIfUsdAndMoreThan1000(7);
        USBank.setCommissionIfEurAndUpTo1000(6);
        USBank.setCommissionIfEurAndMoreThan1000(8);

        EUBank.setLimitOfWithdrawalUSD(2000);
        EUBank.setLimitOfWithdrawalEUR(2200);
        EUBank.setLimitOfFundingUSD(20000);
        EUBank.setLimitOfFundingEUR(10000);
        EUBank.setMonthlyRateUSD(1);
        EUBank.setMonthlyRateEUR(0);
        EUBank.setCommissionIfUsdAndUpTo1000(5);
        EUBank.setCommissionIfUsdAndMoreThan1000(7);
        EUBank.setCommissionIfEurAndUpTo1000(2);
        EUBank.setCommissionIfEurAndMoreThan1000(4);

        ChinaBank.setLimitOfWithdrawalUSD(100);
        ChinaBank.setLimitOfWithdrawalEUR(150);
        ChinaBank.setLimitOfFundingUSD(5000);
        ChinaBank.setLimitOfFundingEUR(10000);
        ChinaBank.setMonthlyRateUSD(0);
        ChinaBank.setMonthlyRateEUR(1);
        ChinaBank.setCommissionIfUsdAndUpTo1000(3);
        ChinaBank.setCommissionIfUsdAndMoreThan1000(5);
        ChinaBank.setCommissionIfEurAndUpTo1000(10);
        ChinaBank.setCommissionIfEurAndMoreThan1000(11);
    }

    static long getNewId() {
        return (UUID.randomUUID().getLeastSignificantBits());
    }

    static void printListOfObjects(Object[] objects) {
        int count = 0;
        String simpleName = objects.getClass().getSimpleName();
        System.out.println("\nList of " + simpleName.substring(0, simpleName.length() - 2).toLowerCase() + "s:");
        for (Object item : objects) {
            System.out.format("%2d%s%n", ++count, ". " + item);
        }
    }
}
