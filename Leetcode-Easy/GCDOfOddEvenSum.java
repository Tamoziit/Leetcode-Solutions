/**
 * Maths
 * for n = 4,
 * Sum of the first 4 odd numbers, sumOdd = 1 + 3 + 5 + 7 = 16
 * Sum of the first 4 even numbers, sumEven = 2 + 4 + 6 + 8 = 20
 * Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.
 * 
 * So, The first n odd numbers sum to n * n
 * First n even numbers sum to n * (n + 1)
 * gcd(sumOdd, sumEven) = gcd(n * n, n * (n + 1))
 * = n * gcd(n, n + 1)
 * = n * 1 [since, gcd(n, n + 1) = 1]
 * = n
 * 
 * Time: O(1)
 * Space: O(1)
 */
public class GCDOfOddEvenSum {

    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}
