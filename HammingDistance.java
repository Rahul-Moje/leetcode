package main.java.com.leetcode;

import java.util.Scanner;

public class HammingDistance {
    public static void main(String[] args) {
        /**
         * The Hamming distance between two integers is
         * the number of positions at which the corresponding bits are different.
         * Example -
         * Input: x = 1, y = 4
         * Output: 2
         * Explanation:
         * 1   (0 0 0 1)
         * 4   (0 1 0 0)
         *        ↑   ↑
         * The above arrows point to positions where the corresponding bits are different.
         */

        Scanner scanner =  new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(hammingDistance(x,y));
    }

    private static int hammingDistance(int x, int y) {
        //Approach 1 - convert integers to binary, count positions where bits are different
        /*StringBuffer xBinary = getBinaryRepresentation(x);
        StringBuffer yBinary = getBinaryRepresentation(y);
        int difference = 0;
        if(xBinary.length() > yBinary.length()){
            difference = xBinary.length() - yBinary.length();
            while (difference!=0) {
                yBinary.insert(0, '0');
                difference--;
            }
        }
        else if(yBinary.length() > xBinary.length()){
            difference = yBinary.length() - xBinary.length();
            while (difference!=0){
                xBinary.insert(0,'0');
                difference--;
            }
        }
        System.out.println(xBinary);
        System.out.println(yBinary);
        difference = getTotalDifferentPositions(xBinary,yBinary);
        return difference;*/

        //Approach 2 X-or both the numbers - bits will be set to 1 if they are different
        //we just need a way to find out how many of the bits are 1 in the result
        // so we "and" the result with 1
        //keep doing it till number is not equal to zero
        // keep right shifting so that we get all one's in individual digit positions
        int result = x ^ y;
        System.out.println("Result is " + result);
        int count = 0;
        while (result > 0){
            System.out.println("Result is " +  result);
            System.out.println("And operator output is " + (result&1));
            count += result &1 ;
            result >>= 1;
        }
        return count;
    }

    private static int getTotalDifferentPositions(StringBuffer xBinary, StringBuffer yBinary) {
        int count = 0;
        for (int i=0;i<xBinary.length();i++){
            if (xBinary.charAt(i) != yBinary.charAt(i))
                count++;
        }
        return count;
    }

    private static StringBuffer getBinaryRepresentation(int number) {
        StringBuffer binaryString = new StringBuffer();
        int bit = 0;
        while (number!=0){
            bit = number%2;
            binaryString.append(bit);
            number/=2;
        }
        return binaryString.reverse();
    }
}
