package module3.task3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by Администратор on 08.11.16.
 */
public class Main {
    public static void main(String[] args) {
        Course[] courses = new Course[5];

        Calendar calendar = new GregorianCalendar();
        calendar.set(2016,Calendar.SEPTEMBER,1);
        courses[0]=new Course(calendar.getTime(),"Mathematics");
        calendar.set(2016,Calendar.OCTOBER,1);
        courses[1]=new Course(calendar.getTime(),"Physics");
        calendar.set(2016,Calendar.NOVEMBER,1);
        courses[2]=new Course(calendar.getTime(),"Biology");
        calendar.set(2016,Calendar.DECEMBER,1);
        courses[3]=new Course(calendar.getTime(),"Chemistry");
        courses[4]=new Course(40,"Computer science","Howard");

        int groupNumber = 1;

        Student[] studentList = new Student[9];
        studentList[0] = new Student("Black", courses);
        studentList[1] = new Student("Tom","Green", groupNumber);
        studentList[2] = new CollegeStudent("Gray",courses);
        studentList[3] = new CollegeStudent("Sem","Backer",groupNumber);
        studentList[4] = new CollegeStudent("MacDonald",courses,"California Institute of the Arts",50,getId());
        studentList[5] = new SpecialStudent("Howard",courses);
        studentList[6] = new SpecialStudent("Ketty","Allford",groupNumber);
        studentList[7] = new SpecialStudent("Harrison",courses,"Whittier College",50,getId());
        studentList[8] = new SpecialStudent("Watson",courses,getSecretKey());

        System.out.println("List of objects:");

        printListOfObjects(courses,0);
        printListOfObjects(studentList,courses.length);

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
