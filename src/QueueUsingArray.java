/* Queue implementation using circular array */

public class QueueUsingArray {

	int n;
	int array[];
	int front;
	int rear;
	int nItems;

	public QueueUsingArray(int capacity) {
		n = capacity; // available capacity of array
		array = new int[n];
		front = rear = -1; // indicates queue is empty
		nItems = 0;
	}

	// check if queue is empty
	public boolean isEmpty() {
		return (front == -1);
	}

	// check if queue is full
	public boolean isFull() {
		return ((rear + 1) % n == front);
	}

	// return front item in the queue
	public int front() {
		if (isEmpty()) {
			return -1;
		}
		return array[front];
	}

	// insert new item at the end of the queue
	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("\nQueue overflow!!");
			return;
		} else if (isEmpty()) {
			front = rear = 0;
		} else {
			rear = (rear + 1) % n;
		}
		array[rear] = item;
		nItems++;
	}

	// remove item from the front of the queue
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue underflow!!");
			return 0;
		} else if (front == rear) {
			front = rear = -1;
		} else {
			front = (front + 1) % n;
		}
		nItems--;
		return front();
	}

	// display inserted items of the queue
	public void print() {

		for (int i = 0; i < nItems; i++) {
			System.out.print(array[(i + front) % n] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray obj = new QueueUsingArray(5);
		obj.enqueue(12);
		obj.enqueue(14);
		obj.enqueue(15);
		obj.enqueue(16);
		obj.enqueue(21);
		obj.print();
		obj.dequeue();
		obj.print();
		obj.enqueue(22);
		obj.enqueue(11);
		obj.print();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.print();
	}

}
