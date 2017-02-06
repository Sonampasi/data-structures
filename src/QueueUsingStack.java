import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack;
	Integer front;

	/** Initialize your data structure here. */
	public QueueUsingStack() {
		stack = new Stack();
		front = null;
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (empty()) {
			front = stack.push(x);
		} else {
			stack.push(x);
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		Stack<Integer> tempStack = new Stack();
		Integer temp = null;
		int i = 0;
		if (empty()) {
			return -1;
		} else if (stack.size() == 1) {
			return stack.pop();
		} else {
			while (!empty()) {
				temp = stack.pop();
				if (i <= stack.size()) {
					tempStack.push(temp);
					front = temp;
				}
				i++;
			}
			while (!tempStack.empty()) {
				stack.push(tempStack.pop());
			}
			return temp;
		}
	}

	/** Get the front element. */
	public int peek() {
		if (empty()) {
			return -1;
		}
		return front;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return (stack.empty());

	}

	public static void main(String args[]) {
		QueueUsingStack obj = new QueueUsingStack();
		obj.push(1);
		System.out.println(obj.pop());
		obj.push(2);
		System.out.println(obj.peek());			
		System.out.println(obj.empty());
	}
}
