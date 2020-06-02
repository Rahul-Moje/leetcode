import java.io.IOException;
import java.util.Scanner;

public class MedianSortedArrays {

	public static void main(String[] args) {
    	int arr1[] = new int[] {1,3};
    	int arr2[] = new int[] {};
    	double res = Solution.findMedianSortedArrays(arr1,arr2);
    	System.out.println(res);


	}

}
class Solution {

	static double findMedianSortedArrays(int[] arr1, int[] arr2) {
		int length = arr1.length + arr2.length;
		int mergedArray[] = new int[length];
		int j=0,k=0;
		if(arr2.length == 0) {
			int index1 = Math.floorDiv(arr1.length, 2);
			if(length%2 == 0) {
				
				int index2 = index1 - 1;
				return (arr1[index1] + arr1[index2])/(double) 2;
			}
			else
			{
				return arr1[index1];
			}
		}
		if(arr1.length == 0) {
			int index1 = Math.floorDiv(arr2.length, 2);
			if(length%2 == 0) {
				
				int index2 = index1 - 1;
				return (arr2[index1] + arr2[index2])/(double) 2;
			}
			else
			{
				return arr2[index1];
			}
		}
		for(int i=0;i<mergedArray.length;i++)
		{
			if(arr1[j] < arr2[k]) {
				mergedArray[i] = arr1[j];
				j++;
			}
			else {
				mergedArray[i] = arr2[k];
				k++;
			}
			if(j == arr1.length){
				while(k!=arr2.length) {
					mergedArray[++i] = arr2[k++];
				}
			}
			if(k == arr2.length) {
				while(j!=arr1.length)
					mergedArray[++i] = arr1[j++];
			}
		}
		int index1 = Math.floorDiv(length, 2);
		if(length%2 == 0) {
			
			int index2 = index1 - 1;
			return (mergedArray[index1] + mergedArray[index2])/(double) 2;
		}
		else
		{
			return mergedArray[index1];
		}
		
	}
}

