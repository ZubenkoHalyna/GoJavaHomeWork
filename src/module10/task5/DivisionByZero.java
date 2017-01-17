package module10.task5;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class DivisionByZero extends MyException {
    public DivisionByZero(String msg) {
        super(msg);
    }

    public DivisionByZero(String msg, Throwable cause) {
        super(msg, cause);
    }
}
