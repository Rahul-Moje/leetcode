
public class PalindromicInteger {

	public static void main(String[] args) {
		//Determine whether an integer is a palindrome. 
		//An integer is a palindrome when it reads the same backward as forward.
		isPalindrome(123);

	}
	
	public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else if(x>=0 && x<=9)
            return true;
        else{
            int digits = 0;
		int copy = x;
		while(copy!=0) {
			copy/=10;
			digits++;
		}
		copy = x;
		int dig[] = new int[digits];
		for(int i=0;i<digits;i++) {
			dig[i] = copy%10;
			copy/=10;
		}
		boolean flag = true;
		for(int i=0,j=digits-1;i<=j;i++,j--) {
			if(dig[i]!=dig[j]) {
				flag = false;
				break;
			}
		}
		    return flag;
        }
        
    }

}
