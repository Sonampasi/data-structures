public class SortedLinkedList {

	LinkedList ls = new LinkedList();

	// insert new node in ascending order into the linked list
	public void add(int data) {
		// create new node
		ListNode newNode = new ListNode(data);
		int position = 1;
		ListNode current = ls.head;
		// ListNode temp = null;
		while (current != null && current.data < newNode.data) {
			// temp = current;
			position++;
			current = current.next;
		}
		ls.insertAtPositon(data, position);

	}

	// print linked list
	public void print() {
		// initialize current node
		ls.print();
	}

	public static void main(String args[]) {

		SortedLinkedList list = new SortedLinkedList();
		list.add(1);
		list.add(11);
		list.add(10);
		list.add(19);
		list.add(15);
		list.add(6);
		list.add(21);
		list.print();
	}

}
