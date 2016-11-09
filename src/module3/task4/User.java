package module3.task4;

import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * Created by Администратор on 08.11.16.
 */
public class User {
    private String name;
    private int balance;
    private int monthsOfEmployment;
    private String companyName;
    private int salary;
    private String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
    }

    public void setMonthsOfEmployment(int monthsOfEmployment) {
        this.monthsOfEmployment = monthsOfEmployment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public User(String name, int balance, int monthsOfEmployment, String companyName, int salary, String currency) {
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.currency = currency;
    }

    public void paySalary() {
        balance += salary;
    }

    public void withdraw(int summ) {
        if (canWithdraw(summ)) {
            balance -= summ;
        }
    }

    protected boolean canWithdraw(int summ) {
        return balance >= summ;
    }

    public int companyNameLength() {

          return companyName.length();
        /* If my own implementation needed
        * int countOfChars = 0;
        * for (char item : companyName.toCharArray()) {
        *    countOfChars++;
        * }
        * return countOfChars;
        */
    }

    public void monthIncreaser(int addMonth) {
        monthsOfEmployment += addMonth;
    }

}
