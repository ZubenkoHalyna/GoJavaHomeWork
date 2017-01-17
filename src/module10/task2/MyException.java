package module10.task2;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class MyException extends Exception{
    private String msg;

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public void reportToConsole(){
        System.out.println(msg);
    }
}
