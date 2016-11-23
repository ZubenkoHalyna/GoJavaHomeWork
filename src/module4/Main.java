package module4;

import java.util.*;

/**
 * Created by g.zubenko on 13.11.2016.
 */
public class Main {
    private static final int MAX_OPERATIONS_AMOUNT = 3000;
    private static Random r = new Random();

    public static void main(String[] args) {
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
        Transaction[][] tr = new Transaction[4][userArray.length];

        for (int i = 0; i < userArray.length; i++) {
            tr[0][i] = bankSystem.withdrawOfUser(userArray[i], r.nextInt(MAX_OPERATIONS_AMOUNT));
            tr[1][i] = bankSystem.fundUser(userArray[i], r.nextInt(MAX_OPERATIONS_AMOUNT));
            tr[2][i] = bankSystem.paySalary(userArray[i]);
            User randomUser = userArray[getDifferentRandomWithTheSameParity(userArray.length,i)];
            tr[3][i] = bankSystem.transferMoney(userArray[i], randomUser, r.nextInt(MAX_OPERATIONS_AMOUNT));
        }
        return tr;
    }

    private static int getDifferentRandomWithTheSameParity(int bound, int value) {
        int parity = value%2;

        int newValue = r.nextInt(bound/2);
        while (2*newValue+parity==value) {
            newValue = r.nextInt(bound/2);
        }
        return 2*newValue+parity;
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
            lineLength+=maxLength[i];
        }

        for (int j = 0; j < t[0].length; j++) {
            if (maxLengthOfUserName < t[0][j].getUserFrom().toString().length())
                maxLengthOfUserName = t[0][j].getUserFrom().toString().length();
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
        banks[0] = new USBank(getNewId(), Currency.USD, 1000, 1000, 4, 10000000000L,1000,1200,10000,2147483647,1,2,5,7,6,8);
        banks[1] = new USBank(getNewId(), Currency.EUR, 2000, 1500, 3, 220000000000L,1000,1200,10000,2147483647,1,2,5,7,6,8);
        banks[2] = new EUBank(getNewId(), Currency.USD, 3000, 2500, 2, 500000000000L,2000,2200,20000,10000,1,0,5,7,2,4);
        banks[3] = new EUBank(getNewId(), Currency.EUR, 4000, 3500, 1, 1000000000000L,2000,2200,20000,10000,1,0,5,7,2,4);
        banks[4] = new ChinaBank(getNewId(), Currency.USD, 100, 200, 5, 10000000L,100,150,5000,10000,0,1,3,5,10,11);
        banks[5] = new ChinaBank(getNewId(), Currency.EUR, 50, 150, 6, 1000000L,100,150,5000,10000,0,1,3,5,10,11);
        return banks;
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
