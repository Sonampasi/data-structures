import java.util.Stack;

public class Parentheses {
	Stack<Character> stack = new Stack();

	public boolean isValid(String s) {
		int i = 0;
		char c;
		int right = 0;
		int left = 0;
		while (i < s.length()) {
			c = s.charAt(i);
			// consider only for parentheses characters
			if (c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
				// if stack is not empty and character is right parenthesis, pop
				// the top element
				if (c == ')' || c == '}' || c == ']') {
					if (!stack.empty()) {
						stack.pop();
					}
					right++;
				}
				// only push left parenthesis into the stack
				else {
					stack.push(c);
					left++;
				}
			}
			i++;
		}
		// if stack is empty, all the parenthesis are in matched pair return
		// true
		return (stack.empty() && (right == left));
	}

	public static void main(String args[]) {
		Parentheses p = new Parentheses();
		String s = "(xyz(abcdo)lkj){asdf}[(456)]";
		System.out.print(p.isValid(s));
	}
}
