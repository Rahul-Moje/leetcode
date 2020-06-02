import java.util.Scanner;

public class Substring {

	/*
	 * Given a string, 
	 * find the length of the longest substring without repeating characters.
	 * Input: "abcabcbb"
	 * Output: 3 
	 * Explanation: The answer is "abc", with the length of 3. 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(new Solution().lengthOfLongestSubstring(input));

	}

}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int currIndex = 0;
        String subString = "";
        if(s.length() == 0)
        	return 0;
        for(int i=0;i<s.length();i++) {
        	char ch = s.charAt(i);
        	if(subString.indexOf(ch) == -1) {
        		subString += ch;
        		if(subString.length() > maxCount)
        			maxCount = subString.length();
        	}
        	else {
        		while(s.charAt(--i) != ch);
        		subString = "";
        	}
        }
    	return maxCount;
    }
}
