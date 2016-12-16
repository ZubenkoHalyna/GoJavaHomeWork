package module7.task5;

/**
 * Created by g.zubenko on 16.12.2016.
 */
public class Main {
    final static int[] NUMBER_OF_ELEMENTS = {1000, 10000};

    public static void main(String[] args) {
        for (ExecutingTimeCalculator.TypeOfElements typeOfElements : ExecutingTimeCalculator.TypeOfElements.values()) {
            for (ExecutingTimeCalculator.TypeOfArray typeOfArray : ExecutingTimeCalculator.TypeOfArray.values()) {
                System.out.println("" + typeOfArray + "<" + typeOfElements + ">\n-----------------------------------------------------");
                for (int numberOfElement : NUMBER_OF_ELEMENTS) {
                    ExecutingTimeCalculator c = new ExecutingTimeCalculator(ExecutingTimeCalculator.Type.ADD,
                            typeOfArray, typeOfElements, ExecutingTimeCalculator.TypeOfThePart.BEGIN, numberOfElement);
                    for (ExecutingTimeCalculator.Type type : ExecutingTimeCalculator.Type.values()) {
                        for (ExecutingTimeCalculator.TypeOfThePart typeOfThePart : ExecutingTimeCalculator.TypeOfThePart.values()) {
                            c.setTypeOfPart(typeOfThePart);
                            c.setType(type);
                            c.getExecutingTime();
                            System.out.println(c);
                        }
                        System.out.println();
                    }
                }
            }

        }/*
        c.getExecutingTime();
        System.out.println(c);
        c.setType(ExecutingTimeCalculator.Type.SET);
        c.getExecutingTime();
        System.out.println(c);
        c.setType(ExecutingTimeCalculator.Type.REMOVE);
        c.getExecutingTime();
        System.out.println(c);*/
    }
}
