package main.java.com.leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class UglyNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(nthUglyNumber(n));
    }

    private static int nthUglyNumber(int n) {

        List<Integer> intoTwo = new ArrayList<>();
        List<Integer> intoThree = new ArrayList<>();
        List<Integer> intoFive = new ArrayList<>();
        int count = 1;
        int number = 1;
        while (count!=n){
            intoTwo.add(number*2);
            intoThree.add(number*3);
            intoFive.add(number*5);
            number = getNextUgly(intoTwo,intoThree,intoFive);
            count++;
        }
        return number;
    }

    private static int getNextUgly(List<Integer> intoTwo, List<Integer> intoThree, List<Integer> intoFive) {
        int num1 = intoTwo.get(0);
        int num2 = intoThree.get(0);
        int num3 = intoFive.get(0);
        if(num1<=num2 && num1<=num3){
            intoTwo.remove(0);
            if(intoThree.contains(num1))
                intoThree.remove(Integer.valueOf(num1));
            if(intoFive.contains(num1))
                intoFive.remove(Integer.valueOf(num1));
            return num1;
        }
        else if(num2<=num1 && num2<=num3){
            intoThree.remove(0);
            if(intoFive.contains(num2))
                intoFive.remove(Integer.valueOf(num2));
            return num2;
        }
        else {
            intoFive.remove(0);
            return num3;
        }
    }
}
