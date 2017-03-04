package Algoritms;

import java.math.BigDecimal;
import java.util.Arrays;

public class GreedlyAlgorytm {

    public static void main(String[] args)
    {
        int amount = 999998;
        int[] coins = {20,10,5,1};
        int num;

        for(int i = 0; i < coins.length; i++)
        {
            if (coins[i] <= amount)
            {
                num = amount / coins[i];
                System.out.println(num + " " + "$" + coins[i]);
                amount = amount - (num * coins[i]);
            }
        }
    }
}
