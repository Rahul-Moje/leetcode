import java.util.Stack;

public class ValidParenthesis {
	
	public static void main(String args[]) {
		
		/**
		 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
			An input string is valid if:
			Open brackets must be closed by the same type of brackets.
			Open brackets must be closed in the correct order.
			Note that an empty string is also considered valid.
		 */
		String checker = "]";
		boolean result = isValid(checker);
		System.out.println(result);
	}

	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			switch(ch) {
			case '(': stack.push(ch);break;
			case '{': stack.push(ch);break;
			case '[': stack.push(ch);break;
			case ')': 
				if(!stack.isEmpty() && stack.peek() == '(') 
					stack.pop();
				else
					return false;
				break;
			case '}': 
				if(!stack.isEmpty() && stack.peek() == '{') 
					stack.pop();
				else
					return false;
				break;
			case ']': 
				if(!stack.isEmpty() && stack.peek() == '[') 
					stack.pop();
				else
					return false;
				break;
			default:break;
			}
		}
		return stack.isEmpty();
	}
	
}
