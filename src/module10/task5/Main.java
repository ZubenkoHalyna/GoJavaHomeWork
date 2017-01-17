package module10.task5;

import java.util.Random;

/**
 * Created by g.zubenko on 17.01.2017.
 */
public class Main {
    static void g(){
        Random r = new Random();
        switch (r.nextInt(3)){
        case 0: throw new AIsNull("A is Null");
        case 1: throw new BIsNull("B is Null");
        case 2: throw new DivisionByZero("Division by zero");
        }
    }
    public static void main(String[] args) {
        try{
            g();
            System.out.println("correct work");
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
    }
}
