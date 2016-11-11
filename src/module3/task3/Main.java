package module3.task3;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by Администратор on 08.11.16.
 */
public class Main {
    public static void main(String[] args) {
        Course[] courses = createCourses();
        Student[] studentList = createStudents(courses);

        System.out.println("List of objects:");

        printListOfObjects(courses,0);
        printListOfObjects(studentList,courses.length);

    }

    private static Course[] createCourses() {
        Course[] courses = new Course[5];
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(2016, Calendar.SEPTEMBER,1);
        courses[0]=new Course(calendar.getTime(),"Mathematics");
        calendar.set(2016,Calendar.OCTOBER,1);
        courses[1]=new Course(calendar.getTime(),"Physics");
        calendar.set(2016,Calendar.NOVEMBER,1);
        courses[2]=new Course(calendar.getTime(),"Biology");
        calendar.set(2016,Calendar.DECEMBER,1);
        courses[3]=new Course(calendar.getTime(),"Chemistry");
        courses[4]=new Course(40,"Computer science","Howard");
        return  courses;
    }

    private static Student[] createStudents(Course[] courses) {
        int groupNumber = 1;
        Course[] newListOfCourses = new Course[3];
        System.arraycopy(courses,2,newListOfCourses,0,newListOfCourses.length);

        Student[] studentList = new Student[9];
        studentList[0] = new Student("Black", Arrays.copyOf(courses,2));
        studentList[1] = new Student("Tom","Green", groupNumber);
        studentList[2] = new CollegeStudent("Gray",Arrays.copyOfRange(courses,2,4));
        studentList[3] = new CollegeStudent("Sem","Backer",groupNumber);
        studentList[4] = new CollegeStudent("MacDonald",newListOfCourses,"California Institute of the Arts",50,getId());
        studentList[5] = new SpecialStudent("Howard",newListOfCourses);
        studentList[6] = new SpecialStudent("Ketty","Allford",groupNumber);
        newListOfCourses[1]=courses[0];   // Change courses for the rest of the students
        studentList[7] = new SpecialStudent("Harrison",newListOfCourses,"Whittier College",50,getId());
        studentList[8] = new SpecialStudent("Watson",newListOfCourses,getSecretKey());
        return studentList;
    }

    //Always returns an even value
    static long getId()
    {
        return UUID.randomUUID().getLeastSignificantBits()<<1;
    }

    //Always returns an uneven value
    static long getSecretKey()
    {
        return getId()+1;
    }

    static void printListOfObjects(Object[] objects, int startNumber)
    {
        int count = startNumber;
        for (Object item:objects) {
            String className = item.getClass().getName();
            String shortClassName = className.substring(className.lastIndexOf('.')+1,className.length());
            System.out.format("%2d%s%n",++count,". "+shortClassName+": "+item);
        }
    }
}
