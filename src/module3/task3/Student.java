package module3.task3;

import java.util.Arrays;

/**
 * Created by Администратор on 08.11.16.
 */
public class Student {
    private String firstName;
    private String lastName;
    private int group;
    private Course[] coursesTaken;
    private int age;

    public Student(String firstName, String lastName, int group)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Student(String lastName, Course[] coursesTaken)
    {
        this.coursesTaken = Arrays.copyOf(coursesTaken,coursesTaken.length);
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return getShortFullName()+ coursesTakenToString();
    }

    protected String coursesTakenToString() {
        return (coursesTaken==null)?"":"\n"+
                String.format("%1$"+(this.getClass().getSimpleName().length()+21)+"s","coursesTaken = ")
                + Arrays.toString(coursesTaken)+" ";
    }

    public String getShortFullName()
    {
        return ((firstName==null)?"":firstName.substring(0,1)+". ")+lastName;
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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Course[] getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(Course[] coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
