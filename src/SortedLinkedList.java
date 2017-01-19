public class SortedLinkedList {
	
	LinkedList ls = new LinkedList();

	// insert new node in linked list at beginning
	public void add(int data) {
		// create new node
		ListNode newNode = new ListNode(data);
		// create first node
		if (ls.head == null) {
			newNode.next = ls.head;
			ls.head = newNode;
		} else {
			ListNode current = ls.head;
			ListNode temp = null;
			while (current != null && current.data < newNode.data) {
				temp = current;
				current = current.next;
			}
			temp.next = newNode;
			newNode.next = current;
		}

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
