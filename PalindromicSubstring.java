
public class PalindromicSubstring {

	public static void main(String[] args) {
		/*
		 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
		 * */
		
		
		
		/*
		 * String input = "lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuq"
		 * + "bmtzwdkihbwkrjefrsgjbrycembzzlwhxneii" +
		 * "jgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcva" +
		 * "waiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekea" +
		 * "xezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbe" +
		 * "zoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgva" +
		 * "vqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlo" +
		 * "wslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlols" +
		 * "ltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlv" +
		 * "khwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhw" +
		 * "argbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpv" +
		 * "diwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzu" +
		 * "prywlypxeezaxoqfges";
		 */
		String input = "geeks";
		System.out.println(longestPalindrome(input));
		System.out.println(longestPalindromeDP(input));
		
		
		
	}
	
	private static String longestPalindromeDP(String input) {
		//Using DP
		int n = input.length();
		int dp[][] = new int[n][n];
		String palindrome = input.charAt(0) + "";
		for(int i=0;i<n;i++)
			dp[i][i] = 1;
		for(int i=0;i<n-1;i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				dp[i][i+1] = 1;
				palindrome = input.substring(i,i+2);
			}
		}
		
		
		int currDiff = 2;
		int totalDiff = n-1;
		while(currDiff<=totalDiff) {
			for(int i=0;i<n-currDiff;i++) {
				System.out.println("String considered - " + input.substring(i,i+currDiff+1));
				System.out.println("first char - " + input.charAt(i));
				System.out.println("last char - " + input.charAt(i+currDiff));
				System.out.println("bichka - " + input.substring(i+1,i+currDiff));
				System.out.println("uska value in DP " + dp[i+1][i+currDiff-1]);
				if(input.charAt(i) == input.charAt(i+currDiff)
						&& dp[i+1][i+currDiff-1] == 1) {
					System.out.println("Found palindrome " + input.substring(i,i+currDiff+1));
					dp[i][i + currDiff] = 1;
					System.out.println("Current palindrome - " + palindrome);
					String check = input.substring(i,i+currDiff+1);
					if(check.length() > palindrome.length())
						palindrome = check;
					
						
				}
			}
			currDiff++;
		}
			
		
		for(int i=0;i<n-2;i++)
			for(int j=i+2;j<n;j++) {
				if(input.charAt(i) == input.charAt(j)
						&& dp[i+1][j-1]==1) {
					dp[i][j] = 1;
					if((j-i) > palindrome.length())
						palindrome = input.substring(i,j+1);
				}
			}
		/*for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}*/
		return palindrome;
	}
	
	public static String longestPalindrome(String input) {
	     
        if(input.length() == 0)
        	return "";
        int start=0,end=0;
        int length1,length2,length;
        for(int i=0;i<input.length();i++) {
        	length1 = centre(input,i,i);
        	length2 = centre(input,i,i+1);
        	length = Math.max(length1, length2);
        	if(length>end-start ) {
        		end = i + (length/2);
        		start = i - (length/2);
        		if(length%2==0)
        			start++;
        	}
        	
        }
        return input.substring(start,end+1);
    }
	
	public static int centre(String input,int left,int right) {
		while(left>=0 //indexoutofbound handlers
				&& 
				right<input.length() //indexoutofboundhandlers, 
				//also useful when i is the last character
				&& input.charAt(left) == input.charAt(right)) {
			left--;
			right++;
		}
		return right-left-1;
		
	}

	
	
	

}
