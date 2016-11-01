package module2;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Администратор on 01.11.16.
 */
public class Task1 {
    public static void main(String[] args) {
        int iarray[] = {9,1,-2,3,4,-5,6,7,-8,9};
        double darray[] = {10000000000000.0001,2,-3.1,4.6,5,-6.4,7,8,9,1.0001};

        BigDecimal b = new BigDecimal(10.1d);
        System.out.println(b);
        System.out.println("The array is "+Arrays.toString(iarray));
        System.out.println("The sum of array elements is " + sum(iarray));
        System.out.println("The minimum element of the array is " + min(iarray));
        System.out.println("The maximum element of the array is " + max(iarray));
        System.out.println("The maximum positive element of the array is " + maxPositive(iarray));
        System.out.println("The multiplication of array elements is " + multiplication(iarray));
        System.out.println("The second largest element of the array is " + secondLargest(iarray));
        System.out.println("The modulus of the first and the last element is "+ modulus(iarray));
        System.out.println("After calculations the array is "+Arrays.toString(iarray));
        System.out.println("");
        System.out.println("The array is "+Arrays.toString(darray));
        System.out.println("The sum of array elements is " + sum(darray));
        System.out.println("The minimum element of the array is " + min(darray));
        System.out.println("The maximum element of the array is " + max(darray));
        System.out.println("The maximum positive element of the array is " + maxPositive(darray));
        System.out.println("The multiplication of array elements is " + multiplication(darray));
        System.out.println("The second largest element of the array is  " + secondLargest(darray));
        System.out.println("The modulus of the first and the last element is "+ modulus(darray));
        System.out.println("After calculations the array is "+Arrays.toString(darray));
    }

    public static long sum(int array[])
    {
        long res = 0;
        for (int item : array)
        {
            res+=item;
        }
        return res;
    }

    public static double sum(double array[])
    {
        double res = 0;
        for (double item : array)
        {
            res+=item;
        }
        return res;
    }

    public static int min(int array[])
    {
        int res = array[0];
        for (int i=1; i<10; i++)
        {
            if (res>array[i]) res=array[i];
        }
        return res;
    }

    public static double min(double array[])
    {
        double res = array[0];
        for (int i=1; i<10; i++)
        {
            if (res>array[i]) res=array[i];
        }
        return res;
    }

    public static int max(int array[])
    {
        int res = array[0];
        for (int i=1; i<10; i++)
        {
            if (res<array[i]) res=array[i];
        }
        return res;
    }

    public static double max(double array[])
    {
        double res = array[0];
        for (int i=1; i<10; i++)
        {
            if (res<array[i]) res=array[i];
        }
        return res;
    }

    public static int  maxPositive(int array[])
    {
        /* Zero isn't a positive number.
         * So if maxPositive returns zero it  means that array doesn't contains positive number.
         */
        int res = 0;
        for (int item : array)
        {
            if ((res<item)&&(item>0)) res=item;
        }

        return res;
    }

    public static double maxPositive(double array[])
    {
        /* Zero isn't a positive number.
         * So if maxPositive returns zero it  means that array doesn't contains positive number.
         */
        double res = 0;
        for (double item : array)
        {
            if ((res<item)&&(item>0)) res=item;
        }

        return res;
    }

    public static long multiplication(int array[])
    {
        long res = 1;
        for (int item : array)
        {
            res*=item;
        }
        return res;
    }

    public static double multiplication (double array[])
    {
        double res = 1;
        for (double item : array)
        {
            res*=item;
        }
        return res;
    }

    public static int modulus(int array[])
    {
        return array[0] % array[9];
    }

    private static int doubleCharacteristic(double n)
    {
        int res = 0;
        n = Math.abs(n);
        while (n>=1) {res++; n/=10;}
        return res;
    }

    /*Such a method is more accurate then array[0] % array[9] for double values
    *
    * The method uses the fact that maximum value of mantissa in double value is 2^52 = 4503599627370496.
    * So mantissa consists of 16 decimal digits or 15 decimal digits that take a value from 0 to 9 (the last digit
    * take a value from 0 to 4)
    * So the accurate fractional part of a double value consists of n=m-r digits. Where m=15 - mantissa length
    * r - characteristic (rank) of a current double value.
    * r is calculated by doubleCharacteristic(double n)
    * Then BigDecimal is used. setScale rounds a double value according to calculated number of digits in accurate
    * fractional part s double value*/
    public static double modulus(double array[])
    {
        BigDecimal res = new BigDecimal(array[0]);
        int NumberOfDigitForRes = 15 - doubleCharacteristic(array[0]);
        res = res.setScale(NumberOfDigitForRes,BigDecimal.ROUND_HALF_UP);

        BigDecimal buf = new BigDecimal(array[9]);
        int NumberOfDigitForBuf = 15 - doubleCharacteristic(array[9]);
        buf = buf.setScale(NumberOfDigitForBuf,BigDecimal.ROUND_HALF_UP);

        BigDecimal countOfRepeating = res.divide(buf,0,BigDecimal.ROUND_HALF_UP);
        res = res.subtract(buf.multiply(countOfRepeating));
        // while (res.abs().compareTo(buf.abs())>=0) res = res.subtract(buf);
        return res.doubleValue();
    }

    public static int secondLargest(int array[])
    {
        //array is cloned to prevent side effect of a function
        int[] localArray = array.clone();
        for (int i=0; i<2; i++)
        {
            for (int j=i+1; j<10; j++)
            {
                if (localArray[i]<localArray[j])
                {
                    int buf=localArray[i];
                    localArray[i]=localArray[j];
                    localArray[j]=buf;
                }
            }
        }

        return localArray[1];
    }

    public static double secondLargest(double array[])
    {
        //array is cloned to prevent side effect of a function
        double[] localArray = array.clone();
        for (int i=0; i<2; i++)
        {
            for (int j=i+1; j<10; j++)
            {
                if (localArray[i]<localArray[j])
                {
                    double buf=localArray[i];
                    localArray[i]=localArray[j];
                    localArray[j]=buf;
                }
            }
        }

        return localArray[1];
    }
}
