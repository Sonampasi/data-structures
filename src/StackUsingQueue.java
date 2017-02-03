import java.util.Queue;
import java.util.LinkedList;

public class StackUsingQueue {

	Queue<Integer> queue;
	Integer rear;

	public StackUsingQueue() {
		queue = new LinkedList();
		rear = null;
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
		rear = x;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		if (queue.isEmpty()) {
			System.out.println("Stack Underflow!!");
			return -1;
		}
		Integer temp = null;
		int i = 0;
		while (!queue.isEmpty()) {
			temp = queue.remove();
			if (i >= queue.size()) {
				return temp;
			}
			queue.add(temp);
			rear = temp;
			i++;
		}
		return temp;
	}

	/** Get the top element. */
	public int top() {
		if (queue.isEmpty()) {
			System.out.println("Stack Underflow!!");
			return -1;
		} else {
			return rear;
		}
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return (queue.isEmpty());
	}

	public static void main(String args[]) {
		StackUsingQueue obj = new StackUsingQueue();
		obj.push(23);
		obj.push(11);
		obj.push(6);
		obj.push(61);
		System.out.println("Pop: " + obj.pop());
		System.out.println("Pop: " + obj.pop());
		System.out.println("Pop: " + obj.pop());
		System.out.println("Top: " + obj.top());
		boolean param_4 = obj.empty();
		System.out.println(param_4);
	}
}
