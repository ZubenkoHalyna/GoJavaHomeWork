package module10.task3;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        Integer i = null;
        try {
            i.byteValue();
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException occur");
        }
    }
}
