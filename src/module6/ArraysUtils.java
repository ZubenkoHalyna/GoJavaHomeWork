package module6;

/**
 * Created by g.zubenko on 02.12.2016.
 */
public final class ArraysUtils {

    private ArraysUtils(){}

    public static final long sum(int array[])
    {
        long res = 0;
        for (int item : array)
        {
            res+=item;
        }
        return res;
    }

    public static final int min(int array[])
    {
        int res = array[0];
        for (int item : array)
        {
            if (res>item) res=item;
        }
        return res;
    }

    public static final int max(int array[])
    {
        int res = array[0];
        for (int item : array)
        {
            if (res<item) res=item;
        }
        return res;
    }

    public static final int  maxPositive(int array[])
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

    public static final long multiplication(int array[])
    {
        long res = 1;
        for (int item : array)
        {
            res*=item;
        }
        return res;
    }

    public static int modulus(int array[])
    {
        return array[0] % array[array.length-1];
    }

    public static final int secondLargest(int array[])
    {
        //array is cloned to prevent side effect of a function
        int[] localArray = array.clone();
        for (int i=0; i<2; i++)
        {
            for (int j=i+1; j<array.length; j++)
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

    public static int[] reverse(int[] array){
        int[] res = new int[array.length];
        for (int i=0; i<array.length; i++)
        {
            res[i] = array[array.length-i-1];
        }
        return res;
    }

    public static int[] findEvenElements(int[] array){
        int numberOfElements = 0;
        for (int item:array)
        {
            if (item%2==0) {
                numberOfElements++;
            }
        }

        int count = 0;
        int[] res = new int[numberOfElements];
        for (int item:array)
        {
            if (item%2==0 && count<numberOfElements) {
                res[count]=item;
                count++;
            }
        }
        return res;
    }
}