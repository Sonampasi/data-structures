import java.util.Stack;

public class Parentheses {
	Stack<Character> stack = new Stack();

	public boolean isValid(String s) {
		//if only one character exist, return false
		if (s.length() == 1) {
			return false;
		} else {
			int i = 0;
			boolean isMatched = false;
			//Iterate over string s using i 
			while (i < s.length()) {
				//push current string's character into the stack
				stack.push(s.charAt(i));
				//if there is only one character in the stack
				if (stack.size() == 1) {
					i++;
					if(i == s.length()){
						return false;
					}
					stack.push(s.charAt(i));
				}
				//pop two characters
				char popA = (char) stack.pop();
				char popB = (char) stack.pop();
				//compare popped characters
				if ((popB == '[' && popA == ']') || (popB == '{' && popA == '}') || (popB == '(' && popA == ')')) {
					isMatched = true;
					i++;
				} else {
					//push back the popped characters
					stack.push(popB);
					stack.push(popA);
					i++;
				}
			}
			//if stack is empty and isMatched is true
			if (stack.empty()) {
				return isMatched;
			}
		}
		return false;
}

public static void main(String args[]) {
	Parentheses p = new Parentheses();
	String s = "[])";
		System.out.print(p.isValid(s));
	}
}
