package module4;

import javafx.print.Collation;

import java.util.*;
import java.util.function.UnaryOperator;

import static java.lang.Float.POSITIVE_INFINITY;

/**
 * Created by g.zubenko on 13.11.2016.
 */
public class Main {

    public static void main(String[] args) {

        setConstants();

        Bank[] banks = createBanks();
        User[] users = createUsers(banks);

        printListOfObjects(banks);
        printListOfObjects(users);

        BankSystem bankSystem = new BankSystem();
        BankSystemFunctionalInterface[] operations = createArrayOfOperations(bankSystem);

        executeTransactions(6, users, operations);
    }

    private static void executeTransactions(int NumberOfOperations, User[] users, BankSystemFunctionalInterface[] operations) {
        Random r = new Random();
        for(int i=0; i<NumberOfOperations; i++) {
            int numberOfOperation = r.nextInt(operations.length);
            int numberOfFirstUser = r.nextInt(users.length);
            int numberOfSecondUser = r.nextInt(users.length);
            int amount = r.nextInt(5000);

            Transaction t = operations[numberOfOperation].ExecuteTransaction(users[numberOfFirstUser], users[numberOfSecondUser], amount);
            System.out.println(t);
        }
    }

    private static BankSystemFunctionalInterface[] createArrayOfOperations(BankSystem bankSystem) {
        BankSystemFunctionalInterface[] operations = new BankSystemFunctionalInterface[4];
        operations[0] = (User fromUser, User toUser, int amount)-> bankSystem.transferMoney(fromUser, toUser, amount);
        operations[1] = (User fromUser, User toUser, int amount)-> bankSystem.paySalary(fromUser);
        operations[2] = (User fromUser, User toUser, int amount)-> bankSystem.fundUser(fromUser, amount);
        operations[3] = (User fromUser, User toUser, int amount)-> bankSystem.withdrawOfUser(fromUser, amount);
        return operations;
    }

    private static User[] createUsers(Bank[] banks) {
        User[] users = new User[6];
        users[0]=new User(getNewId(),"Bill",10000,24,"The best company",1000,banks[0]);
        users[1]=new User(getNewId(),"Paul",1000,24,"Good company",1000,banks[1]);
        users[2]=new User(getNewId(),"John",5000,24,"Good company",1000,banks[2]);
        users[3]=new User(getNewId(),"Mary",100,24,"Bad company",1000,banks[3]);
        users[4]=new User(getNewId(),"Mark",0,24,"Bad company",1000,banks[4]);
        users[5]=new User(getNewId(),"Alex",7000,24,"Good company",1000,banks[5]);
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

    static long getNewId()
    {
        return (UUID.randomUUID().getLeastSignificantBits());
    }

    static void printListOfObjects(Object[] objects)
    {
        int count = 0;
        String simpleName = objects.getClass().getSimpleName();
        System.out.println("\nList of "+simpleName.substring(0,simpleName.length()-2).toLowerCase()+"s:");
        for (Object item:objects) {
            System.out.format("%2d%s%n", ++count, ". " + item);
        }
    }
}
