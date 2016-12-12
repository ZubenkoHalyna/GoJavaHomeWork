package module7;

/**
 * Created by g.zubenko on 11.12.2016.
 */
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String city;
    private int balance;
    private static IdProvider idProvider = UuidProvider.getInstance();
    private static UserComparator byNameComparator = new UserComparator(
            (User u1, User u2) -> u1.getFullName().compareTo(u2.getFullName()));
    private static UserComparator byCityAndNameComparator = new UserComparator(
            (User u1, User u2) -> (u1.city.equals(u2.city))?
                    u1.getFullName().compareTo(u2.getFullName()):
                    u1.city.compareTo(u2.city));
    private static UserComparator byBalanceComparator = new UserComparator(
            (User u1, User u2) -> u1.balance-u2.balance);

    public User(String firstName, String lastName, String city, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.balance = balance;
        this.id = getNewId();
    }

    public User(User userToCopy) {
        id = userToCopy.id;
        firstName = userToCopy.firstName;
        lastName = userToCopy.lastName;
        city = userToCopy.city;
        balance = userToCopy.balance;
    }

    protected long getNewId()
    {
        return idProvider.getNewId();
    }

    public String getFullName() {
        return firstName + ' ' +lastName;
    }

    public String getShortDescription() {
        return getFullName()+ ", city="+city;
    }

    @Override
    public String toString() {
        return "firstName=" + firstName +
                ", lastName=" + lastName +
                ", id=" + id +
                ", city=" + city +
                ", balance=" + balance ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!firstName.equals(user.firstName)) return false;
        return lastName.equals(user.lastName);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    public static UserComparator getByNameComparator() {
        return byNameComparator;
    }

    public static UserComparator getByCityAndNameComparator() {
        return byCityAndNameComparator;
    }

    public static UserComparator getByBalanceComparator() {
        return byBalanceComparator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
