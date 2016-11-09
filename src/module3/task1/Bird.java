package module3.task1;

/**
 * Created by Администратор on 07.11.16.
 */
public class Bird {

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Bird(String birdName)
    {
        this.name = birdName;
    }

    public void walk()
    {
        System.out.println("I am walking");
    }
    public void fly()
    {
        System.out.println("I am flying");
    }
    public void sing()
    {
        System.out.println("I am singing");
    }
    public void introduce()
    {
        System.out.println("I am "+name);
    }

}
