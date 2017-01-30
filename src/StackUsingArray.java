public class StackUsingArray {

	int top;
	int array[];
	int capacity;

	public StackUsingArray(int capacity) {
		this.capacity = capacity;
		array = new int[capacity];
		top = -1;
	}

	// check if stack is empty
	public boolean isEmpty() {
		return (top == -1);
	}

	// check if stack is full
	public boolean isFull() {
		return (top == capacity - 1);
	}

	public void push(int data) {
		if (isFull()) {
			System.out.println("Stack Overflow!!");
			return;
		} else {
			array[++top] = data;
		}
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow!!");
			return 0;
		} else {
			int temp;
			temp = array[top];
			--top;
			return temp;
		}
	}
	
	public void print(){
		System.out.println("Print Stack:");
		for(int i = top; i >= 0; i--){
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		StackUsingArray s = new StackUsingArray(5);
		s.push(2);
		s.push(3);
		s.push(5);
		s.print();
		s.push(3);
		s.push(7);
		s.push(9);
		s.print();
		System.out.println("Pop: "+s.pop());
		s.push(9);
		s.print();
		System.out.println("Pop: "+s.pop());
		System.out.println("Pop: "+s.pop());
		System.out.println("Pop: "+s.pop());
		System.out.println("Pop: "+s.pop());
		System.out.println("Pop: "+s.pop());
		System.out.println("Pop: "+s.pop());
	}

}
