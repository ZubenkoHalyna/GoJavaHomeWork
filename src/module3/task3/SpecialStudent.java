package module3.task3;

/**
 * Created by Администратор on 08.11.16.
 */
public class SpecialStudent extends CollegeStudent {
    private long secretKey;
    private String email;

    public long getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(long secretKey) {
        this.secretKey = secretKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public SpecialStudent(String firstName, String lastName, int group)
    {
        super(firstName, lastName, group);
    }

    public SpecialStudent(String lastName, Course[] coursesTaken)
    {
        super(lastName,coursesTaken);
    }

    public SpecialStudent(String lastName, Course[] coursesTaken, String collegeName, int rating, long id)
    {
        super(lastName, coursesTaken, collegeName, rating, id);
    }

    public SpecialStudent(String lastName, Course[] coursesTaken, long secretKey)
    {
        super(lastName,coursesTaken);
        this.secretKey = secretKey;
    }

    @Override
    public String toString()
    {
        if (secretKey==0) return super.toString(); else
        return getShortFullName()+" (key = "+secretKey+")";
    }
}
