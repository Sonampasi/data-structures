public class SortedLinkedList {
	// first node
	ListNode first;

	// LinkedList constructor
	public SortedLinkedList() {
		first = null;
	}

	// insert new node in linked list at beginning
	public void add(int data) {
		// create new node
		ListNode newNode = new ListNode(data);
		// create first node
		if (first == null) {
			newNode.next = first;
			first = newNode;
		} else {
			ListNode head = first;
			ListNode temp = null;
			while (head != null && head.data < newNode.data) {
				temp = head;
				head = head.next;
			}
			temp.next = newNode;
			newNode.next = head;
		}

	}

	// print linked list
	public void print() {
		// initialize current node
		ListNode current = first;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print("\n");
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
