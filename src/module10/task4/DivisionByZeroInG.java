package module10.task4;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class DivisionByZeroInG extends RuntimeException{
    public DivisionByZeroInG(String msg) {
        super(msg);
    }

    public DivisionByZeroInG(String msg, Throwable cause) {
        super(msg, cause);
    }
}
