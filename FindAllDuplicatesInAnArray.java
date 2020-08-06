import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {

        /**
         * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
         * Find all the elements that appear twice in this array.
         * Could you do it without extra space and in O(n) runtime?
         * Example:
         * Input:
         * [4,3,2,7,8,2,3,1]
         * Output:
         * [2,3]
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = scanner.nextInt();
        List<Integer> results = new FindAllDuplicatesInAnArray().findDuplicates(arr);
        System.out.println(results);
    }

    public List<Integer> findDuplicates(int[] nums) {
        /**
         * Since numbers are between 1 to n, we can use index and multiplication by negative
         * If number at that index is already negative that means this is the second occurence
         * Else Multiply the number at that index by -1
         * For ex - consider array [1,2,3,3,1]
         * arr[0] = 1, so multiply number at position (1-1) i.e 0 by -1, array becomes [-1,2,3,3,1]
         * Go ahead, arr[1] = 2, so multiply number at position (2-1) i.e 1 by -1, array becomes [-1,-2,3,3,1]
         * Go ahead, arr[2] = 3, so multiply number at position (3-1) i.e 2 by -1, array becomes [-1,-2,-3,3,1]
         * Go ahead, arr[3] = 3, bingo!, number at positon (3-1) i.e 2 is already negative
         * This means this is the second occurence, add it to the result list
         * Continue till the end
         */
        List<Integer> results = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int position = Math.abs(nums[i]);
            if(nums[position-1] < 0)
                results.add(position);
            else
                nums[position-1] *= -1;
        }
        return results;
    }
}
