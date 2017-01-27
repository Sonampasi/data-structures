class DoublyLinkedListNode {
	public int data;// stores input value
	public DoublyLinkedListNode next;// stores reference for next node
	public DoublyLinkedListNode prev;// stores reference for previous node

	// ListNode constructor
	public DoublyLinkedListNode(int data) {
		this.data = data;
	}
}

public class DoublyLinkedList {

	DoublyLinkedListNode head;
	DoublyLinkedListNode temp;

	DoublyLinkedList() {
		head = null;
	}

	// insert new node in doubly linked list at beginning
	public void insertAtHead(int data) {
		// create new node
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		// update the right pointer of new node to current head node
		newNode.next = head;
		// update the left pointer of new node to null
		newNode.prev = null;
		if (head != null) {
			// update the left pointer of head to new node
			head.prev = newNode;
		}
		// make new node as head
		head = newNode;

	}

	// insert new node in doubly linked list at specified position
	public void insertAtPositon(int data, int position)
			throws UnsupportedOperationException {
		int k = 1;
		DoublyLinkedListNode current = head;
		DoublyLinkedListNode temp = null;
		// create new node
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		try {
			if (position == 1 || current == null) {
				insertAtHead(data);
			} else {
				while (current != null) {
					k++;
					if (k == position) {
						temp = current;
						newNode.next = current.next;
						current.next = newNode;
						newNode.prev = temp;
						temp.next.prev = newNode;
						break;
					}
					current = current.next;
				}
				if (position < 1 || position > k) {
					throw new UnsupportedOperationException(
							"Invalid operation !!\n");
				}
			}
		} catch (UnsupportedOperationException e) {
			System.out.print(e);
		}
	}

	// insert new node in linked list at last
	public void insertAtTail(int data) {
		// create new node
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		DoublyLinkedListNode current = head;
		DoublyLinkedListNode previous = null;
		while (current != null) {
			previous = current;
			current = current.next;
		}
		newNode.prev = previous;
		previous.next = newNode;
	}

	// print doubly linked list
	public void print() {
		// initialize current node
		DoublyLinkedListNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.print("\n");
	}

	public static void main(String[] args) {
		DoublyLinkedList dls = new DoublyLinkedList();
		dls.insertAtHead(12);
		dls.insertAtHead(18);
		dls.insertAtHead(10);
		dls.print();
		dls.insertAtPositon(11, 2);
		dls.print();
		dls.insertAtPositon(1, 1);
		dls.print();
		dls.insertAtPositon(60, 10);
		dls.print();
	}

}
