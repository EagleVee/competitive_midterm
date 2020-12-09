import java.lang.*;
import java.util.*;

public class QPrime {
    static boolean isPrime(int number) {
        for (int i = 2; i <= (int) Math.floor(Math.sqrt(number)); ++i) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    static int getNumberOfPrimeNumbers(int start, int end, int digit) {
        int count = 0;
        if (start > end) {
            return 0;
        }

        if (start > 2 && digit % 2 == 0) {
            return 0;
        }

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                if (i - Math.floor((double) i / 10) * 10 == digit) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int digit = sc.nextInt();
        QPrime qPrime = new QPrime();
        int count = qPrime.getNumberOfPrimeNumbers(start, end, digit);
        System.out.println(count);
    }
}
