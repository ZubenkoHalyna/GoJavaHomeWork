package module2;

import java.math.BigDecimal;

/**
 * Created by Администратор on 03.11.16.
 */
public class WorkWithBigDecimal {
    /* The method uses the fact that maximum value of mantissa in double value is 2^52 = 4503599627370496.
     * So mantissa consists of 16 decimal digits or 15 decimal digits that take a value from 0 to 9 (the last digit
     * take a value from 0 to 4)
     * So the accurate fractional part of a double value consists of n=m-r digits. Where m=15 - mantissa length
     * r - characteristic (rank) of a current double value.
     * BigDecimal is used. setScale rounds a double value according to calculated number of digits in accurate
     * fractional part of a double value*/
    static public BigDecimal createExactValue(double n)
    {
        int rank = 0;
        double NCopy = Math.abs(n);
        while (NCopy>=1)
        {
            rank++;
            NCopy/=10;
        }

        int NumberOfDigits = 15 - rank;
        BigDecimal res = new BigDecimal(n);
        res = res.setScale(NumberOfDigits,BigDecimal.ROUND_HALF_UP);
        return res;
    }
}
