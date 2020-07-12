package main.java.com.leetcode;

public class PlusOne {

    public static void main(String[] args) {
        int[] arr = new int[]{1,9,9,9};
        arr = plusOne(arr);
        for (int x:arr)
            System.out.print(x + " ");
    }

    private static int[] plusOne(int[] digits) {
        int sum,carry=0,i,j;
        for(i=digits.length-1;i>=0;i--){
            sum = digits[i] + 1;
            carry = sum/10;
            sum%=10;
            digits[i] = sum;
            if(carry == 0)
                break;
        }
        if(carry == 1){
            int[] result = new int[digits.length+1];
            for(i=0,j=1;i<digits.length;i++,j++){
                result[j] = digits[i];
            }
            result[0] = carry;
            return result;
        }
        else
            return digits;
    }
}
