package module10.task2;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        try{
            throw new MyException("Test MyException class");
        }
        catch (MyException e){
            e.reportToConsole();
        }
    }
}
