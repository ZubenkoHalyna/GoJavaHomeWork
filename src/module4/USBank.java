package module4;

import java.util.UUID;

/**
 * Created by g.zubenko on 13.11.2016.
 */
public class USBank extends Bank {
    private static int limitOfWithdrawalUSD;
    private static int limitOfWithdrawalEUR;
    private static int limitOfFundingUSD;
    private static int limitOfFundingEUR;
    private static int monthlyRateUSD;
    private static int monthlyRateEUR;
    private static int commissionIfUsdAndUpTo1000;
    private static int commissionIfUsdAndMoreThan1000;
    private static int commissionIfEurAndUpTo1000;
    private static int commissionIfEurAndMoreThan1000;

    public USBank(long id, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee,
                  long rating, long totalCapital) {
        super(id, "The United States of America", currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        return super.getLimitOfWithdrawal(limitOfWithdrawalUSD,limitOfWithdrawalEUR);
    }

    @Override
    public int getLimitOfFunding() {
        return super.getLimitOfFunding(limitOfFundingUSD,limitOfFundingEUR);
    }

    @Override
    public int getMonthlyRate() {
        return super.getMonthlyRate(monthlyRateUSD,monthlyRateEUR);
    }

    @Override
    public int getCommission(int summ) {
        return super.getCommissionRate(summ,commissionIfUsdAndUpTo1000,commissionIfUsdAndMoreThan1000,
                commissionIfEurAndUpTo1000,commissionIfEurAndMoreThan1000);
    }

    public static void setLimitOfWithdrawalUSD(int limitOfWithdrawalUSD) {
        USBank.limitOfWithdrawalUSD = limitOfWithdrawalUSD;
    }

    public static void setLimitOfWithdrawalEUR(int limitOfWithdrawalEUR) {
        USBank.limitOfWithdrawalEUR = limitOfWithdrawalEUR;
    }

    public static void setLimitOfFundingUSD(int limitOfFundingUSD) {
        USBank.limitOfFundingUSD = limitOfFundingUSD;
    }

    public static void setLimitOfFundingEUR(int limitOfFundingEUR) {
        USBank.limitOfFundingEUR = limitOfFundingEUR;
    }

    public static void setMonthlyRateUSD(int monthlyRateUSD) {
        USBank.monthlyRateUSD = monthlyRateUSD;
    }

    public static void setMonthlyRateEUR(int monthlyRateEUR) {
        USBank.monthlyRateEUR = monthlyRateEUR;
    }

    public static void setCommissionIfUsdAndUpTo1000(int commissionIfUsdAndUpTo1000) {
        USBank.commissionIfUsdAndUpTo1000 = commissionIfUsdAndUpTo1000;
    }

    public static void setCommissionIfUsdAndMoreThan1000(int commissionIfUsdAndMoreThan1000) {
        USBank.commissionIfUsdAndMoreThan1000 = commissionIfUsdAndMoreThan1000;
    }

    public static void setCommissionIfEurAndUpTo1000(int commissionIfEurAndUpTo1000) {
        USBank.commissionIfEurAndUpTo1000 = commissionIfEurAndUpTo1000;
    }

    public static void setCommissionIfEurAndMoreThan1000(int commissionIfEurAndMoreThan1000) {
        USBank.commissionIfEurAndMoreThan1000 = commissionIfEurAndMoreThan1000;
    }

    public static int getLimitOfWithdrawalUSD() {
        return limitOfWithdrawalUSD;
    }

    public static int getLimitOfWithdrawalEUR() {
        return limitOfWithdrawalEUR;
    }

    public static int getLimitOfFundingUSD() {
        return limitOfFundingUSD;
    }

    public static int getLimitOfFundingEUR() {
        return limitOfFundingEUR;
    }

    public static int getMonthlyRateUSD() {
        return monthlyRateUSD;
    }

    public static int getMonthlyRateEUR() {
        return monthlyRateEUR;
    }

    public static int getCommissionIfUsdAndUpTo1000() {
        return commissionIfUsdAndUpTo1000;
    }

    public static int getCommissionIfUsdAndMoreThan1000() {
        return commissionIfUsdAndMoreThan1000;
    }

    public static int getCommissionIfEurAndUpTo1000() {
        return commissionIfEurAndUpTo1000;
    }

    public static int getCommissionIfEurAndMoreThan1000() {
        return commissionIfEurAndMoreThan1000;
    }
}
