package module7.task5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * Created by g.zubenko on 16.12.2016.
 */
public class ExecutingTimeCalculator {
    enum Type {ADD(" in "), SET(" in "), GET(" from "), REMOVE(" from ");
        private final String inFrom;
        Type(String inFrom) {
            this.inFrom=inFrom;
        }
        public String getInFrom() {
            return inFrom;
        }
    }

    enum TypeOfThePart {BEGIN, MIDDLE, END}

    enum TypeOfArray {LINKED_LIST, ARRAY_LIST}

    enum TypeOfElements {INTEGER, STRING}

    private List list;
    private Type type;
    private TypeOfArray typeOfArray;
    private TypeOfElements typeOfElements;
    private TypeOfThePart typeOfPart;
    private int numberOfElements;
    private IntFunction newValue;
    private double lastOperationTimeInMiliSeconds;

    public ExecutingTimeCalculator(Type type, TypeOfArray typeOfArray, TypeOfElements typeOfElements, TypeOfThePart typeOfPart, int numberOfElements) {
        this.type = type;
        this.typeOfArray = typeOfArray;
        this.typeOfElements = typeOfElements;
        this.typeOfPart = typeOfPart;
        this.numberOfElements = numberOfElements;

        if (typeOfArray == TypeOfArray.ARRAY_LIST) {
            if (typeOfElements == TypeOfElements.INTEGER) {
                list = new ArrayList<Integer>();
            } else if (typeOfElements == TypeOfElements.STRING) {
                list = new ArrayList<String>();
            }
        } else if (typeOfArray == TypeOfArray.LINKED_LIST) {
            if (typeOfElements == TypeOfElements.INTEGER) {
                list = new LinkedList<Integer>();
            } else if (typeOfElements == TypeOfElements.STRING) {
                list = new LinkedList<String>();
            }
        }

        if (typeOfElements == TypeOfElements.INTEGER) {
            newValue = (int i) -> new Integer(i);
        } else if (typeOfElements == TypeOfElements.STRING) {
            newValue = (int i) -> "str " + i;
        }
    }

    public double getExecutingTime() {
        if (list == null) return -1;
        long timeInNanoSeconds = 0;

        if (type == Type.ADD) {
            if (typeOfPart == TypeOfThePart.BEGIN) timeInNanoSeconds = getExecutingTimeForAddInBegin();
            if (typeOfPart == TypeOfThePart.END) timeInNanoSeconds = getExecutingTimeForAddInEnd();
            if (typeOfPart == TypeOfThePart.MIDDLE) timeInNanoSeconds = getExecutingTimeForAddInMiddle();
        }
        if (type == Type.SET) {
            if (typeOfPart == TypeOfThePart.BEGIN) timeInNanoSeconds = getExecutingTimeForSetInBegining();
            else if (typeOfPart == TypeOfThePart.END) timeInNanoSeconds = getExecutingTimeForSetInEnd();
            else if (typeOfPart == TypeOfThePart.MIDDLE) timeInNanoSeconds = getExecutingTimeForSetInMiddle();
        }
        if (type == Type.REMOVE) {
            if (typeOfPart == TypeOfThePart.BEGIN) timeInNanoSeconds = getExecutingTimeForRemoveFromBegining();
            else if (typeOfPart == TypeOfThePart.END) timeInNanoSeconds = getExecutingTimeForRemoveFromEnd();
            else if (typeOfPart == TypeOfThePart.MIDDLE) timeInNanoSeconds = getExecutingTimeForRemoveFromMiddle();
        }
        if (type == Type.GET) {
            if (typeOfPart == TypeOfThePart.BEGIN) timeInNanoSeconds = getExecutingTimeForGetFromBegining();
            else if (typeOfPart == TypeOfThePart.END) timeInNanoSeconds = getExecutingTimeForGetFromEnd();
            else if (typeOfPart == TypeOfThePart.MIDDLE) timeInNanoSeconds = getExecutingTimeForGetFromMiddle();
        }

        //convert nano seconds to milliseconds
        lastOperationTimeInMiliSeconds = (timeInNanoSeconds) / 1000000.0;
        return lastOperationTimeInMiliSeconds;
    }

    private long getExecutingTimeForAddInBegin() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(0, newValue.apply(i));
        }
        long finish = System.nanoTime();

        return finish - start;
    }

    private long getExecutingTimeForAddInEnd() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(newValue.apply(i));
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForAddInMiddle() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(list.size() >> 2, newValue.apply(i));
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForSetInBegining() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.set(0, newValue.apply(i));
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForSetInEnd() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.set(list.size()-1, newValue.apply(i));
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForSetInMiddle() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.set(list.size() >> 2, newValue.apply(i));
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForGetFromBegining() {
        long start = System.nanoTime();
        list.get(0);

        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForGetFromEnd() {
        long start = System.nanoTime();
        list.get(list.size() - 1);

        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForGetFromMiddle() {
        long start = System.nanoTime();
        list.get(list.size() >> 2);

        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForRemoveFromBegining() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.remove(0);
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForRemoveFromEnd() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.remove(list.size() - 1);
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    private long getExecutingTimeForRemoveFromMiddle() {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            list.remove(list.size() >> 2);
        }
        long finish = System.nanoTime();

        return (finish - start);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTypeOfPart(TypeOfThePart typeOfPart) {
        this.typeOfPart = typeOfPart;
    }

    @Override
    public String toString() {
        return "time = " + lastOperationTimeInMiliSeconds +
                " ms, operation = " + type + type.getInFrom() + typeOfPart+
                ", type = " + typeOfArray +
                "<" + typeOfElements +
                ">, number of elements = " + numberOfElements;
    }
}
