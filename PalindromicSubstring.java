
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
