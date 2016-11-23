package module4;

import java.util.UUID;

/**
 * Created by g.zubenko on 13.11.2016.
 */
public class USBank extends Bank {
    public USBank(long id, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee,
                  long rating, long totalCapital,
                  int limitOfWithdrawalUSD,
                  int limitOfWithdrawalEUR,
                  int limitOfFundingUSD,
                  int limitOfFundingEUR,
                  int monthlyRateUSD,
                  int monthlyRateEUR,
                  int commissionIfUsdAndUpTo1000,
                  int commissionIfUsdAndMoreThan1000,
                  int commissionIfEurAndUpTo1000,
                  int commissionIfEurAndMoreThan1000) {
        super(id, "The United States of America", currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital,
                limitOfWithdrawalUSD,
                limitOfWithdrawalEUR,
                limitOfFundingUSD,
                limitOfFundingEUR,
                monthlyRateUSD,
                monthlyRateEUR,
                commissionIfUsdAndUpTo1000,
                commissionIfUsdAndMoreThan1000,
                commissionIfEurAndUpTo1000,
                commissionIfEurAndMoreThan1000);
    }

    @Override
    public int getLimitOfWithdrawal() {
        return super.getLimitOfWithdrawalDefault();
    }

    @Override
    public int getLimitOfFunding() {
        return super.getLimitOfFundingDefault();
    }

    @Override
    public int getMonthlyRate() {
        return super.getMonthlyRateDefault();
    }

    @Override
    public int getCommission(int summ) {
        return super.getCommissionRateDefault(summ);
    }

}
