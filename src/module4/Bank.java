package module4;

/**
 * Created by g.zubenko on 13.11.2016.
 */
public abstract class Bank {
    private long id;
    private String bankCountry;
    private Currency currency;
    private int numberOfEmployees;
    private double avrSalaryOfEmployee;
    private long rating;
    private long totalCapital;
    private int limitOfWithdrawalUSD;
    private int limitOfWithdrawalEUR;
    private int limitOfFundingUSD;
    private int limitOfFundingEUR;
    private int monthlyRateUSD;
    private int monthlyRateEUR;
    private int commissionIfUsdAndUpTo1000;
    private int commissionIfUsdAndMoreThan1000;
    private int commissionIfEurAndUpTo1000;
    private int commissionIfEurAndMoreThan1000;

    abstract int getLimitOfWithdrawal();

    abstract int getLimitOfFunding();

    abstract int getMonthlyRate();

    abstract int getCommission(int summ);

    public double moneyPaidMonthlyForSalary() {
        return avrSalaryOfEmployee * numberOfEmployees;
    }

    public Bank(long id, String bankCountry, Currency currency, int numberOfEmployees, double avrSalaryOfEmployee,
                long rating, long totalCapital, int limitOfWithdrawalUSD, int limitOfWithdrawalEUR,
                int limitOfFundingUSD, int limitOfFundingEUR, int monthlyRateUSD, int monthlyRateEUR,
                int commissionIfUsdAndUpTo1000, int commissionIfUsdAndMoreThan1000, int commissionIfEurAndUpTo1000,
                int commissionIfEurAndMoreThan1000) {
        this.id = id;
        this.bankCountry = bankCountry;
        this.currency = currency;
        this.numberOfEmployees = numberOfEmployees;
        this.avrSalaryOfEmployee = avrSalaryOfEmployee;
        this.rating = rating;
        this.totalCapital = totalCapital;
        this.limitOfWithdrawalUSD = limitOfWithdrawalUSD;
        this.limitOfWithdrawalEUR = limitOfWithdrawalEUR;
        this.limitOfFundingUSD = limitOfFundingUSD;
        this.limitOfFundingEUR = limitOfFundingEUR;
        this.monthlyRateUSD = monthlyRateUSD;
        this.monthlyRateEUR = monthlyRateEUR;
        this.commissionIfUsdAndUpTo1000 = commissionIfUsdAndUpTo1000;
        this.commissionIfUsdAndMoreThan1000 = commissionIfUsdAndMoreThan1000;
        this.commissionIfEurAndUpTo1000 = commissionIfEurAndUpTo1000;
        this.commissionIfEurAndMoreThan1000 = commissionIfEurAndMoreThan1000;
    }

    protected int getLimitOfWithdrawalDefault() {
            if (currency == Currency.USD)
            {
                return limitOfWithdrawalUSD;
            }
            else if (currency == Currency.EUR)
            {
                return limitOfWithdrawalEUR;
            }
            return 0;
        }

    protected int getLimitOfFundingDefault() {
        if (currency == Currency.USD)
        {
            return limitOfFundingUSD;
        }
        else if (currency == Currency.EUR)
        {
            return limitOfFundingEUR;
        }
        return 0;
    }

    protected int getMonthlyRateDefault() {
        if (currency == Currency.USD)
        {
            return monthlyRateUSD;
        }
        else if (currency == Currency.EUR)
        {
            return monthlyRateEUR;
        }
        return 0;
    }

    protected int getCommissionRateDefault(int summ) {
        if (currency == Currency.USD)
        {
            if (summ>1000)
            {
                return commissionIfUsdAndMoreThan1000;
            }
            else
            {
                return commissionIfUsdAndUpTo1000;
            }
        }
        else if (currency == Currency.EUR)
        {
            if (summ>1000)
            {
                return commissionIfEurAndMoreThan1000;
            }
            else
            {
                return commissionIfEurAndUpTo1000;
            }
        }
        return 100;
    }

    public String bankDescription() {
        int limitW = getLimitOfWithdrawal();
        int limitF = getLimitOfFunding();
        return this+": \n"+
                "  commission if amount up to 1000 = "+getCommission(0)+"%\n"+
                "  commission if amount more than 1000 = "+getCommission(1001)+"%\n"+
                "  limit of withdrawal = "+((limitW==2147483647)?"inf":limitW+" "+getCurrency())+"\n"+
                "  limit of funding = "+((limitF==2147483647)?"inf":limitF+" "+getCurrency());
    }

    @Override
    public String toString() {
        return getBankCountry()+" ("+getCurrency()+")";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getAvrSalaryOfEmployee() {
        return avrSalaryOfEmployee;
    }

    public void setAvrSalaryOfEmployee(double avrSalaryOfEmployee) {
        this.avrSalaryOfEmployee = avrSalaryOfEmployee;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(long totalCapital) {
        this.totalCapital = totalCapital;
    }

    public int getLimitOfWithdrawalUSD() {
        return limitOfWithdrawalUSD;
    }

    public void setLimitOfWithdrawalUSD(int limitOfWithdrawalUSD) {
        this.limitOfWithdrawalUSD = limitOfWithdrawalUSD;
    }

    public int getLimitOfWithdrawalEUR() {
        return limitOfWithdrawalEUR;
    }

    public void setLimitOfWithdrawalEUR(int limitOfWithdrawalEUR) {
        this.limitOfWithdrawalEUR = limitOfWithdrawalEUR;
    }

    public int getLimitOfFundingUSD() {
        return limitOfFundingUSD;
    }

    public void setLimitOfFundingUSD(int limitOfFundingUSD) {
        this.limitOfFundingUSD = limitOfFundingUSD;
    }

    public int getLimitOfFundingEUR() {
        return limitOfFundingEUR;
    }

    public void setLimitOfFundingEUR(int limitOfFundingEUR) {
        this.limitOfFundingEUR = limitOfFundingEUR;
    }

    public int getMonthlyRateUSD() {
        return monthlyRateUSD;
    }

    public void setMonthlyRateUSD(int monthlyRateUSD) {
        this.monthlyRateUSD = monthlyRateUSD;
    }

    public int getMonthlyRateEUR() {
        return monthlyRateEUR;
    }

    public void setMonthlyRateEUR(int monthlyRateEUR) {
        this.monthlyRateEUR = monthlyRateEUR;
    }

    public int getCommissionIfUsdAndUpTo1000() {
        return commissionIfUsdAndUpTo1000;
    }

    public void setCommissionIfUsdAndUpTo1000(int commissionIfUsdAndUpTo1000) {
        this.commissionIfUsdAndUpTo1000 = commissionIfUsdAndUpTo1000;
    }

    public int getCommissionIfUsdAndMoreThan1000() {
        return commissionIfUsdAndMoreThan1000;
    }

    public void setCommissionIfUsdAndMoreThan1000(int commissionIfUsdAndMoreThan1000) {
        this.commissionIfUsdAndMoreThan1000 = commissionIfUsdAndMoreThan1000;
    }

    public int getCommissionIfEurAndUpTo1000() {
        return commissionIfEurAndUpTo1000;
    }

    public void setCommissionIfEurAndUpTo1000(int commissionIfEurAndUpTo1000) {
        this.commissionIfEurAndUpTo1000 = commissionIfEurAndUpTo1000;
    }

    public int getCommissionIfEurAndMoreThan1000() {
        return commissionIfEurAndMoreThan1000;
    }

    public void setCommissionIfEurAndMoreThan1000(int commissionIfEurAndMoreThan1000) {
        this.commissionIfEurAndMoreThan1000 = commissionIfEurAndMoreThan1000;
    }
}

