package main.java.com.leetcode;

import java.util.*;

public class SingleNumberThree {

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,1,3,2,5};
        System.out.println(1^2^1^3^2^5);
        System.out.println(3^5);
        arr = new SingleNumberThree().singleNumbers(arr);
        System.out.println(arr.toString());
    }

    private int[] singleNumbers(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for(Integer num : nums)
            if(integers.contains(num))
                integers.remove(num);
            else
                integers.add(num);
        int arr[] = new int[integers.size()];
        int i = 0;
        for(int num : integers)
            arr[i++] = num;
        return arr;
    }
}
