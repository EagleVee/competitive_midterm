import java.lang.*;
import java.util.*;

public class Change {

    static int getMinCoins(int value, int coinNum, int[] coinValues) {
        int[] mapMinCoin = new int[value + 1];
        mapMinCoin[0] = 0;

        for (int j = 1; j <= value; j++) {
            int minimum = Integer.MAX_VALUE;

            for (int i = 0; i < coinNum; i++) {
                if (j >= coinValues[i]) {
                    if ((1 + mapMinCoin[j - coinValues[i]]) < minimum) {
                        minimum = 1 + mapMinCoin[j - coinValues[i]];
                    }
                }
            }
            mapMinCoin[j] = minimum;
        }

        return mapMinCoin[value];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int coinNum = sc.nextInt();
        int[] coinValue = new int[coinNum];

        for (int i = 0; i < coinNum; i++) {
            coinValue[i] = sc.nextInt();
        }

        int minCoins = getMinCoins(value, coinNum, coinValue);
        System.out.println(minCoins);
    }
}
