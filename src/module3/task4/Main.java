package module3.task4;

/**
 * Created by Администратор on 10.11.16.
 */
public class Main {
    //The method tests the class User
    public static void main(String[] args) {

        User user = createTestUser();
        testCompanyNameLength(user);
        testMonthIncreaser(user);
        testWithdraw(user);
        testPaySalary(user);
    }

    private static void testPaySalary(User testUser) {
        System.out.println("\nTest of paySalary method:");
        printCurrentBalance(testUser);
        System.out.println(testUser.getName()+"'s salary is "+testUser.getSalary());
        testUser.paySalary();
        System.out.println("Try to pay salary");
        printCurrentBalance(testUser);
    }

    private static void testWithdraw(User testUser) {
        System.out.println("\nTest of withdraw method:");
        testWithdrawOneIteration(testUser,3000);
        testWithdrawOneIteration(testUser,2000);
        testWithdrawOneIteration(testUser,700);
        testWithdrawOneIteration(testUser,1100);
    }

    private static void testWithdrawOneIteration(User testUser, int summ) {
        int initialBalance = testUser.getBalance();
        System.out.println();
        printCurrentBalance(testUser);
        System.out.println("Try to withdraw "+summ);
        testUser.withdraw(summ);
        printCurrentBalance(testUser);
        if (initialBalance==testUser.getBalance())
        {
            System.out.println("Balance didn't change. Withdrawal didn't complete. Balance < transaction amount");
        }
        else
        {
            int commissionRate = (summ<1000)?5:10;
            System.out.println("Balance changed. Withdrawal completed. Commission = "+commissionRate+"%");
        }
    }

    private static void printCurrentBalance(User testUser) {
        System.out.println("Current balance = "+testUser.getBalance());
    }

    private static User createTestUser() {
        User user = new User("Gala",2000,24,"TK SAT",5000,"USD");
        System.out.println("The user was created. Name = "+user.getName()+", balance = "+user.getBalance()+
                ", months of employment = "+user.getMonthsOfEmployment()+", company name = \""+user.getCompanyName()+
                "\", salary = "+user.getSalary()+", currency = "+user.getCurrency());

        return user;
    }

    private static void testCompanyNameLength(User testUser)
    {
        System.out.println("\nTest of testCompanyNameLength method:");
        System.out.println(testUser.getName() + "'s company name (\"" + testUser.getCompanyName() +
                "\") length = " + testUser.companyNameLength());
    }

    private static void testMonthIncreaser(User testUser) {
        int NumberOfMonth = 6;
        System.out.println("\nTest of monthIncreaser method:");
        System.out.println("Current months of employment = "+testUser.getMonthsOfEmployment());
        testUser.monthIncreaser(NumberOfMonth);
        System.out.println("Months of employment increased on "+NumberOfMonth);
        System.out.println("Current months of employment = "+testUser.getMonthsOfEmployment());
    }
}
