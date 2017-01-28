public class QueueUsingLinkedList {
	ListNode front;
	ListNode rear;

	public QueueUsingLinkedList() {
		front = null;
		rear = null;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public void enQueue(int data) {
		ListNode newNode = new ListNode(data);
		if(rear != null){
			rear.next = newNode;
		}
		rear = newNode;
		if (isEmpty()) {
			front = rear;
		} 
	}

	public void deQueue() {
		//ListNode temp = null;
		if (isEmpty()) {
			System.out.println("Queue underflow!!");
		} else if (front == rear) {
			System.out.println("Queue is Empty!!");
			front = rear = null;
		} else {
			//temp = front;
			front = front.next;
		}
	}

	// print queue
	public void print() {
		// initialize current node
		ListNode current = front;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		QueueUsingLinkedList q = new QueueUsingLinkedList();
		q.enQueue(3);
		q.enQueue(11);
		q.enQueue(23);
		q.enQueue(31);
		q.print();
		q.deQueue();
		q.print();
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.print();
		q.deQueue();
	}

}
