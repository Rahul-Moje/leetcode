package main.java.com.leetcode;


import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int arr[] = new int[]{-2,0,1,1,2};
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result);
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1.intern());
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3)
            return new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                if (nums[i]+nums[j]+nums[k] == 0){
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k] < 0)
                    j++;
                else
                    k--;
            }
        }
        Iterator<List<Integer>> iterator = result.iterator();
        List<List<Integer>> finalList = new ArrayList<>();
        while (iterator.hasNext())
            finalList.add(iterator.next());
        return finalList;
    }
}
