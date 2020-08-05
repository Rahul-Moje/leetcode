package main.java.com.leetcode;

import java.util.Scanner;

public class ValidPalindrome {
    /**
     *
     * Given a string, determine if it is a palindrome,
     * considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     *
     * Input: "race a car"
     * Output: false
     *
     *
     * Constraints:
     *
     * s consists only of printable ASCII characters.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        boolean result = isPalindrome(sentence);
        System.out.println('a'- 'a');
        System.out.println(result);
    }

    private static boolean isPalindrome(String sentence) {
        for(int i=0,j= sentence.length()-1;i<j;i++,j--)
        {
            if(ignore(sentence.charAt(i))) {
                j++;
                continue;
            }
            if(ignore(sentence.charAt(j))) {
                i--;
                continue;
            }
            if(notSame(sentence.charAt(i),sentence.charAt(j)))
                return false;
        }
        return true;
    }

    private static boolean notSame(char i, char j) {
        if(((i>='A' && i<='Z') || (i>='a') && (i<='z'))
        && ((j>='A' && j<='Z') || (j>='a') && (j<='z')))
            return !(Math.abs(i-j) == 0 || Math.abs(i-j) == 32);
        else if(i>='0' && i<='9' && j>='0' && j<='9')
            return !(Math.abs(i-j) == 0);
        return true;
    }

    private static boolean ignore(char ch) {
        return !((ch >= 'a' && ch <= 'z') || (ch >='A' && ch <= 'Z') || (ch >= '0' && ch <= '9'));
    }
}
