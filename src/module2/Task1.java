package module2;

import java.util.Arrays;

/**
 * Created by Администратор on 01.11.16.
 */
public class Task1 {
    public static void main(String[] args) {
        int iarray[] = {9,1,-2,3,4,-5,6,7,-8,9};

        System.out.println("The array is "+Arrays.toString(iarray));
        System.out.println("The sum of array elements is " + module6.ArraysUtils.sum(iarray));
        System.out.println("The minimum element of the array is " + module6.ArraysUtils.min(iarray));
        System.out.println("The maximum element of the array is " + module6.ArraysUtils.max(iarray));
        System.out.println("The maximum positive element of the array is " + module6.ArraysUtils.maxPositive(iarray));
        System.out.println("The multiplication of array elements is " + module6.ArraysUtils.multiplication(iarray));
        System.out.println("The second largest element of the array is " + module6.ArraysUtils.secondLargest(iarray));
        System.out.println("The modulus of the first and the last element is "+ module6.ArraysUtils.modulus(iarray));
        System.out.println("A reversed array is " + Arrays.toString(module6.ArraysUtils.reverse(iarray)));
        System.out.println("An even elements are "+ Arrays.toString(module6.ArraysUtils.findEvenElements(iarray)));
        System.out.println("After calculations the array is "+Arrays.toString(iarray));
    }

}
