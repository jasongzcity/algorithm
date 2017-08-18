package NthDigit_400;

/**
 * Find the nth digit of the infinite integer
 * sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 *
 * Example 1:
 * Input:
 * 3
 * Output:
 * 3
 *
 * Example 2:
 * Input:
 * 11
 * Output:
 * 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0,
 * which is part of the number 10.
 */
public class Solution {
    public int findNthDigit(int n) {
        // 3 steps to find the answer
        // notice base to be long type or it may overflow!
        long base = 9,digits = 1;
        while(n>base*digits){
            n-=base*digits;
            digits++;
            base*=10;
        }

        // num is the target number.
        long num = 1;
        for(int i=1;i<digits;i++) num*=10;
        num += (n-1)/digits;

        long digit = (n-1)%digits,rs = 0;
        for(long i=digits;i>digit;i--){
            rs = num%10;
            num/=10;
        }
        return (int)rs;
    }
}
