import java.util.Stack;

public class Parentheses {

	public boolean isValid(String s) {
		int i = 0;
		char c;
		int right = 0;
		int left = 0;
		Stack<Character> stack = new Stack<Character>();
		while (i < s.length()) {
			c = s.charAt(i);
			// consider only for parentheses characters
			if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
				// if stack is not empty and character is right parenthesis, pop
				// the top element
				if (c == ')' || c == '}' || c == ']') {
					if (stack.empty()) {
						return false;
					}
					if ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}')
							|| (stack.peek() == '[' && c == ']')) {
						stack.pop();
					}
				}
				// only push left parenthesis into the stack
				else {
					stack.push(c);
				}
			}
			i++;
		}
		// if stack is empty, all the parenthesis are in matched pair return
		// true
		return stack.empty();
	}

	public static void main(String args[]) {
		Parentheses p = new Parentheses();
		String s1 = "(xyz(abcdo)lkj){asdf}[(456)]"; // true
		System.out.println(p.isValid(s1));
		String s2 = "[(xyz(abcdo)lkj){asdf}[(456)]]]]]]"; // false
		System.out.println(p.isValid(s2));
		String s3 = "(((((xyz(abcdo)lkj){asdf}[(456)]"; // false
		System.out.println(p.isValid(s3));
		String s4 = "([456)]"; // false
		System.out.println(p.isValid(s4));
		String s5 = "()"; // true
		System.out.println(p.isValid(s5));
	}
}
