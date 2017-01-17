package module10.task5;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class MyException extends RuntimeException {
    public MyException(String msg) {
        super(msg);
    }

    public MyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
