package module10.task4;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class DivisionByZeroInF extends RuntimeException{
    public DivisionByZeroInF(String msg) {
        super(msg);
    }

    public DivisionByZeroInF(String msg, Throwable cause) {
        super(msg, cause);
    }
}
